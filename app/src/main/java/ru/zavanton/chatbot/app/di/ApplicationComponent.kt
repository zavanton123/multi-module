package ru.zavanton.chatbot.app.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import ru.zavanton.chatbot.app.App
import ru.zavanton.chatbot.chatbot.di.ChatbotModule
import ru.zavanton.chatbot.sales.di.SalesModule
import ru.zavanton.chatbot.utils.TextUtils
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention
annotation class SecretKey

@Singleton
@Component(
    modules = [
        // add AndroidInjectionModule
        AndroidInjectionModule::class,

        // this modules refers to subcomponents
        ActivitiesModule::class,

        // this contains application level dependencies
        UtilsModule::class
    ]
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        @BindsInstance
        fun secretKey(@SecretKey key: String): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: App)
}

// Here we have Sales and Chatbot subcomponents
@Module(
    includes = [
        SalesModule::class,
        ChatbotModule::class
    ]
)
interface ActivitiesModule

@Module
class UtilsModule {

    @Singleton
    @Provides
    fun provideTextUtils(context: Context): TextUtils {
        return TextUtils(context)
    }
}