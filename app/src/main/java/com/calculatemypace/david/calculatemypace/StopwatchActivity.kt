package com.calculatemypace.david.calculatemypace

import android.app.Activity
import android.widget.TextView
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.view.View
import android.widget.Button
import butterknife.BindView
import butterknife.ButterKnife
import org.w3c.dom.Text

class StopwatchActivity : Activity() {
    @BindView(R.id.start_button) lateinit var buttonStart: Button
    @BindView(R.id.reset_button) lateinit var buttonReset: Button
    @BindView(R.id.timer) lateinit var time: TextView

    var startTime = 0L
    var timeInMilliseconds = 0L
    var timeSwapBuff = 0L
    var updatedTime = 0L
    var t = 1
    var secs = 0
    var mins = 0
    var milliseconds = 0
    var handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stopwatch)
        ButterKnife.bind(this)

        time.text = getString(R.string.start_time)

        buttonStart.setOnClickListener {
            startWatch()
        }
        buttonReset.setOnClickListener {
            reset()
        }
    }

    private var updateTimer: Runnable = object : Runnable {
        override fun run() {
            timeInMilliseconds = SystemClock.uptimeMillis() - startTime
            updatedTime = timeSwapBuff + timeInMilliseconds
            secs = (updatedTime / 1000).toInt()
            mins = secs / 60
            secs = secs % 60
            milliseconds = (updatedTime % 1000).toInt()
            time.text = "" + mins + ":" + String.format("%02d", secs) + ":" + String.format(
                "%03d",
                milliseconds
            )
            handler.postDelayed(this, 0)
        }
    }

    private fun startWatch() {
        if (t == 1) {
            buttonStart.text = getString(R.string.pause_button)
            startTime = SystemClock.uptimeMillis()
            handler.postDelayed(updateTimer, 0)
            t = 0
        } else {
            buttonStart.text = getString(R.string.start_button)
            timeSwapBuff += timeInMilliseconds
            handler.removeCallbacks(updateTimer)
            t = 1
        }
    }

    private fun reset() {
        startTime = 0L
        timeInMilliseconds = 0L
        timeSwapBuff = 0L
        updatedTime = 0L
        t = 1
        secs = 0
        mins = 0
        milliseconds = 0
        buttonStart.text = getString(R.string.start_button)
        handler.removeCallbacks(updateTimer)
        time.text = getString(R.string.start_time)
    }
}