package ru.zavanton.chatbot.app.di

import android.content.Context
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.zavanton.chatbot.MainActivity
import ru.zavanton.chatbot.utils.TextUtils
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        UtilsModule::class
    ]
)
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)

    fun provideTextUtils(): TextUtils
}

@Module
class ApplicationModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideContext(): Context {
        return context
    }
}

@Module
class UtilsModule {

    @Singleton
    @Provides
    fun provideTextUtils(context: Context): TextUtils {
        return TextUtils(context)
    }
}

