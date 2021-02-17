package ru.zavanton.chatbot.sales.di

import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import ru.zavanton.chatbot.app.di.SecretKey
import ru.zavanton.chatbot.sales.fragment.SalesFragment
import ru.zavanton.chatbot.sales.fragment.SalesFragmentPresenter
import javax.inject.Scope

// custom scope for the SalesFragmentSubcomponent
@Scope
@Retention
annotation class SalesFragmentScope

@Module
interface SalesFragmentModule {

    // creates SalesFragmentSubcomponentInjector
    @SalesFragmentScope
    @ContributesAndroidInjector(
        modules = [
            SalesFragmentDependencies::class
        ]
    )
    fun contributeFragment(): SalesFragment
}

@Module
class SalesFragmentDependencies {

    @SalesFragmentScope
    @Provides
    fun providePresenter(@SecretKey key: String): SalesFragmentPresenter {
        return SalesFragmentPresenter(key)
    }
}