package ru.zavanton.chatbot.utils

import android.content.Context
import androidx.annotation.StringRes

class TextUtils constructor(
    private val context: Context
) {

    fun getString(@StringRes id: Int): String {
        return context.resources.getString(id)
    }
}