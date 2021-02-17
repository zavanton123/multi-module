package ru.zavanton.chatbot

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ru.zavanton.chatbot.app.App
import ru.zavanton.chatbot.chatbot.ChatbotActivity
import ru.zavanton.chatbot.sales.SalesActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var appContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        (this.application as App).applicationComponent
            ?.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_main)

        Log.d("zavanton", "zavanton - appContext: $appContext")

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