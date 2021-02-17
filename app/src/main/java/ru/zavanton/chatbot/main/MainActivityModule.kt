package ru.zavanton.chatbot.main

import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Scope

@Scope
@Retention
annotation class MainActivityScope

@Module
interface MainActivityModule {

    @MainActivityScope
    @ContributesAndroidInjector
    fun contributesInjector(): MainActivity
}