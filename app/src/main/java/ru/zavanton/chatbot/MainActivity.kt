package ru.zavanton.chatbot

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ru.zavanton.chatbot.app.di.ApplicationComponentInjector
import ru.zavanton.chatbot.app.di.ApplicationContext
import ru.zavanton.chatbot.chatbot.ChatbotActivity
import ru.zavanton.chatbot.sales.ui.activity.SalesActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    @ApplicationContext
    lateinit var appContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        ApplicationComponentInjector
            .getComponent()
            .inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_main)

        // get some dependency directly from component's provision method
        val textUtils = ApplicationComponentInjector.getComponent()
            .provideTextUtils()

        Log.d("zavanton", "zavanton - main appcontext: $appContext")
        Log.d("zavanton", "zavanton - main name: ${textUtils.getString(R.string.app_name)}")

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