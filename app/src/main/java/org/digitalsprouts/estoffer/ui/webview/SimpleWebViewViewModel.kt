package org.digitalsprouts.estoffer.ui.webview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SimpleWebViewViewModel : ViewModel() {

    val webpage = MutableLiveData<String>()

    fun setWebpage(webpage: String) {
        this.webpage.value = webpage
    }

}
