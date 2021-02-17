package ru.zavanton.chatbot.sales.fragment

class SalesFragmentPresenter(
    private val key: String
) {

    fun getInfo(): String {
        return "The secret key is $key"
    }
}