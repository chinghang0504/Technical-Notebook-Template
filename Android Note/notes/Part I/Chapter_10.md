# [Kotlin Note](../../README.md) - Chapter 10 Getting Result through ActivityResultLauncher
| Chapter | Title |
| :-: | :- |
| 10.1 | [Activity ViewModel (QuizViewModel.kt)](#101-activity-viewmodel-quizviewmodelkt) |
| 10.2 | [Activity Class (MainActivity.kt)](#102-activity-class-mainactivitykt) |
|  | [ActivityResultCaller: registerForActivityResult()](#activityresultcaller-registerforactivityresult) |
|  | [ActivityResultContracts.StartActivityForResult: ActivityResultContracts.StartActivityForResult()](#activityresultcontractsstartactivityforresult-activityresultcontractsstartactivityforresult) |
|  | [ActivityResultLauncher: launch()](#activityresultlauncher-launch) |
| 10.3 | [Activity Class (CheatActivity.kt)](#103-activity-class-cheatactivitykt) |
|  | [Intent: Intent()](#intent-intent) |
|  | [Activity: setResult()](#activity-setresult) |
|  | [ActivityResult: data](#activityresult-data) |
| 10.4 | [Demonstration](#104-demonstration) |

<br />

## 10.1 Activity ViewModel (QuizViewModel.kt)
```kotlin
package com.example.geoquiz

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

private const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"
private const val IS_CHEATER_KEY = "IS_CHEATER_KEY"

class QuizViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    private var currentIndex: Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textRestId

    var isCheater: Boolean
        get() = savedStateHandle.get(IS_CHEATER_KEY) ?: false
        set(value) = savedStateHandle.set(IS_CHEATER_KEY, value)

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }
}
```

<br />

## 10.2 Activity Class (MainActivity.kt)
```kotlin
package com.example.geoquiz

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.example.geoquiz.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val quizViewModel: QuizViewModel by viewModels()

    private val cheatLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            quizViewModel.isCheater = CheatActivity.getAnswerShown(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Calling onCreate()")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.trueButton.setOnClickListener {
            checkAnswer(true)
        }
        binding.falseButton.setOnClickListener {
            checkAnswer(false)
        }
        binding.nextButton.setOnClickListener {
            quizViewModel.moveToNext()
            updateQuestion()
        }
        binding.cheatButton.setOnClickListener {
            val answerIsTrue = quizViewModel.currentQuestionAnswer
            val intent = CheatActivity.newIntent(this@MainActivity, answerIsTrue)
            cheatLauncher.launch(intent)
        }

        updateQuestion()
    }

    private fun updateQuestion() {
        val questionTextResId = quizViewModel.currentQuestionText
        binding.questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = quizViewModel.currentQuestionAnswer

        val messageResId = when {
            quizViewModel.isCheater -> R.string.judgment_toast
            userAnswer == correctAnswer -> R.string.correct_toast
            else -> R.string.incorrect_toast
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Calling onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Calling onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Calling onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Calling onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Calling onDestroy()")
    }
}
```

### [ActivityResultCaller: registerForActivityResult()](https://developer.android.com/reference/kotlin/androidx/activity/result/ActivityResultCaller#registerForActivityResult(androidx.activity.result.contract.ActivityResultContract%3CI,O%3E,androidx.activity.result.ActivityResultCallback%3CO%3E))
- Register a request to start an activity for result, designated by the given contract. This creates a record in the registry associated with this caller, managing request code, as well as conversions to/from Intent under the hood. This *must* be called unconditionally, as part of initialization path, typically as a field initializer of an Activity or Fragment.
```kotlin
fun <I, O> registerForActivityResult(
    contract: ActivityResultContract<I!, O!>,
    callback: ActivityResultCallback<O!>
): ActivityResultLauncher<I!>
```

### [ActivityResultContracts.StartActivityForResult: ActivityResultContracts.StartActivityForResult()](https://developer.android.com/reference/kotlin/androidx/activity/result/contract/ActivityResultContracts.StartActivityForResult#StartActivityForResult())
- An ActivityResultContract that doesn't do any type conversion, taking raw Intent as an input and ActivityResult as an output.
```kotlin
StartActivityForResult()
```

### [ActivityResultLauncher: launch()](https://developer.android.com/reference/kotlin/androidx/activity/result/ActivityResultLauncher#launch(I))
- Executes an ActivityResultContract.
```kotlin
fun launch(input: I!): Unit
```

<br />

## 10.3 Activity Class (CheatActivity.kt)
```kotlin
package com.example.geoquiz

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import com.example.geoquiz.databinding.ActivityCheatBinding

private const val EXTRA_ANSWER_IS_TRUE = "com.example.geoquiz.answer_is_true"
private const val EXTRA_ANSWER_SHOW = "com.example.geoquiz.answer_shown"

class CheatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCheatBinding

    private var answerIsTrue = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        answerIsTrue = intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false)

        binding.showAnswerButton.setOnClickListener {
            val answerText = when {
                answerIsTrue -> R.string.true_button
                else -> R.string.false_button
            }
            binding.answerTextView.setText(answerText)
            setAnswerShownResult(true)
        }
    }

    private fun setAnswerShownResult(isAnswerShown: Boolean) {
        val data = Intent().apply {
            putExtra(EXTRA_ANSWER_SHOW, isAnswerShown)
        }
        setResult(Activity.RESULT_OK, data)
    }

    companion object {
        fun newIntent(packageContext: Context, answerIsTrue: Boolean): Intent {
            return Intent(packageContext, CheatActivity::class.java).apply {
                putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue)
            }
        }

        fun getAnswerShown(activityResult: ActivityResult): Boolean {
            return activityResult.data?.getBooleanExtra(EXTRA_ANSWER_SHOW, false) ?: false
        }
    }
}
```

### [Intent: Intent()](https://developer.android.com/reference/kotlin/android/content/Intent#intent_1)
- Create an empty intent.
```kotlin
Intent()
```

### [Activity: setResult()](https://developer.android.com/reference/kotlin/android/app/Activity#setresult_1)
- Call this to set the result that your activity will return to its caller.
```kotlin
fun setResult(
    resultCode: Int, 
    data: Intent!
): Unit
```

### [ActivityResult: data](https://developer.android.com/reference/androidx/activity/result/ActivityResult#getData())
- ActivityResult
    - A container for an activity result as obtained from onActivityResult
```kotlin
public @Nullable Intent getData()
```

<br />

## 10.4 Demonstration
After started the app
![](../../images/Part%20I/image_10_1.PNG)

After clicked the cheat button
![](../../images/Part%20I/image_10_2.PNG)

After clicked the show button
![](../../images/Part%20I/image_10_3.PNG)

After clicked the back button
![](../../images/Part%20I/image_10_4.PNG)

After clicked the true button
![](../../images/Part%20I/image_10_5.PNG)

<br />
