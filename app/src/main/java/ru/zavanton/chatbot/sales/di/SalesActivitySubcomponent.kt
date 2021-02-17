package ru.zavanton.chatbot.sales.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import ru.zavanton.chatbot.sales.ui.SalesActivity
import ru.zavanton.chatbot.sales.ui.SalesPresenter
import javax.inject.Scope

@Scope
@Retention
annotation class SalesActivityScope

@Module(subcomponents = [SalesActivitySubcomponent::class])
interface SalesActivityModule {

    @Binds
    @IntoMap
    @ClassKey(SalesActivity::class)
    fun bindsSubcomponentInjector(
        factory: SalesActivitySubcomponent.Factory
    ): AndroidInjector.Factory<*>
}

@SalesActivityScope
@Subcomponent(
    modules = [
        SalesActivityPresenterModule::class,
        SalesFragmentModule::class
    ]
)
interface SalesActivitySubcomponent : AndroidInjector<SalesActivity> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<SalesActivity> {
    }
}

@Module
class SalesActivityPresenterModule {

    @SalesActivityScope
    @Provides
    fun providesPresenter(): SalesPresenter {
        return SalesPresenter()
    }
}

