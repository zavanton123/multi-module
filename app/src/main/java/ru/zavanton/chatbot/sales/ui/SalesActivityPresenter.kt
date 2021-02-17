package ru.zavanton.chatbot.sales.ui

import android.util.Log
import ru.zavanton.chatbot.R
import ru.zavanton.chatbot.sales.business.ISalesInteractor
import ru.zavanton.chatbot.utils.TextUtils

class SalesActivityPresenter constructor(
    private val textUtils: TextUtils,
    private val interactor: ISalesInteractor
) {

    init {
        Log.d("zavanton", "zavanton - data: ${interactor.getData()}")
        Log.d("zavanton", "zavanton - app name: ${textUtils.getString(R.string.app_name)}")
    }
}