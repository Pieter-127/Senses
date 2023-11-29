package com.pieterv.senses.data.factory

import android.content.Context
import android.hardware.Sensor
import com.pieterv.senses.data.AndroidSensor
import com.pieterv.senses.data.SensorType
import com.pieterv.senses.data.factory.type.LightSensor
import com.pieterv.senses.data.factory.type.StepCounterSensor

object SensorFactory {

    fun createSensor(context: Context, sensorType: SensorType): AndroidSensor? {
        return when (sensorType) {
            Sensor.TYPE_LIGHT -> LightSensor(context)
            Sensor.TYPE_STEP_COUNTER -> StepCounterSensor(context)
            else -> null
        }
    }
}
