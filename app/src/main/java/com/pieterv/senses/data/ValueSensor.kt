package com.pieterv.senses.data

typealias SensorType = Int

abstract class ValueSensor(
    protected val internalSensorType: SensorType,
) {

    protected var onValueChanged: ((List<Float>) -> Unit)? = null

    abstract val isSensorAvailable: Boolean
    abstract fun startListening()
    abstract fun stopListening()

    fun setValueChangeListener(listener: (List<Float>) -> Unit) {
        onValueChanged = listener
    }
}
