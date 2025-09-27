package com.example.myshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.myshop.databinding.FragmentAddressBinding

class AddressFragment : Fragment() {

    private var _binding : FragmentAddressBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //set content view
        _binding = FragmentAddressBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //interkasi dengan ui

        with(binding) {
            //buat adapter untuk menampilkanitem
            val provinces = resources.getStringArray(R.array.provinces)
            val adapterProvinces = ArrayAdapter(requireContext(),
                android.R.layout.simple_spinner_dropdown_item,
                provinces)

            adapterProvinces.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerProvices.adapter = adapterProvinces

            //handle btn done on click
            //kirim argument ke previous stack

            btnDone.setOnClickListener {
                findNavController().apply {
                    var selectedProvince = spinnerProvices.selectedItem.toString()
                    //simpan state dengan key address dan value selected province
                    previousBackStackEntry?.savedStateHandle?.set("address", selectedProvince )
                } .navigateUp() //navigate ke halaman / fragment sebelumnya

            }
        }
    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        _binding = null

}