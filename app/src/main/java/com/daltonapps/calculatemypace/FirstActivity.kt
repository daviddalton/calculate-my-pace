package com.daltonapps.calculatemypace

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import butterknife.ButterKnife
import butterknife.OnClick
import com.daltonapps.calculatemypace.calculatemypace.R
import com.daltonapps.calculatemypace.modules.log.LogsActivity
import com.daltonapps.calculatemypace.modules.stopwatch.StopwatchActivity

class FirstActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        ButterKnife.bind(this)

    }

    @OnClick(R.id.logs_button)
    fun startLogsActivity() {
        startActivity(Intent(this, LogsActivity::class.java))
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