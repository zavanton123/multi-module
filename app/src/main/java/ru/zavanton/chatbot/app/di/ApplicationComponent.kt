package ru.zavanton.chatbot.app.di

import dagger.Component
import dagger.Module
import dagger.android.AndroidInjectionModule
import ru.zavanton.chatbot.app.App
import ru.zavanton.chatbot.sales.di.SalesActivityModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        Modules::class
    ]
)
interface ApplicationComponent {

    fun inject(app: App)
}

@Module(
    includes = [
        SalesActivityModule::class
    ]
)
interface Modules