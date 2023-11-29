package com.pieterv.senses.data.factory.type

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor
import com.pieterv.senses.data.AndroidSensor

class LightSensor(context: Context) : AndroidSensor(
    context = context,
    sensorFeature = PackageManager.FEATURE_SENSOR_LIGHT,
    sensorType = Sensor.TYPE_LIGHT,
)
