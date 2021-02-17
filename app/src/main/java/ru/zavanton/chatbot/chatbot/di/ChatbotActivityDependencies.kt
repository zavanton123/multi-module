package ru.zavanton.chatbot.chatbot.di

import dagger.Module
import dagger.Provides
import ru.zavanton.chatbot.chatbot.activity.ChatbotPresenter

@Module
class ChatbotActivityDependencies {

    @ChatbotActivityScope
    @Provides
    fun providePresenter(): ChatbotPresenter = ChatbotPresenter()
}