package ru.zavanton.chatbot.app.di

import android.content.Context

object ApplicationComponentInjector {

    var applicationComponent: ApplicationComponent? = null

    fun initComponent(context: Context) {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(context))
            .build()
    }

    fun getComponent(): ApplicationComponent {
        if (applicationComponent == null) {
            throw IllegalStateException("ApplicationComponent must be initialized")
        }
        return applicationComponent!!
    }
}