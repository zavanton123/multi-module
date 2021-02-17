package ru.zavanton.chatbot.sales.di

import dagger.Module
import dagger.Provides
import ru.zavanton.chatbot.sales.activity.SalesActivityPresenter
import ru.zavanton.chatbot.utils.TextUtils

@Module
class SalesActivityDepenencies {

    @SalesActivityScope
    @Provides
    fun providePresenter(textUtils: TextUtils): SalesActivityPresenter {
        return SalesActivityPresenter(textUtils)
    }
}
