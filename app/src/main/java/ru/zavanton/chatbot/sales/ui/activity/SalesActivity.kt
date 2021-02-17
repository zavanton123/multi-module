package ru.zavanton.chatbot.sales.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.zavanton.chatbot.R
import ru.zavanton.chatbot.sales.di.SalesActivityComponentInjector
import ru.zavanton.chatbot.sales.ui.fragment.SalesFragment
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
        SalesActivityComponentInjector
            .initComponent(this)
            .inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_sales)

        if (supportFragmentManager.findFragmentById(R.id.fragmentContainer) == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, SalesFragment.newInstance(), null)
                .commit()
        }
    }
}