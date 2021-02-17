package ru.zavanton.chatbot.sales.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import ru.zavanton.chatbot.sales.ui.fragment.SalesFragment
import ru.zavanton.chatbot.sales.ui.fragment.SalesFragmentPresenter
import javax.inject.Scope

@Scope
@Retention
annotation class SalesFragmentScope

@Module(subcomponents = [SalesFragmentSubcomponent::class])
interface SalesFragmentModule {

    @Binds
    @IntoMap
    @ClassKey(SalesFragment::class)
    fun bindsSalesFragmentInjector(
        factory: SalesFragmentSubcomponent.Factory
    ): AndroidInjector.Factory<*>
}

@SalesFragmentScope
@Subcomponent(
    modules = [
        SalesFragmentPresenterModule::class
    ]
)
interface SalesFragmentSubcomponent : AndroidInjector<SalesFragment> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<SalesFragment> {
    }
}


@Module
class SalesFragmentPresenterModule {

    @SalesFragmentScope
    @Provides
    fun providesPresenter(): SalesFragmentPresenter = SalesFragmentPresenter()
}