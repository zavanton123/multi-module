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

interface ApplicationDependencies {

    // provision method
    @ApplicationContext
    fun provideApplicationContext(): Context

    // provision method
    fun provideTextUtils(): TextUtils
}

@Singleton
@Component(
    modules = [
        UtilsModule::class
    ]
)
interface ApplicationComponent : ApplicationDependencies {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun applicationContext(@ApplicationContext context: Context): Builder

        fun build(): ApplicationComponent
    }

    // members-injection method (vs provision method)
    fun inject(mainActivity: MainActivity)
}


@Module
class UtilsModule {

    @Singleton
    @Provides
    fun provideTextUtils(@ApplicationContext context: Context): TextUtils {
        return TextUtils(context)
    }
}

