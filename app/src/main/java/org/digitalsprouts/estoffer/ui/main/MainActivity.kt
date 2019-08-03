package org.digitalsprouts.estoffer.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import org.digitalsprouts.estoffer.R
import org.digitalsprouts.estoffer.ui.settings.SettingsActivity
import org.digitalsprouts.estoffer.ui.webview.SimpleWebViewActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                val launcher = Intent(this, SettingsActivity::class.java)
                startActivity(launcher)
                true
            }
            R.id.action_about -> {
                val launcher = createWebviewIntent(getString(R.string.about_base_url))
                startActivity(launcher)
                true
            }
            R.id.action_sources -> {
                val launcher = createWebviewIntent(getString(R.string.sources_base_url))
                startActivity(launcher)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun createWebviewIntent(base_url:String): Intent {
        val locale = getString(R.string.language_code)
        val url = "${base_url}_${locale}.html"
        val launcher = Intent(this, SimpleWebViewActivity::class.java)
        launcher.setData(Uri.parse(url))
        return launcher
    }
}