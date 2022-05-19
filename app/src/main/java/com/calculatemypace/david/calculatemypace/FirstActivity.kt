package com.calculatemypace.david.calculatemypace

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

class FirstActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        ButterKnife.bind(this)

    }

    @OnClick(R.id.pace_button)
    fun startMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    @OnClick(R.id.stopwatch)
    fun startStopwatchActivity() {
        startActivity(Intent(this, StopwatchActivity::class.java))
    }

    @OnClick(R.id.imageButton)
    fun startSecretActivity() {
        startActivity(Intent(this, StopwatchActivity::class.java))
    }

}