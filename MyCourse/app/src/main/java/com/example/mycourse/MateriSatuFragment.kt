package com.example.mycourse

import java.time.LocalDate
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.disasterapp.Materi
import com.example.mycourse.databinding.FragmentMateriSatuBinding

class MateriSatuFragment : Fragment() {

    private var _binding: FragmentMateriSatuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMateriSatuBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listMateri = generateDummy()
        val materiAdapter = MateriAdapter(listMateri) { materi ->
            Toast.makeText(requireContext(), "You click on ${materi.judul}", Toast.LENGTH_SHORT).show()
        }


        with(binding) {
            rvMateri.apply {
                adapter = materiAdapter
                layoutManager = LinearLayoutManager (requireContext())
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    fun generateDummy(): List<Materi> {
        return listOf(
            Materi(judul = "Gempa", deskripsi = "Alam", tanggal = "2025-10-01"),
            Materi(judul = "Banjir", deskripsi = "Alam", tanggal = "2025-10-02"),
            Materi(judul = "Angin Topan", deskripsi = "Alam", tanggal = "2025-10-03"),
            Materi(judul = "Kebakaran", deskripsi = "Buatan", tanggal = "2025-10-04"),
            Materi(judul = "Tsunami", deskripsi = "Alam", tanggal = "2025-10-05"),
            Materi(judul = "Tanah Longsor", deskripsi = "Alam", tanggal = "2025-10-06"),
            Materi(judul = "Gempa", deskripsi = "Alam", tanggal = "2025-10-07"),
            Materi(judul = "Banjir", deskripsi = "Alam", tanggal = "2025-10-08"),
            Materi(judul = "Gempa", deskripsi = "Alam", tanggal = "2025-10-09"),
            Materi(judul = "Banjir", deskripsi = "Alam", tanggal = "2025-10-10"),
            Materi(judul = "Angin Topan", deskripsi = "Alam", tanggal = "2025-10-11"),
            Materi(judul = "Kebakaran", deskripsi = "Buatan", tanggal = "2025-10-12"),
            Materi(judul = "Tsunami", deskripsi = "Alam", tanggal = "2025-10-13"),
            Materi(judul = "Tanah Longsor", deskripsi = "Alam", tanggal = "2025-10-14"),
            Materi(judul = "Gempa", deskripsi = "Alam", tanggal = "2025-10-15"),
            Materi(judul = "Banjir", deskripsi = "Alam", tanggal = "2025-10-16"),
            Materi(judul = "Gempa", deskripsi = "Alam", tanggal = "2025-10-17"),
            Materi(judul = "Banjir", deskripsi = "Alam", tanggal = "2025-10-18"),
            Materi(judul = "Angin Topan", deskripsi = "Alam", tanggal = "2025-10-19"),
            Materi(judul = "Kebakaran", deskripsi = "Buatan", tanggal = "2025-10-20"),
            Materi(judul = "Tsunami", deskripsi = "Alam", tanggal = "2025-10-21"),
            Materi(judul = "Tanah Longsor", deskripsi = "Alam", tanggal = "2025-10-22"),
            Materi(judul = "Gempa", deskripsi = "Alam", tanggal = "2025-10-23"),
            Materi(judul = "Banjir", deskripsi = "Alam", tanggal = "2025-10-24")
        )
    }

}



//// TODO: Rename parameter arguments, choose names that match
//// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"
//
///**
// * A simple [Fragment] subclass.
// * Use the [MateriSatuFragment.newInstance] factory method to
// * create an instance of this fragment.
// */
//class MateriSatuFragment : Fragment() {
//    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_materi_satu, container, false)
//    }
//
//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment MateriSatuFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            MateriSatuFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
//}

