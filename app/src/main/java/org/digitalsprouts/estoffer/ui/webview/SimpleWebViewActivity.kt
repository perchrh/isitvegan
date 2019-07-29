package org.digitalsprouts.estoffer.ui.webview

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.digitalsprouts.estoffer.R

class SimpleWebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_web_view)

        val url: Uri = intent.data!!

        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.simple_web_view,
                SimpleWebViewFragment(url)
            )
            .commit()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
