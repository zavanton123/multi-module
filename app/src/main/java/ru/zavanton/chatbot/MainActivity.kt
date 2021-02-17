package ru.zavanton.chatbot

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ru.zavanton.chatbot.app.di.ApplicationComponentInjector
import ru.zavanton.chatbot.chatbot.ChatbotActivity
import ru.zavanton.chatbot.sales.ui.SalesActivity
import ru.zavanton.chatbot.utils.TextUtils
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var appContext: Context

    @Inject
    lateinit var textUtils: TextUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        ApplicationComponentInjector
            .getComponent()
            .inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_main)

        Log.d("zavanton", "zavanton - appContext: $appContext")
        Log.d("zavanton", "zavanton - application name: ${textUtils.getString(R.string.app_name)}")

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