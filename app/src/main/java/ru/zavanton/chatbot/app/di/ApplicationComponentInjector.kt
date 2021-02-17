package ru.zavanton.chatbot.app.di

import android.content.Context

object ApplicationComponentInjector {

    lateinit var applicationComponent: ApplicationComponent

    fun initComponent(context: Context) {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationContext(context)
            .build()
    }

    fun getComponent(): ApplicationComponent {
        return applicationComponent
    }
}