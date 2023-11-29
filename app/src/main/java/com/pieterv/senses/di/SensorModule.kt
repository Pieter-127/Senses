package com.pieterv.senses.di

import android.app.Application
import com.pieterv.senses.data.ValueSensor
import com.pieterv.senses.data.factory.type.LightSensor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SensorModule {

    @Provides
    @Singleton
    fun provideLightSensor(app: Application): ValueSensor {
        return LightSensor(app)
    }
}
