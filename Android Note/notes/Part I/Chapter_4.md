# [Kotlin Note](../../README.md) - Chapter 4 Icons
| Chapter | Title |
| :-: | :- |
| 4.1 | [Button Icon](#41-button-icon) |
|  | [Creating a Vector Asset](#creating-a-vector-asset) |
|  | [Activity Layout (activity_main.xml)](#activity-layout-activity_mainxml) |
| 4.2 | [App Icon](#42-app-icon) |
|  | [Creating an Image Asset](#creating-an-image-asset) |
| 4.3 | [Demonstration](#43-demonstration) |

<br />

## 4.1 Button Icon
### Creating a Vector Asset
![](../../images/Part%20I/image_4_1.PNG)
![](../../images/Part%20I/image_4_2.PNG)
![](../../images/Part%20I/image_4_3.PNG)
![](../../images/Part%20I/image_4_4.PNG)
![](../../images/Part%20I/image_4_5.PNG)

### Activity Layout (activity_main.xml)
![](../../images/Part%20I/image_4_6.PNG)

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">

    <TextView
        android:id="@+id/question_text_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:padding="24dp"
        tools:text="@string/question_australia"/>

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <Button
            android:id="@+id/true_button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/true_button"/>

        <Button
            android:id="@+id/false_button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/false_button"/>

    </LinearLayout>

    <Button
        android:id="@+id/next_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/next_button"
        app:icon="@drawable/arrow_right"
        app:iconGravity="end"/>

</LinearLayout>
```

<br />

## 4.2 App Icon
### Creating an Image Asset
![](../../images/Part%20I/image_4_7.PNG)
![](../../images/Part%20I/image_4_8.PNG)
![](../../images/Part%20I/image_4_9.PNG)
![](../../images/Part%20I/image_4_10.PNG)
![](../../images/Part%20I/image_4_11.PNG)
![](../../images/Part%20I/image_4_12.PNG)
![](../../images/Part%20I/image_4_13.PNG)
![](../../images/Part%20I/image_4_14.PNG)

<br />

## 4.3 Demonstration
On the home screen
![](../../images/Part%20I/image_4_15.PNG)

After started the app
![](../../images/Part%20I/image_4_16.PNG)

<br />
