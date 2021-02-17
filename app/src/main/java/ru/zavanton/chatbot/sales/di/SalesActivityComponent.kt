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
        SalesActivityPresenterModule::class
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

    // provision method
    fun salesFragmentComponent(): SalesFragmentComponent

    // members-injection method
    fun inject(salesActivity: SalesActivity)
}

// demo: transitively include other modules
@Module(includes = [SalesActivityInteractorModule::class])
class SalesActivityPresenterModule {

    @SalesActivityScope
    @Provides
    fun providesPresenter(
        textUtils: TextUtils,
        interactor: ISalesInteractor
    ): SalesActivityPresenter {
        return SalesActivityPresenter(textUtils, interactor)
    }
}

@Module
interface SalesActivityInteractorModule {

    @SalesActivityScope
    @Binds
    fun bindsInteractor(impl: SalesInteractor): ISalesInteractor
}


@SalesFragmentScope
@Subcomponent
interface SalesFragmentComponent {

    // members-injection method
    fun inject(salesFragment: SalesFragment)
}