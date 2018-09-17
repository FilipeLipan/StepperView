package com.filipelipan.stepperview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_test1.setOnClickListener {
            stepper.goToPreviousStep()

        }

        button_test2.setOnClickListener {
            stepper.goToNextStep()
        }
    }
}
