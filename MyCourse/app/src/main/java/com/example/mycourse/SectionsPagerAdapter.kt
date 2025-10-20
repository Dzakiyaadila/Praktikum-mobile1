package com.example.mycourse


import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

//class yg digunakan untuk mengatur antara Tab Layout dan ViewPager
class SectionsPagerAdapter(activity: AppCompatActivity) :
    FragmentStateAdapter(activity) {
    override fun createFragment(position: Int): androidx.fragment.app.Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = MateriSatuFragment()
            1 -> fragment = MateriDuaFragment()
        }
        return fragment as Fragment
    }
    override fun getItemCount(): Int {
        return 2
    }
}