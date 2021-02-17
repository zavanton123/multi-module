package ru.zavanton.chatbot.app.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import ru.zavanton.chatbot.app.App
import ru.zavanton.chatbot.main.MainActivityModule
import ru.zavanton.chatbot.sales.di.SalesActivityModule
import ru.zavanton.chatbot.utils.TextUtils
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention
annotation class ApplicationContext

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        Modules::class,
        UtilsModule::class
    ]
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun applicationContext(@ApplicationContext context: Context): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: App)
}

@Module(
    includes = [
        MainActivityModule::class,
        SalesActivityModule::class
    ]
)
interface Modules


@Module
class UtilsModule {

    @Singleton
    @Provides
    fun provideTextUtils(@ApplicationContext context: Context): TextUtils {
        return TextUtils(context)
    }
}
