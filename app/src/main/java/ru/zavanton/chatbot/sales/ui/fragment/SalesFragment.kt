package ru.zavanton.chatbot.sales.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import ru.zavanton.chatbot.R
import ru.zavanton.chatbot.app.di.ApplicationContext
import ru.zavanton.chatbot.sales.di.SalesActivityContext
import javax.inject.Inject

class SalesFragment : Fragment() {

    @Inject
    lateinit var presenter: SalesFragmentPresenter

    @Inject
    @ApplicationContext
    lateinit var applicationContext: Context

    @Inject
    @SalesActivityContext
    lateinit var salesActivityContext: Context

    companion object {
        fun newInstance(): SalesFragment {
            return SalesFragment()
        }
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.f_sales, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("zavanton", "zavanton - applicationContext: $applicationContext")
        Log.d("zavanton", "zavanton - salesActivityContext: $salesActivityContext")
    }
}