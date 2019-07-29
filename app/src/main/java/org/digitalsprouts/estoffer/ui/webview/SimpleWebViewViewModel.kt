package org.digitalsprouts.estoffer.ui.webview

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SimpleWebViewViewModel : ViewModel() {

    val webpage = MutableLiveData<Uri>()

    fun setWebpage(webpage: Uri) {
        this.webpage.value = webpage
    }

}
