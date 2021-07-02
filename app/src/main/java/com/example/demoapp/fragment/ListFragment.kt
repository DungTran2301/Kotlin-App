package com.example.demoapp.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapp.Dish
import com.example.demoapp.FoodAdapter
import com.example.demoapp.R
import com.example.demoapp.RecipeActivity
import com.example.demoapp.databinding.FragmentListBinding


class ListFragment : Fragment(), FoodAdapter.OnDishItemClickListner{

    private var dishList: ArrayList<Dish> = ArrayList()
    private var layoutManager: RecyclerView.LayoutManager? = null
    lateinit var foodAdapter: FoodAdapter//RecyclerView.Adapter<FoodAdapter.ViewHolder>

    lateinit var binding : FragmentListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        //val view: View = inflater.inflate(R.layout.fragment_list, container, false)
        binding = FragmentListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layoutManager = LinearLayoutManager(activity)
        addDish()
        val recyclerView: RecyclerView = view.findViewById(R.id.recycleView)
        recyclerView.layoutManager = layoutManager

        foodAdapter = FoodAdapter(dishList, this)
        searchView()
        recyclerView.adapter = foodAdapter
    }


    private fun searchView(){
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener, androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                foodAdapter.getFilter().filter(query)
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                foodAdapter.getFilter().filter(newText)
                return true
            }
        })
    }

    fun addDish() {
        dishList.add(Dish("Cá lóc kho nghệ", 100, R.drawable.ca_loc_kho_nghe, resources.getString(R.string.ca_loc_kho_nghe)))

        dishList.add(Dish("Rau muống xào tỏi", 20, R.drawable.rau_muong_xao_toi, resources.getString(R.string.rau_muong_xao_toi)))
        dishList.add(Dish("Mì Ý spaghetti", 70, R.drawable.my_y, resources.getString(R.string.my_y)))
        dishList.add(Dish("Egg coffee", 70, R.drawable.ic_eggcoffee, "yes"))
        dishList.add(Dish("Hot dog", 70, R.drawable.ic_hotdog, "Yes"))
        dishList.add(Dish("Pancake", 70, R.drawable.ic_pancake, "Yes"))
        dishList.add(Dish("Sweat Pea", 70, R.drawable.ic_sweetpea, "Yes"))
        dishList.add(Dish("Strawberry", 70, R.drawable.ic_strowberry, "Yes"))

    }

    override fun onItemClick(item: Dish, position: Int){
        Toast.makeText(activity, item.name, Toast.LENGTH_SHORT).show()
        var intent = Intent(activity, RecipeActivity::class.java)
        intent.putExtra("TITLE", "Công thức")
        intent.putExtra("NAME", item.name)
        intent.putExtra("PRICE", item.price)
        intent.putExtra("DETAIL", item.detail)
        intent.putExtra("IMAGE", item.image)
        startActivity(intent)
    }
}

