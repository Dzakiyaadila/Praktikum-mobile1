package com.example.myshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myshop.databinding.FragmentCheckoutBinding

class CheckoutFragment : Fragment() {
    private var _binding : FragmentCheckoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCheckoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            val args: CheckoutFragmentArgs by navArgs()
            var productName = args.productName
            txtProductName.text = productName

            //ketika address di klik, nav akan ke address fragment

            edtAddress.setOnClickListener {
                val action = CheckoutFragmentDirections.actionCheckoutFragmentToAddressFragment()
                //find navigation and navigate action
                findNavController().navigate(action)
            }

            btnDone.setOnClickListener {
                findNavController().navigateUp()
            }
            //ambil data yg dikirim oleh navigasi sebelumnya
            findNavController().currentBackStackEntry
                ?.savedStateHandle?.let { handle ->
                    handle.getLiveData<String>("address").observe(viewLifecycleOwner) {
                    res -> edtAddress.setText(res)
            }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}