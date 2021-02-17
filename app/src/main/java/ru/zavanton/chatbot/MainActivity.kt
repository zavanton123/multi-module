package ru.zavanton.chatbot

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_main)

        val salesButton = findViewById<Button>(R.id.btnSales)
        val chatbotButton = findViewById<Button>(R.id.btnChatbot)

        salesButton.setOnClickListener {
            SalesActivity.start(this)
        }

        chatbotButton.setOnClickListener {
            ChatbotActivity.start(this)
        }
    }
}