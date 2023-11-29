package com.pieterv.senses.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.pieterv.senses.data.ValueSensor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val lightSensor: ValueSensor,
) : ViewModel() {

    var state by mutableStateOf(MainScreenState())
        private set

    fun startLightSensor() {
        lightSensor.startListening()
        lightSensor.setValueChangeListener { values ->
            val lux = values[0]
            state = state.copy(
                isCurrentlyDark = lux <= 50f,
            )
        }
    }
}
