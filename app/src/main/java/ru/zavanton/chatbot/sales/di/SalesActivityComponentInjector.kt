package ru.zavanton.chatbot.sales.di

import android.content.Context
import ru.zavanton.chatbot.app.di.ApplicationComponentInjector

object SalesActivityComponentInjector {

    private var salesActivityComponent: SalesActivityComponent? = null

    fun initComponent(context: Context): SalesActivityComponent {
        if (salesActivityComponent == null) {
            salesActivityComponent = DaggerSalesActivityComponent
                .builder()
                .salesActivityContext(context)
                .applicationComponent(ApplicationComponentInjector.getComponent())
                .build()
        }
        return salesActivityComponent!!
    }

    fun getComponent(): SalesActivityComponent {
        if (salesActivityComponent == null) {
            throw IllegalStateException("SalesActivityComponent must be initialized")
        }
        return salesActivityComponent!!
    }

    fun clear() {
        salesActivityComponent = null
    }
}