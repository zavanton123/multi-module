package ru.zavanton.chatbot.sales.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.zavanton.chatbot.R
import ru.zavanton.chatbot.sales.di.SalesActivityComponentInjector
import javax.inject.Inject

class SalesFragment : Fragment() {

    @Inject
    lateinit var presenter: SalesFragmentPresenter

    companion object {
        fun newInstance(): SalesFragment {
            return SalesFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        SalesActivityComponentInjector
            .getComponent()
            .salesFragmentComponent()
            .inject(this)

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.f_sales, container, false)
    }
}