package ru.zavanton.chatbot.sales.di

import dagger.BindsInstance
import dagger.Subcomponent
import ru.zavanton.chatbot.sales.ui.fragment.SalesFragment

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