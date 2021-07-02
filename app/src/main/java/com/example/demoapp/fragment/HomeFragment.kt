package com.example.demoapp.fragment

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.AdapterView
import android.widget.Toast
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapp.*
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeFragment : Fragment()  {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home, container, false)
        val homeMealFragment = HomeMealFragment()
        val homeDishFragment = HomeDishFragment()
        val homeDrinkFragment = HomeDrinkFragment()
        val homeMainFragment = HomeMainFragment()
        val homeNavigation = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.home_toolbar)

        makeCurrentFragment(homeMainFragment)

        homeNavigation.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.ic_common -> {
                    makeCurrentFragment(homeMainFragment)
                    homeNavigation.title = "Bạn muốn ăn gì"
                }
                R.id.ic_meal -> {
                    makeCurrentFragment(homeMealFragment)
                    homeNavigation.title = "Bữa ăn"
                }
                R.id.ic_dish -> {
                    makeCurrentFragment(homeDishFragment)
                    homeNavigation.title = "Món ngon"
                }
                R.id.ic_drink -> {
                    makeCurrentFragment(homeDrinkFragment)
                    homeNavigation.title = "Đồ uống"
                }
            }
            true
        }

//        homeNavigation.setNavigationOnClickListener{
//            activity?.onBackPressed()
//        }
        return view
    }

    private fun onBackPressed() {
        TODO("Not yet implemented")
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            replace(R.id.nav_host_home_fragment, fragment)
            commit()
        }


}