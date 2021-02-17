package ru.zavanton.chatbot.sales.activity

import android.util.Log
import ru.zavanton.chatbot.R
import ru.zavanton.chatbot.utils.TextUtils


class SalesActivityPresenter constructor(
    private val textUtils: TextUtils
) {

    fun getData() {
        Log.d("zavanton", "zavanton - getData(): ${textUtils.getString(R.string.app_name)}")
    }
}