package org.digitalsprouts.estoffer.ui.main

import android.content.Context
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import org.digitalsprouts.estoffer.ENumbersApplication
import org.digitalsprouts.estoffer.R
import org.digitalsprouts.estoffer.ui.webview.SimpleWebView

private val TAB_TITLES = arrayOf(
    /* 0 */ R.string.tab_text_1,
    /* 1 */ R.string.tab_text_2,
    /* 2 */ R.string.tab_text_3,
    /* 3 */ R.string.tab_text_4
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    val preferences = PreferenceManager.getDefaultSharedPreferences(context);
    val enableNorwegianContent: Boolean =
        preferences.getBoolean(ENumbersApplication.NORWEGIAN_CONTENT, false)

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        when (position) {
            0 -> {
                // launch e-numbers fragment
            }
            1 -> {
                val base_url = context.getString(R.string.additives_base_url)
                val locale = context.getString(R.string.language_code)
                val url = "${base_url}_${locale}.html"
                return SimpleWebView(url)
            }
            2 -> {
                return SimpleWebView(context.getString(R.string.vegan_beers_norway_url))
            }
            3 -> {
                return SimpleWebView(context.getString(R.string.vegan_wines_norway_url))
            }
            else -> {
                throw IllegalArgumentException("Impossible tab selected: $position")
            }
        }
        return PlaceholderFragment.newInstance(position + 1)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return if (enableNorwegianContent) TAB_TITLES.size else TAB_TITLES.size - 2
    }
}