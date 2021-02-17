package ru.zavanton.chatbot.sales.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import ru.zavanton.chatbot.R
import javax.inject.Inject

class SalesFragment : Fragment() {

    @Inject
    lateinit var presenter: SalesFragmentPresenter

    companion object {
        fun newInstance(): SalesFragment = SalesFragment()
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
}