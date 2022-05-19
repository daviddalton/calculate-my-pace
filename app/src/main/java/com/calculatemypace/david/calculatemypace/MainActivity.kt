package com.calculatemypace.david.calculatemypace

import android.app.Activity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.format.DateUtils
import android.widget.*
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnCheckedChanged
import butterknife.OnClick
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : Activity() {
    @BindView(R.id.distance) lateinit var editDistance: EditText
    @BindView(R.id.minutes) lateinit var editMinutes: EditText
    @BindView(R.id.hours) lateinit var editHours: EditText
    @BindView(R.id.seconds) lateinit var editSeconds: EditText
    @BindView(R.id.pace_text) lateinit var textPace: TextView
    @BindView(R.id.units_switch) lateinit var converter: SwitchMaterial
    @BindView(R.id.calculate_button) lateinit var calculateButton: Button
    @BindView(R.id.clear_button) lateinit var clearButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        converter.text = getString(R.string.miles_hint)
    }

    @OnCheckedChanged(R.id.units_switch)
    fun convert(checked: Boolean) {
        if (checked) {
            editDistance.hint = getString(R.string.kilo_hint)
            converter.text = getString(R.string.kilometers_hint)
        } else {
            editDistance.hint = getString(R.string.miles_hint)
            converter.text = getString(R.string.miles_hint)
        }
    }

    @OnClick(R.id.clear_button)
    fun _clear() {
        clear()
    }

    @OnClick(R.id.calculate_button)
    fun _calculate() {
        calculate()
    }

    private fun calculate() {
        var distanceMile = 0.0
        var distanceKilo = 0.0
        val kiloConversion = 0.62
        val seconds: Double = if (editSeconds.text.toString() != "") {
            editSeconds.text.toString().toInt().toDouble()
        } else {
            0.0
        }
        val hours: Double = if (editHours.text.toString() != "") {
            hoursToSeconds().toDouble()
        } else {
            0.0
        }
        val minutes: Double = if (editMinutes.text.toString() != "") {
            minutesToSeconds().toDouble()
        } else {
            0.0
        }
        if (editDistance.text.toString() != "") {
            distanceMile = editDistance.text.toString().toDouble()
            distanceKilo = editDistance.text.toString().toDouble() * kiloConversion
        }
        if (editDistance.text.toString() != "" && editDistance.hint == "miles") {
            val totalSeconds = hours + minutes + seconds
            val pace = totalSeconds / distanceMile
            textPace.text = SpannableStringBuilder(DateUtils.formatElapsedTime(pace.toLong()) + " " + "min/mile")
        } else if (editDistance.text.toString() != "") {
            val totalSeconds = hours + minutes + seconds
            val pace = totalSeconds / distanceKilo
            textPace.text = SpannableStringBuilder(DateUtils.formatElapsedTime(pace.toLong()) + " " + "min/mile")
        }
    }

    private fun minutesToSeconds(): Int {
        val minutes = editMinutes.text.toString().toInt()
        return minutes * 60
    }

    private fun hoursToSeconds(): Int {
        val hours = editHours.text.toString().toInt()
        return hours * 3600
    }

    fun clear() {
        editDistance.text.clear()
        editHours.text.clear()
        editMinutes.text.clear()
        editSeconds.text.clear()
        textPace.text = SpannableStringBuilder(getString(R.string.pace_text))
    }
}