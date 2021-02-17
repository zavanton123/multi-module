package ru.zavanton.chatbot.sales.di

import android.content.Context
import dagger.*
import ru.zavanton.chatbot.app.di.ApplicationDependencies
import ru.zavanton.chatbot.sales.business.ISalesInteractor
import ru.zavanton.chatbot.sales.business.SalesInteractor
import ru.zavanton.chatbot.sales.ui.activity.SalesActivity
import ru.zavanton.chatbot.sales.ui.activity.SalesActivityPresenter
import ru.zavanton.chatbot.sales.ui.fragment.SalesFragment
import ru.zavanton.chatbot.utils.TextUtils
import javax.inject.Qualifier
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class SalesActivityScope

@Scope
@Retention
annotation class SalesFragmentScope

@Qualifier
@Retention
annotation class SalesActivityContext

@SalesActivityScope
@Component(
    dependencies = [
        ApplicationDependencies::class
    ],
    modules = [
        SalesActivityModule::class
    ]
)
interface SalesActivityComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun salesActivityContext(@SalesActivityContext context: Context): Builder

        fun applicationDependencies(applicationDependencies: ApplicationDependencies): Builder

        fun build(): SalesActivityComponent
    }

    fun inject(salesActivity: SalesActivity)

    fun salesFragmentComponentBuilder(): SalesFragmentComponent.Builder
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

@Qualifier
@Retention
annotation class SecretKey

@SalesFragmentScope
@Subcomponent
interface SalesFragmentComponent {

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun secretKey(@SecretKey secretKey: String): Builder

        fun build(): SalesFragmentComponent
    }

    fun inject(salesFragment: SalesFragment)
}