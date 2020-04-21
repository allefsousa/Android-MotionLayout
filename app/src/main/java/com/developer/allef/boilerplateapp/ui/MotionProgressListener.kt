package com.developer.allef.boilerplateapp.ui

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
    }
    override fun onTransitionCompleted(layout: MotionLayout?, currentId: Int) {}
}