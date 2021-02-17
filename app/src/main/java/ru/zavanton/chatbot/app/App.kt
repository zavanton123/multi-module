package ru.zavanton.chatbot.app

import android.app.Application
import android.util.Log
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import ru.zavanton.chatbot.app.di.DaggerApplicationComponent
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        Log.d("zavanton", "zavanton - onCreate")

        DaggerApplicationComponent
            .builder()
            .applicationContext(this)
            .build()
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}