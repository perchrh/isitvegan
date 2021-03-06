package org.digitalsprouts.estoffer.ui.webview

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import org.digitalsprouts.estoffer.R


class SimpleWebViewFragment(val data: Uri) : Fragment() {

    private lateinit var viewModel: SimpleWebViewViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SimpleWebViewViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.simple_web_view_fragment, container, false)
        val webView: WebView = root.findViewById(R.id.webview)
        webView.settings.javaScriptEnabled = true
        webView.settings.setAppCachePath(context!!.getFilesDir().getAbsolutePath() + "/cache");
        webView.settings.setAppCacheEnabled(true)

        viewModel.webpage.observe(this, Observer<Uri> {
            webView.loadUrl(it.toString())
        })

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.setWebpage(data)
    }

}
