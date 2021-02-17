package ru.zavanton.chatbot.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import ru.zavanton.chatbot.R
import ru.zavanton.chatbot.app.di.ApplicationContext
import ru.zavanton.chatbot.chatbot.ChatbotActivity
import ru.zavanton.chatbot.sales.ui.activity.SalesActivity
import ru.zavanton.chatbot.utils.TextUtils
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    @ApplicationContext
    lateinit var appContext: Context

    @Inject
    lateinit var textUtils: TextUtils

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

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

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}