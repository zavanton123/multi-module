package ru.zavanton.chatbot.sales.di

import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import ru.zavanton.chatbot.sales.ui.fragment.SalesFragment
import javax.inject.Qualifier
import javax.inject.Scope

@Scope
@Retention
annotation class SalesFragmentScope

@Qualifier
@Retention
annotation class SecretKey

@Module
interface SalesFragmentModule {

    @SalesFragmentScope
    @ContributesAndroidInjector(
        modules = [
            SalesFragmentDependencies::class
        ]
    )
    fun contributesInjector(): SalesFragment
}

@Module
class SalesFragmentDependencies {

    @SalesFragmentScope
    @Provides
    @SecretKey
    fun provideSecretKey(): String {
        return "5343-fqlwrj-iovxl2-1l32kj"
    }
}