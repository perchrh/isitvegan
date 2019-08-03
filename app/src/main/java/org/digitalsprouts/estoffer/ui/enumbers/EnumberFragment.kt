package org.digitalsprouts.estoffer.ui.enumbers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.digitalsprouts.estoffer.R
import java.util.*

class EnumberFragment : Fragment() {

    private var detailModeEnabled: Boolean = false
    private lateinit var simplifiedENumberList: List<String>
    private lateinit var detailedENumberList: List<String>

    private val E_NUMBER_COMPARATOR = ENumberComparator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        detailedENumberList = ENumberListBuilder.createDetailedList(context!!)
        Collections.sort(detailedENumberList, E_NUMBER_COMPARATOR)

        simplifiedENumberList = ENumberListBuilder.createSimplifiedList(context!!)
        Collections.sort(simplifiedENumberList, E_NUMBER_COMPARATOR)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_enumber_list, container, false)
        val list = root.findViewById<RecyclerView>(R.id.list)
        val detailsButton = root.findViewById<FloatingActionButton>(R.id.detailButton)
        detailsButton.setOnClickListener({
            detailModeEnabled = !detailModeEnabled

            populateRecyclerView(list)
            list.adapter?.notifyDataSetChanged()
        })

        populateRecyclerView(list)

        return root
    }

    private fun populateRecyclerView(list: RecyclerView) {
        val currentRowCount = if (detailModeEnabled) 1 else 3
        val currentList: List<String> = if (detailModeEnabled) detailedENumberList else simplifiedENumberList
        list.layoutManager = GridLayoutManager(context, currentRowCount)
        list.adapter = MyEnumberRecyclerViewAdapter(currentList)
    }

}
