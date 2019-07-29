package org.digitalsprouts.estoffer.ui.enumbers

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import org.digitalsprouts.estoffer.R

class EnumbersFragment : Fragment() {

    companion object {
        fun newInstance() = EnumbersFragment()
    }

    private lateinit var viewModel: EnumbersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.enumbers_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(EnumbersViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
