package ru.zavanton.chatbot.app.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.zavanton.chatbot.MainActivity
import ru.zavanton.chatbot.utils.TextUtils
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention
annotation class ApplicationContext

@Singleton
@Component(
    modules = [
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

    fun inject(mainActivity: MainActivity)

    @ApplicationContext
    fun provideApplicationContext(): Context

    fun provideTextUtils(): TextUtils
}


@Module
class UtilsModule {

    @Singleton
    @Provides
    fun provideTextUtils(@ApplicationContext context: Context): TextUtils {
        return TextUtils(context)
    }
}

