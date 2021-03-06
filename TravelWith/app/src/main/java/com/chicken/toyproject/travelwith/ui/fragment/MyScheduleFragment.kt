package com.chicken.toyproject.travelwith.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.chicken.toyproject.travelwith.R
import com.chicken.toyproject.travelwith.ui.adapter.MyScheduleAdapter
import kotlinx.android.synthetic.main.fragment_my_schedule.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MyScheduleFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class MyScheduleFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var testArray: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_schedule, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        addTestArray()  // to be deleted
        rvMyList.layoutManager = LinearLayoutManager(activity)
        rvMyList.adapter = MyScheduleAdapter(testArray, context)


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MyScheduleFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyScheduleFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    private fun addTestArray() {
        testArray.add("부산")
        testArray.add("제주도")
        testArray.add("광주")
        testArray.add("강릉")
        testArray.add("경주")
        testArray.add("정동진")
        testArray.add("서울")
        testArray.add("수원")
        testArray.add("목포")
        testArray.add("진주")
        testArray.add("전주")
        testArray.add("포항")


    }
}
