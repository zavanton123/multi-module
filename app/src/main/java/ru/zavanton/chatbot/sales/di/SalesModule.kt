package ru.zavanton.chatbot.sales.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.zavanton.chatbot.sales.activity.SalesActivity
import javax.inject.Scope

// custom scope for the SalesActivitySubcomponent
@Scope
@Retention
annotation class SalesActivityScope

@Module
interface SalesModule {

    // creates SalesActivitySubcomponentInjector
    @SalesActivityScope
    @ContributesAndroidInjector(
        modules = [
            SalesActivityDepenencies::class,
            SalesFragmentModule::class
        ]
    )
    fun contributeSalesActivity(): SalesActivity
}

