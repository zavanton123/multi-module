package ru.zavanton.chatbot.app

import android.app.Application
import android.util.Log
import ru.zavanton.chatbot.app.di.ApplicationComponentInjector

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("zavanton", "zavanton - onCreate")

        ApplicationComponentInjector.initComponent(this)
    }
}