package org.digitalsprouts.estoffer


import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class ENumbersApplication : Application() {

    override fun onCreate() {
        applyDefaultSettings()

        super.onCreate()
    }

    private fun applyDefaultSettings() {
        val settings: SharedPreferences = getSharedPreferences(SETTINGS, Context.MODE_PRIVATE)
        //populate settings if not already present
        if (!settings.contains(NORWEGIAN_CONTENT) && "no" == getString(R.string.language_code)) {
            settings.edit().putBoolean(NORWEGIAN_CONTENT, true).apply()
        }
    }

    companion object {

        val SETTINGS = "settings"
        val NORWEGIAN_CONTENT = "norwegian_content"
    }
}
