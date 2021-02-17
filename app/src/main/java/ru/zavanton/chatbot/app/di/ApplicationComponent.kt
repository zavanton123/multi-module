package ru.zavanton.chatbot.app.di

import dagger.Component
import ru.zavanton.chatbot.MainActivity
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class
    ]
)
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)
}