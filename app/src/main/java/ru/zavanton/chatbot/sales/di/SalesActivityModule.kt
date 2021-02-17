package ru.zavanton.chatbot.sales.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import ru.zavanton.chatbot.sales.business.ISalesInteractor
import ru.zavanton.chatbot.sales.business.SalesInteractor
import ru.zavanton.chatbot.sales.ui.activity.SalesActivity
import ru.zavanton.chatbot.sales.ui.activity.SalesActivityPresenter
import ru.zavanton.chatbot.utils.TextUtils
import javax.inject.Qualifier
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class SalesActivityScope

@Qualifier
@Retention
annotation class SalesActivityContext

@Module
interface SalesActivityModule {

    @SalesActivityScope
    @ContributesAndroidInjector(
        modules = [
            SalesActivityDependencies::class,
            SalesFragmentModule::class
        ]
    )
    fun contributesInjector(): SalesActivity
}

@Module
interface SalesActivityDependencies {

    companion object {
        @SalesActivityScope
        @Provides
        fun providePresenter(
            textUtils: TextUtils,
            interactor: ISalesInteractor
        ): SalesActivityPresenter {
            return SalesActivityPresenter(textUtils, interactor)
        }

        @SalesActivityScope
        @Provides
        @SalesActivityContext
        fun provideSalesActivityContext(salesActivity: SalesActivity): Context {
            return salesActivity
        }
    }

    @SalesActivityScope
    @Binds
    fun provideInteractor(impl: SalesInteractor): ISalesInteractor
}
