package com.filipelipan.stepperview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        stepper.stepperClickListeners = object: StepperView.StepperClickListeners {
            override fun onStepClick(position: Int) {
                Toast.makeText(this@MainActivity, position.toString(), Toast.LENGTH_SHORT).show()
            }

        }

        button_test1.setOnClickListener {
            stepper.goToPreviousStep()

        }

        button_test2.setOnClickListener {
            stepper.goToNextStep()
        }
    }
}
