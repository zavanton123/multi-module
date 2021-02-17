package ru.zavanton.chatbot.chatbot.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import ru.zavanton.chatbot.R
import javax.inject.Inject

class ChatbotFragment : Fragment() {

    @Inject
    lateinit var presenter: ChatbotPresenter

    companion object {
        fun newInstance() = ChatbotFragment()
    }

    override fun onAttach(context: Context) {
        // inject dependencies via android injection
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.f_chatbot, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("zavanton", "zavanton - data from presenter: ${presenter.fetchData()}")
    }
}