package ru.zavanton.chatbot.chatbot.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.zavanton.chatbot.chatbot.activity.ChatbotActivity
import javax.inject.Scope

// custom scope for the ChatbotActivitySubcomponent
@Scope
@Retention
annotation class ChatbotActivityScope

@Module
interface ChatbotModule {

    // creates ChatbotActivitySubcomponentInjector
    @ChatbotActivityScope
    @ContributesAndroidInjector(
        modules = [
            ChatbotActivityDependencies::class,
            ChatbotFragmentModule::class
        ]
    )
    fun contributesChatbotActivity(): ChatbotActivity
}

