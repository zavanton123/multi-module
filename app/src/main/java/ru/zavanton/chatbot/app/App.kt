package ru.zavanton.chatbot.app

import android.app.Application
import android.util.Log
import ru.zavanton.chatbot.app.di.ApplicationComponent
import ru.zavanton.chatbot.app.di.ApplicationModule
import ru.zavanton.chatbot.app.di.DaggerApplicationComponent

class App : Application() {

    var applicationComponent: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()
        Log.d("zavanton", "zavanton - onCreate")

        val applicationModule = ApplicationModule(this)

        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(applicationModule)
            .build()
    }
}