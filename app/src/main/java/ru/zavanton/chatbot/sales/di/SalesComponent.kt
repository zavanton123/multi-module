package ru.zavanton.chatbot.sales.di

import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.zavanton.chatbot.app.di.ApplicationComponent
import ru.zavanton.chatbot.sales.business.ISalesInteractor
import ru.zavanton.chatbot.sales.business.SalesInteractor
import ru.zavanton.chatbot.sales.ui.activity.SalesActivity
import ru.zavanton.chatbot.sales.ui.activity.SalesActivityPresenter
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
interface SalesModule {

    companion object {
        @SalesActivityScope
        @Provides
        fun provideSalesActivityPresenter(
            textUtils: TextUtils,
            interactor: ISalesInteractor
        ): SalesActivityPresenter {
            return SalesActivityPresenter(textUtils, interactor)
        }
    }

    @SalesActivityScope
    @Binds
    fun provideInteractor(impl: SalesInteractor): ISalesInteractor
}