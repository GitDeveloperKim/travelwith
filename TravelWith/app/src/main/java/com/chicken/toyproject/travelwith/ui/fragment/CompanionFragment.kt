package com.chicken.toyproject.travelwith.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.chicken.toyproject.travelwith.R
import com.chicken.toyproject.travelwith.ui.MainActivity
import com.chicken.toyproject.travelwith.ui.adapter.CompanionAdapter
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.bottomsheet_companion.*
import kotlinx.android.synthetic.main.bottomsheet_companion.view.*
import kotlinx.android.synthetic.main.fragment_companion.*
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TravelFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class TravelFragment : Fragment(),OnMapReadyCallback {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var testArray: ArrayList<String> = ArrayList()
    lateinit var gMap: GoogleMap

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
        return inflater.inflate(R.layout.fragment_companion, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mapView.onCreate(savedInstanceState)
        mapView.onResume()
        mapView.getMapAsync(this)

        addTestArray()

        val view: View = layoutInflater.inflate(R.layout.bottomsheet_companion, null)
        val rvCompanionList = view.rvCompanionList
        rvCompanionList.layoutManager = LinearLayoutManager(activity)
        rvCompanionList.adapter = CompanionAdapter(testArray, context)

        val bottomSheetDialog = BottomSheetDialog(requireContext())
        bottomSheetDialog.setContentView(view)
        bottomSheetDialog.show()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TravelFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TravelFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        toast("ready to use Google map")    // developerkim : to be deleted
        gMap = googleMap
        val sydney = LatLng(-34.0, 151.0)
        gMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        gMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
        // initialize
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
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
