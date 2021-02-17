package ru.zavanton.chatbot.chatbot

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.zavanton.chatbot.R

class ChatbotActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            Intent(context, ChatbotActivity::class.java)
                .apply {
                    context.startActivity(this)
                }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_chatbot)
    }
}