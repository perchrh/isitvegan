package org.digitalsprouts.estoffer

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import org.digitalsprouts.estoffer.ui.main.SectionsPagerAdapter
import org.digitalsprouts.estoffer.ui.settings.SettingsActivity

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
                val settingsLauncher = Intent(this, SettingsActivity::class.java)
                startActivity(settingsLauncher)
                true
            }
            R.id.action_about -> {
                val base_url = getString(R.string.about_base_url)
                val locale = getString(R.string.language_code)
                val url = "${base_url}_${locale}.html"
                /// TODO start activity with webview fragment
                true
            }
            R.id.action_sources -> {
                val base_url = getString(R.string.sources_base_url)
                val locale = getString(R.string.language_code)
                val url = "${base_url}_${locale}.html"
                /// TODO start activity with webview fragment
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}