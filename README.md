# StepperView
An Android CustomView that morphs base on the quantity of steps provided

  <img src="https://user-images.githubusercontent.com/16981140/45644476-32805f00-ba94-11e8-953d-7a5b963393a0.png" width="200" height="350" title="Github Logo">

### Usage
  At the time this StepperView has only one attribute, feel free to give me ideas for new properties !!
  
  ```
    app:quantity="2"
    
    <com.filipelipan.stepperview.StepperView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp"
        android:id="@+id/stepper"
        app:quantity="2"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        tools:ignore="MissingConstraints" />
```

