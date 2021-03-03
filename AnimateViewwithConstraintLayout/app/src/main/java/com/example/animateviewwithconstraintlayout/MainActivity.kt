package com.example.animateviewwithconstraintlayout

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.AnticipateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.databinding.DataBindingUtil
import com.example.animateviewwithconstraintlayout.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var isAnimationStarted: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.button.setOnClickListener {
            isAnimationStarted = !isAnimationStarted

            animateToFrameTwo()
        }
    }

    private fun animateToFrameTwo() {
        val constraintSet = ConstraintSet()
        if (isAnimationStarted) {
            constraintSet.clone(this, R.layout.activity_main)
        } else {
            constraintSet.clone(this, R.layout.activity_main_second_frame)
        }

        val transition = ChangeBounds()
        transition.setInterpolator(AnticipateInterpolator(1.0f))
        transition.setDuration(1200)

        TransitionManager.beginDelayedTransition(binding.constraintLayout, transition)
        constraintSet.applyTo(binding.constraintLayout)
    }

}