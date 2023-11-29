package com.pieterv.senses.data

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorManager
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

class AndroidSensorTest {

    private lateinit var mockContext: Context
    private lateinit var mockSensorManager: SensorManager
    private lateinit var mockSensor: Sensor
    private lateinit var systemUnderTest: AndroidSensor
    private lateinit var mockPackageManager: PackageManager
    private var mockSensorFeature = "sensor_feature"

    @Before
    fun setup() {
        mockContext = mock(Context::class.java)
        mockSensorManager = mock(SensorManager::class.java)
        mockSensor = mock(Sensor::class.java)
        mockPackageManager = mock(PackageManager::class.java)

        `when`(mockContext.getSystemService(Context.SENSOR_SERVICE)).thenReturn(mockSensorManager)
        `when`(mockSensorManager.getDefaultSensor(anyInt())).thenReturn(mockSensor)
        `when`(mockContext.packageManager).thenReturn(mockPackageManager)

        systemUnderTest = object : AndroidSensor(mockContext, mockSensorFeature, Sensor.TYPE_LIGHT) {
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) = Unit
        }
    }

    @Test
    fun `isSensorAvailable returns true when the sensor feature is available`() {
        `when`(mockPackageManager.hasSystemFeature(mockSensorFeature)).thenReturn(true)

        val result = systemUnderTest.isSensorAvailable

        assertTrue(result)
    }

    @Test
    fun `isSensorAvailable returns false when the sensor feature is not available`() {
        `when`(mockPackageManager.hasSystemFeature(mockSensorFeature)).thenReturn(false)

        val result = systemUnderTest.isSensorAvailable

        assertFalse(result)
    }

    @Test
    fun startListening() {
        `when`(mockPackageManager.hasSystemFeature(mockSensorFeature)).thenReturn(true)

        systemUnderTest.startListening()

        verify(mockSensorManager).registerListener(systemUnderTest, mockSensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    @Test
    fun `stopListening() should unregister sensor listener when already listening`() {
        `when`(mockPackageManager.hasSystemFeature(mockSensorFeature)).thenReturn(true)

        systemUnderTest.startListening()

        systemUnderTest.stopListening()

        verify(mockSensorManager).unregisterListener(systemUnderTest)
    }
}
