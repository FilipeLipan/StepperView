# StepperView
An Android CustomView that morphs base on the quantity of steps provided

  <img src="https://user-images.githubusercontent.com/16981140/45706436-a123f200-bb52-11e8-88e2-566bf6d12f4d.gif" width="200" height="350" title="Github Logo">

### Usage
  At the time this StepperView has only one attribute, feel free to give me ideas for new properties !!
  
  ```
    app:quantity="2"
    
    <com.filipelipan.stepperview.StepperView
        android:id="@+id/stepper"
        android:layout_width="300dp"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:quantity="3"
        app:titles="@array/test_array"
        tools:ignore="MissingConstraints" />
```

