package com.developer.allef.boilerplateapp.ui

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.developer.allef.boilerplateapp.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        motionLayout.setOnClickListener {
            motionLayout.transitionToStart()
        }
        motionLayout.setTransitionListener(MotionProgressListener {
                progress: Float ->
            if (progress <= 0.5F){
                relative_motion.setBackgroundColor(ContextCompat.getColor(this,R.color.colorAccent))
            }else{
                relative_motion.setBackgroundColor(ContextCompat.getColor(this,R.color.colorgray))
            }
            arrow.isVisible = (progress <= 0.5f)
            editText.isVisible = (progress >= 0.5f)
        })


        editText.setOnEditorActionListener { _, arg1, _ ->
            if (arg1 == EditorInfo.IME_ACTION_DONE) {
                motionLayout.transitionToStart()
            }
            false
        }
    }

    override fun onBackPressed() {
        motionLayout.transitionToStart()
    }
}
