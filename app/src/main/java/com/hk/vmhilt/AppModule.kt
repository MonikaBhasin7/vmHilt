package com.hk.vmhilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    @Named("main string")
    fun emitString() : String {
        return "Main String"
    }

    @Singleton
    @Provides
    @Named("cricketer string")
    fun emitCricketerString() : String {
        return "Dhoni"
    }
}