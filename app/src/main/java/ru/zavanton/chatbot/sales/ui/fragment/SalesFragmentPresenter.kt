package ru.zavanton.chatbot.sales.ui.fragment

import android.util.Log
import ru.zavanton.chatbot.R
import ru.zavanton.chatbot.utils.TextUtils

class SalesFragmentPresenter constructor(
    private val textUtils: TextUtils
) {

    init {
        Log.d("zavanton", "zavanton - sales fragment: ${textUtils.getString(R.string.app_name)}")
    }
}