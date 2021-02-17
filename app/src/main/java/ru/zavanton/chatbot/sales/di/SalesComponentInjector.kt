package ru.zavanton.chatbot.sales.di

import ru.zavanton.chatbot.app.di.ApplicationComponentInjector

object SalesComponentInjector {

    private var salesComponent: SalesComponent? = null

    fun getComponent(): SalesComponent {
        if (salesComponent == null) {
            salesComponent = DaggerSalesComponent
                .builder()
                .applicationComponent(ApplicationComponentInjector.getComponent())
                .build()
        }
        return salesComponent!!
    }
}