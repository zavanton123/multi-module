package ru.zavanton.chatbot.utils

import android.util.Log
import javax.inject.Inject

// Provider works correctly with constructor injection
// (no guarantee a new instance is created each time,
// if it is provided via @Provides)
class ImageUtils @Inject constructor() {

    init {
        Log.d("zavanton", "zavanton - ImageUtils is initialized: $this")
    }
}