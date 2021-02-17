package ru.zavanton.chatbot.sales.ui.fragment

import android.util.Log
import ru.zavanton.chatbot.R
import ru.zavanton.chatbot.sales.di.SecretKey
import ru.zavanton.chatbot.utils.TextUtils
import javax.inject.Inject

class SalesFragmentPresenter @Inject constructor(
    private val textUtils: TextUtils,
    @SecretKey private val secretKey: String
) {

    init {
        Log.d("zavanton", "zavanton - sales fragment: ${textUtils.getString(R.string.app_name)}")
        Log.d("zavanton", "zavanton - secret: $secretKey")
    }
}