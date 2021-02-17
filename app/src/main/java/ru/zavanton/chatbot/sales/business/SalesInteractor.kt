package ru.zavanton.chatbot.sales.business

import javax.inject.Inject

class SalesInteractor @Inject constructor() : ISalesInteractor {

    override fun getData(): String {
        return "hello world"
    }
}