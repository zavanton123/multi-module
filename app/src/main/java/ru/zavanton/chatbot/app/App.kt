package ru.zavanton.chatbot.app

import android.app.Application
import android.util.Log
import ru.zavanton.chatbot.app.di.ApplicationComponentInjector
import ru.zavanton.chatbot.sales.di.DaggerSalesComponent
import ru.zavanton.chatbot.sales.di.SalesComponent

class App : Application() {

    // todo zavanton - move to component injector
    var salesComponent: SalesComponent? = null

    override fun onCreate() {
        super.onCreate()
        Log.d("zavanton", "zavanton - onCreate")

        ApplicationComponentInjector.initComponent(this)

    }
}