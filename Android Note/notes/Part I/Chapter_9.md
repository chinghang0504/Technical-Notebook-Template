# [Kotlin Note](../../README.md) - Chapter 9 Passing Data through Intent
| Chapter | Title |
| :-: | :- |
| 9.1 | [Activity Class (MainActivity.kt)](#91-activity-class-mainactivitykt) |
| 9.2 | [Activity Class (CheatActivity.kt)](#92-activity-class-cheatactivitykt) |
|  | [Intent: putExtra()](#intent-putextra) |
|  | [Intent: getBooleanExtra()](#intent-getbooleanextra) |
| 9.3 | [Demonstration](#93-demonstration) |

<br />

## 9.1 Activity Class (MainActivity.kt)
```kotlin
package com.example.geoquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.geoquiz.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val quizViewModel: QuizViewModel by viewModels()

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
            startActivity(intent)
        }

        updateQuestion()
    }

    private fun updateQuestion() {
        val questionTextResId = quizViewModel.currentQuestionText
        binding.questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = quizViewModel.currentQuestionAnswer

        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
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

<br />

## 9.2 Activity Class (CheatActivity.kt)
```kotlin
package com.example.geoquiz

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.geoquiz.databinding.ActivityCheatBinding

private const val EXTRA_ANSWER_IS_TRUE = "com.example.geoquiz.answer_is_true"

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
        }
    }

    companion object {
        fun newIntent(packageContext: Context, answerIsTrue: Boolean): Intent {
            return Intent(packageContext, CheatActivity::class.java).apply {
                putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue)
            }
        }
    }
}
```

### [Intent: putExtra()](https://developer.android.com/reference/kotlin/android/content/Intent#putextra)
- Add extended data to the intent. The name must include a package prefix, for example the app com.android.contacts would use names like "com.android.contacts.ShowAll".
```kotlin
open fun putExtra(
    name: String!, 
    value: Boolean
): Intent
```

### [Intent: getBooleanExtra()](https://developer.android.com/reference/kotlin/android/content/Intent#getbooleanextra)
- Retrieve extended data from the intent.
```kotlin
open fun getBooleanExtra(
    name: String!, 
    defaultValue: Boolean
): Boolean
```

<br />

## 9.3 Demonstration
After started the app
![](../../images/Part%20I/image_9_1.PNG)

After clicked the cheat button
![](../../images/Part%20I/image_9_2.PNG)

After clicked the show button
![](../../images/Part%20I/image_9_3.PNG)

<br />
