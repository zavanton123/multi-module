package ru.zavanton.chatbot.app.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.zavanton.chatbot.utils.TextUtils
import javax.inject.Singleton

@Module
class UtilsModule {

    @Singleton
    @Provides
    fun provideTextUtils(context: Context): TextUtils {
        return TextUtils(context)
    }
}