package org.digitalsprouts.estoffer.ui.enumbers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.digitalsprouts.estoffer.R
import java.util.*

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [EnumberFragment.OnListFragmentInteractionListener] interface.
 */
class EnumberFragment : Fragment() {

    private lateinit var simplifiedENumberList: List<String>
    private lateinit var detailedENumberList: List<String>

    // TODO: Customize parameters
    private var columnCount = 3
    private val E_NUMBER_COMPARATOR = ENumberComparator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }

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

        // Set the adapter
        with(list) {
            layoutManager = GridLayoutManager(context, columnCount) // TODO in detail view use other column count
            adapter = MyEnumberRecyclerViewAdapter(
                simplifiedENumberList
            )
        }

        return root
    }


    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            EnumberFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}
