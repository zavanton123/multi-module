package ru.zavanton.chatbot.chatbot.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.zavanton.chatbot.chatbot.fragment.ChatbotFragment
import javax.inject.Scope

// custom scope for the ChatbotFragmentSubcomponent
@Scope
@Retention
annotation class ChatbotFragmentScope

@Module
interface ChatbotFragmentModule {

    // creates ChatbotFragmentSubcomponentInjector
    @ChatbotFragmentScope
    @ContributesAndroidInjector
    fun contributesInjector(): ChatbotFragment
}