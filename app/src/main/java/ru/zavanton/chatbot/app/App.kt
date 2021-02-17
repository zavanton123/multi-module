package ru.zavanton.chatbot.app

import android.app.Application
import android.util.Log
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import ru.zavanton.chatbot.app.di.DaggerApplicationComponent
import javax.inject.Inject

// we need to extend HasAndroidInjector
// if we want to inject into activities (services, broadcast receivers, etc.)
class App : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        Log.d("zavanton", "zavanton - onCreate")

        DaggerApplicationComponent
            .builder()
            .context(this)
            .secretKey("2314hjkhl24poilkjm234")
            .build()
            .inject(this)
    }

    // this is used by activities, services, etc.
    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}