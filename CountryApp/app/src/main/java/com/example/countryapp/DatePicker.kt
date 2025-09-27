package com.example.countryapp

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class DatePicker : DialogFragment() {
    //kl datepicker di init ke ui,
    //apa yg harus kita sediakan ke ui
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState)
//ambil data calender dr andoid os
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        //tampilkan ui berdasarkan data calender android os
        return DatePickerDialog (
            requireActivity(),
            activity as DatePickerDialog.OnDateSetListener,
            year, month, day
        )


        //when user click on calendar button

    }


}