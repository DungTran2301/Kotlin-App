package com.example.demoapp.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapp.Dish
import com.example.demoapp.FoodAdapter
import com.example.demoapp.R
import com.example.demoapp.RecipeActivity

class ListFragment : Fragment(), FoodAdapter.OnDishItemClickListner{

    private var dishList: ArrayList<Dish> = ArrayList()
    private var layoutManager: RecyclerView.LayoutManager? = null
    lateinit var foodAdapter: FoodAdapter//RecyclerView.Adapter<FoodAdapter.ViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_list, container, false)

        layoutManager = LinearLayoutManager(activity)
        addDish()
        val recyclerView: RecyclerView = view.findViewById(R.id.recycleView)
        recyclerView.layoutManager = layoutManager

        foodAdapter = FoodAdapter(this)
        foodAdapter.setData(dishList)
        recyclerView.adapter = foodAdapter

        return view
    }
    fun addDish() {
        dishList.add(Dish("Burger", 100, R.drawable.ic_burger, "Ingredients\n" +
                "½ tbsp olive oil\n" +
                "1 onion, peeled and finely chopped\n" +
                "1 x 500g pack British Beef Steak Mince 15% fat\n" +
                "1 tsp mixed dried herbs\n" +
                "1 egg, beaten\n" +
                "4 slices mature Cheddar (optional)\n" +
                "4 white rolls\n" +
                "few round lettuce leaves, torn\n" +
                "1 beef tomato, sliced\n" +
                "ketchup, to serve (optional)"+
                "1 egg, beaten\n" +
                "4 slices mature Cheddar (optional)\n" +
                "4 white rolls\n" +
                "few round lettuce leaves, torn\n" +
                "1 beef tomato, sliced\n" +
                "ketchup, to serve (optional)"))
        dishList.add(Dish("Chicken", 150, R.drawable.ic_chicken, "Ingredients\n" +
                "½ tbsp olive oil\n" +
                "1 onion, peeled and finely chopped\n" +
                "1 x 500g pack British Beef Steak Mince 15% fat\n" +
                "1 tsp mixed dried herbs\n" +
                "1 egg, beaten\n" +
                "4 slices mature Cheddar (optional)\n" +
                "4 white rolls\n" +
                "few round lettuce leaves, torn\n" +
                "1 beef tomato, sliced\n" +
                "ketchup, to serve (optional)"))
        dishList.add(Dish("Alcoholic", 70, R.drawable.ic_alcoholic, "Ingredients\n" +
                "½ tbsp olive oil\n" +
                "1 onion, peeled and finely chopped\n" +
                "1 x 500g pack British Beef Steak Mince 15% fat\n" +
                "1 tsp mixed dried herbs\n" +
                "1 egg, beaten\n" +
                "4 slices mature Cheddar (optional)\n" +
                "4 white rolls\n" +
                "few round lettuce leaves, torn\n" +
                "1 beef tomato, sliced\n" +
                "ketchup, to serve (optional)"))
        dishList.add(Dish("Egg coffee", 70, R.drawable.ic_eggcoffee, "Ingredients\n" +
                "½ tbsp olive oil\n" +
                "1 onion, peeled and finely chopped\n" +
                "1 x 500g pack British Beef Steak Mince 15% fat\n" +
                "1 tsp mixed dried herbs\n" +
                "1 egg, beaten\n" +
                "4 slices mature Cheddar (optional)\n" +
                "4 white rolls\n" +
                "few round lettuce leaves, torn\n" +
                "1 beef tomato, sliced\n" +
                "ketchup, to serve (optional)"))
        dishList.add(Dish("Hot dog", 70, R.drawable.ic_hotdog, "Yes"))
        dishList.add(Dish("Pancake", 70, R.drawable.ic_pancake, "Yes"))
        dishList.add(Dish("Sweat Pea", 70, R.drawable.ic_sweetpea, "Yes"))
        dishList.add(Dish("Strawberry", 70, R.drawable.ic_strowberry, "Yes"))

    }

    override fun onItemClick (item: Dish, position: Int){
        Toast.makeText(activity, item.name, Toast.LENGTH_SHORT).show()
        var intent = Intent(activity, RecipeActivity::class.java)
        intent.putExtra("TITLE", item.name)
        intent.putExtra("PRICE", item.price)
        intent.putExtra("DETAIL", item.detail)
        intent.putExtra("IMAGE", item.image)
        startActivity(intent)
    }
}