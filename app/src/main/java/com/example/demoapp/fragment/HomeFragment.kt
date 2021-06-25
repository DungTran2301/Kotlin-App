package com.example.demoapp.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapp.Dish
import com.example.demoapp.FoodAdapter
import com.example.demoapp.R
import com.example.demoapp.RecipeActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(), FoodAdapter.OnDishItemClickListner {
    private var dishList: ArrayList<Dish> = ArrayList()
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    lateinit var foodAdapter: FoodAdapter//RecyclerView.Adapter<FoodAdapter.ViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view: View = inflater.inflate(R.layout.fragment_home, container, false)
        layoutManager = LinearLayoutManager(activity)
        addDish()
        var recyclerView: RecyclerView = view.findViewById(R.id.recycleView)
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
//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment HomeFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//                HomeFragment().apply {
//                    arguments = Bundle().apply {
//                        putString(ARG_PARAM1, param1)
//                        putString(ARG_PARAM2, param2)
//                    }
//                }
//    }
}