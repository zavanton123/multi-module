package ru.zavanton.chatbot.sales.di

import dagger.*
import ru.zavanton.chatbot.app.di.ApplicationComponent
import ru.zavanton.chatbot.sales.business.ISalesInteractor
import ru.zavanton.chatbot.sales.business.SalesInteractor
import ru.zavanton.chatbot.sales.ui.activity.SalesActivity
import ru.zavanton.chatbot.sales.ui.activity.SalesActivityPresenter
import ru.zavanton.chatbot.sales.ui.fragment.SalesFragment
import ru.zavanton.chatbot.utils.TextUtils
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class SalesActivityScope

@Scope
@Retention
annotation class SalesFragmentScope

@SalesActivityScope
@Component(
    dependencies = [
        ApplicationComponent::class
    ],
    modules = [
        SalesActivityModule::class
    ]
)
interface SalesActivityComponent {

    fun inject(salesActivity: SalesActivity)

    fun salesFragmentComponent(): SalesFragmentComponent
}

@Module
interface SalesActivityModule {

    companion object {
        @SalesActivityScope
        @Provides
        fun providePresenter(
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

@SalesFragmentScope
@Subcomponent
interface SalesFragmentComponent {

    fun inject(salesFragment: SalesFragment)
}