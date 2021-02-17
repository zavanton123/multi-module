package ru.zavanton.chatbot.sales.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.zavanton.chatbot.R
import ru.zavanton.chatbot.sales.di.SalesComponentInjector
import javax.inject.Inject

class SalesActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: SalesActivityPresenter

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, SalesActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        SalesComponentInjector
            .getComponent()
            .inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_sales)
    }
}