package ru.zavanton.chatbot.sales.di

import ru.zavanton.chatbot.app.di.ApplicationComponentInjector

object SalesActivityComponentInjector {

    private var salesActivityComponent: SalesActivityComponent? = null

    fun getComponent(): SalesActivityComponent {
        if (salesActivityComponent == null) {
            salesActivityComponent = DaggerSalesActivityComponent
                .builder()
                .applicationComponent(ApplicationComponentInjector.getComponent())
                .build()
        }
        return salesActivityComponent!!
    }

    fun clear() {
        salesActivityComponent = null
    }
}