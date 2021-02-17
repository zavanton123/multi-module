package ru.zavanton.chatbot

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import dagger.Lazy
import ru.zavanton.chatbot.app.di.ApplicationComponentInjector
import ru.zavanton.chatbot.app.di.ApplicationContext
import ru.zavanton.chatbot.chatbot.ChatbotActivity
import ru.zavanton.chatbot.sales.ui.activity.SalesActivity
import ru.zavanton.chatbot.utils.InfoProcessor
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    @ApplicationContext
    lateinit var appContext: Context

    // demo Lazy
    @Inject
    lateinit var lazyInfoProcessor: Lazy<InfoProcessor>

    override fun onCreate(savedInstanceState: Bundle?) {
        ApplicationComponentInjector
            .getComponent()
            .inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_main)

        // get some dependency directly from component's provision method
        val textUtils = ApplicationComponentInjector.getComponent()
            .provideTextUtils()
        Log.d("zavanton", "zavanton - main name: ${textUtils.getString(R.string.app_name)}")

        // infoProcessor is created once on first call of get() and is cached
        Log.d("zavanton", "zavanton - get lazy info processor: ${lazyInfoProcessor.get()}")

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
