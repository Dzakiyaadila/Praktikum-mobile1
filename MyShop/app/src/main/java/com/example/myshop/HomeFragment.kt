package com.example.myshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myshop.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    //create binding first
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding !!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            var product = txtNamaProduct.text.toString()
            val action = HomeFragmentDirections.actionHomeFragmentToCheckoutFragment(product)

            btnBuy.setOnClickListener {
                //start nav
                findNavController().navigate(action)
                //yang punya nav itu host navigationnya, host fragment tidak akan berubah, tpai isinya.
                //yg tugasnya mengubah2 itu navigation
            }
        }
    }
//
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}


//kalau nggak pakai _binding nggak bisa null
//tapi aksesnya tetep pakai binding
