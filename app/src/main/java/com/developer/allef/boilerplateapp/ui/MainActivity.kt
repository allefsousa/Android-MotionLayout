package com.developer.allef.boilerplateapp.ui

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.developer.allef.boilerplateapp.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        motionLayout.setOnClickListener {
            motionLayout.transitionToEnd()
        }


        motionLayout.setTransitionListener(MotionProgressListener {
                progress: Float ->
            arrow.isVisible = (progress <= 0.5f)
            editText.isVisible = (progress >= 0.5f)
        })

        editText.setOnEditorActionListener { _, arg1, _ ->
            if (arg1 == EditorInfo.IME_ACTION_GO) {
                motionLayout.transitionToEnd()
            }
            false
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()



    }
}
