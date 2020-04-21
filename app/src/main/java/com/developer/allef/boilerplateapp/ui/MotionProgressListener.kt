package com.developer.allef.boilerplateapp.ui

import android.util.Log
import androidx.constraintlayout.motion.widget.MotionLayout

/**
 * @author allef.santos on 20/04/20
 */
class MotionProgressListener(private val progressListener: (Float) -> Unit) :
    MotionLayout.TransitionListener {
    override fun onTransitionTrigger(layout: MotionLayout?, triggerId: Int, positive: Boolean, progress: Float) {}
    override fun onTransitionStarted(layout: MotionLayout?, startId: Int, endId: Int) {}
    override fun onTransitionChange(layout: MotionLayout?, startId: Int, endId: Int, progress: Float) {
        progressListener.invoke(progress)
        Log.v("Motion","start id = $startId")
        Log.v("Motion","end id = $endId")
        Log.v("Motion","progress = $progress")

    }
    override fun onTransitionCompleted(layout: MotionLayout?, currentId: Int) {
        Log.v("Motion","ID = $layout")
    }
}