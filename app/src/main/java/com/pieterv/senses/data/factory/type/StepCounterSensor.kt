package com.pieterv.senses.data.factory.type

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor
import com.pieterv.senses.data.AndroidSensor

class StepCounterSensor(context: Context) : AndroidSensor(
    context = context,
    sensorFeature = PackageManager.FEATURE_SENSOR_STEP_COUNTER,
    sensorType = Sensor.TYPE_STEP_COUNTER,
)
