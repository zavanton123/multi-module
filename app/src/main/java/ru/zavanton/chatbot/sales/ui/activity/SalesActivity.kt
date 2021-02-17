package ru.zavanton.chatbot.sales.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import ru.zavanton.chatbot.R
import ru.zavanton.chatbot.sales.ui.fragment.SalesFragment
import javax.inject.Inject

class SalesActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var presenter: SalesActivityPresenter

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, SalesActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_sales)

        if (supportFragmentManager.findFragmentById(R.id.fragmentContainer) == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, SalesFragment.newInstance(), null)
                .commit()
        }
    }
}