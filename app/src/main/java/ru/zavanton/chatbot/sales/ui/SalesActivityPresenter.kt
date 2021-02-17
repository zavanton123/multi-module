package ru.zavanton.chatbot.sales.ui

import android.util.Log
import ru.zavanton.chatbot.R
import ru.zavanton.chatbot.utils.TextUtils

class SalesActivityPresenter constructor(
    private val textUtils: TextUtils
) {

    init {
        Log.d("zavanton", "zavanton - app name: ${textUtils.getString(R.string.app_name)}")
    }
}