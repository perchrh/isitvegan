package org.digitalsprouts.estoffer


import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class ENumbersApplication : Application() {

    override fun onCreate() {
        applyDefaultSettings()

        super.onCreate()
    }

    private fun applyDefaultSettings() {
        val preferences = PreferenceManager.getDefaultSharedPreferences(this);
        //populate settings if not already present
        if (!preferences.contains(NORWEGIAN_CONTENT) && "no" == getString(R.string.language_code)) {
            preferences.edit().putBoolean(NORWEGIAN_CONTENT, true).apply()
        }
    }

    companion object {
        val NORWEGIAN_CONTENT = "norwegian_content"
    }
}
