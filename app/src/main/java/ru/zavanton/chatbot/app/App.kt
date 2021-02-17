package ru.zavanton.chatbot.app

import android.app.Application
import android.util.Log
import ru.zavanton.chatbot.app.di.ApplicationComponent
import ru.zavanton.chatbot.app.di.ApplicationModule
import ru.zavanton.chatbot.app.di.DaggerApplicationComponent
import ru.zavanton.chatbot.sales.di.DaggerSalesComponent
import ru.zavanton.chatbot.sales.di.SalesComponent

class App : Application() {

    var applicationComponent: ApplicationComponent? = null

    // todo zavanton - move to component injector
    var salesComponent: SalesComponent? = null

    override fun onCreate() {
        super.onCreate()
        Log.d("zavanton", "zavanton - onCreate")

        val applicationModule = ApplicationModule(this)

        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(applicationModule)
            .build()

        salesComponent = DaggerSalesComponent
            .builder()
            .applicationComponent(applicationComponent)
            .build()
    }
}