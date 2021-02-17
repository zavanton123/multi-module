package ru.zavanton.chatbot.sales.di

import dagger.Component
import dagger.Module
import dagger.Provides
import ru.zavanton.chatbot.app.di.ApplicationComponent
import ru.zavanton.chatbot.sales.ui.SalesActivity
import ru.zavanton.chatbot.sales.ui.SalesActivityPresenter
import ru.zavanton.chatbot.utils.TextUtils
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class SalesActivityScope

@SalesActivityScope
@Component(
    dependencies = [
        ApplicationComponent::class
    ],
    modules = [
        SalesModule::class
    ]
)
interface SalesComponent {

    fun inject(salesActivity: SalesActivity)
}

@Module
class SalesModule {

    @SalesActivityScope
    @Provides
    fun provideSalesActivityPresenter(textUtils: TextUtils): SalesActivityPresenter {
        return SalesActivityPresenter(textUtils)
    }
}