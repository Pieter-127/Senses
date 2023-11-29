package com.pieterv.senses.data.factory

import android.content.Context
import android.hardware.Sensor
import com.pieterv.senses.data.factory.type.LightSensor
import com.pieterv.senses.data.factory.type.StepCounterSensor
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class SensorFactoryTest {

    private lateinit var systemUnderTest: SensorFactory

    @Before
    fun setUp() {
        systemUnderTest = SensorFactory
    }

    @Test
    fun `createSensor should return LightSensor for TYPE_LIGHT`() {
        val context = mock(Context::class.java)

        val sensor = systemUnderTest.createSensor(context, Sensor.TYPE_LIGHT)

        assertEquals(LightSensor::class.java, sensor!!::class.java)
    }

    @Test
    fun `createSensor should return StepCounterSensor for TYPE_STEP_COUNTER`() {
        val context = mock(Context::class.java)

        val sensor = systemUnderTest.createSensor(context, Sensor.TYPE_STEP_COUNTER)

        assertEquals(StepCounterSensor::class.java, sensor!!::class.java)
    }

    @Test
    fun `createSensor should return null for unknown sensor type`() {
        val context = mock(Context::class.java)

        val sensor = systemUnderTest.createSensor(context, Int.MAX_VALUE)

        assertNull(sensor)
    }
}
