package org.digitalsprouts.estoffer.ui.enumbers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ToggleButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import org.digitalsprouts.estoffer.R
import java.util.*

class EnumbersFragment : Fragment() {

    private lateinit var viewModel: EnumbersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.enumbers_fragment, container, false)

        val detailedENumberList = ENumberListBuilder.createDetailedList(context!!)
        val simplifiedENumberList = ENumberListBuilder.createSimplifiedList(context!!)

        val items = ArrayList<String>()
        val adapter = ArrayAdapter(activity!!, R.layout.enumber_item, R.id.enumberLabel, items)
        val gridView = rootView.findViewById(R.id.enumber_grid) as GridView
        val details = rootView.findViewById(R.id.togglebutton) as ToggleButton
        details.setOnCheckedChangeListener { compoundButton, checked ->
            populateGridView(
                checked,
                items,
                gridView,
                detailedENumberList,
                simplifiedENumberList,
                adapter
            )
        }

        populateGridView(
            details.isChecked,
            items,
            gridView,
            detailedENumberList,
            simplifiedENumberList,
            adapter
        )

        gridView.adapter = adapter

        return rootView
    }

    private val E_NUMBER_COMPARATOR = ENumberComparator()

    private fun populateGridView(
        checked: Boolean,
        items: MutableList<String>,
        gridView: GridView,
        detailedENumberList: List<String>,
        simplifiedENumberList: List<String>,
        adapter: ArrayAdapter<String>
    ) {
        items.clear()
        if (checked) {
            gridView.numColumns = 1
            items.addAll(detailedENumberList)
        } else {
            gridView.numColumns = 3
            items.addAll(simplifiedENumberList)
        }
        Collections.sort(items, E_NUMBER_COMPARATOR)

        adapter.notifyDataSetChanged()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(EnumbersViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
