package com.projects.travelapp.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.projects.travelapp.Adapters.CategoryAdapter
import com.projects.travelapp.Adapters.PopularAdapter
import com.projects.travelapp.Domains.CategoryDomain
import com.projects.travelapp.Domains.PopularDomain
import com.projects.travelapp.R

class MainActivity : AppCompatActivity() {
    private lateinit var adapterPopular: PopularAdapter
    private lateinit var adapterCategory: CategoryAdapter

    private lateinit var recyclerViewPopular: RecyclerView
    private lateinit var recyclerViewCategory: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val items: ArrayList<PopularDomain> = ArrayList();
        items.add(
            PopularDomain("Mar caible, avendia lago", "Miami Beach",
            "This 2 bed /1 bath home boasts an enormous" +
                    "open-living plan, accented by striking " +
                    "architectural features and high-end finished." +
                    " Feel inspired by open sight lines that" +
                    " embrace the outdoors, crowned by stunning" +
                    " coffered ceilings. ", 2, true, 4.8, "pic1", true, 1000))
        items.add(PopularDomain("Passo Rolle, TN", "Huwaii Beach",
            "This 2 bed /1 bath home boasts an enormous" +
                    "open-living plan, accented by striking " +
                    "architectural features and high-end finished." +
                    " Feel inspired by open sight lines that" +
                    " embrace the outdoors, crowned by stunning" +
                    " coffered ceilings. ", 1, true, 5.0, "pic2", false, 2500))
        items.add(PopularDomain("Mar caible, avendia lago", "Miami Beach",
            "This 2 bed /1 bath home boasts an enormous" +
                    "open-living plan, accented by striking " +
                    "architectural features and high-end finished." +
                    " Feel inspired by open sight lines that" +
                    " embrace the outdoors, crowned by stunning" +
                    " coffered ceilings. ", 3, true, 4.3, "pic3", true, 3000))

        recyclerViewPopular = findViewById(R.id.view_popular)
        recyclerViewPopular.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        adapterPopular = PopularAdapter(items)
        recyclerViewPopular.adapter = adapterPopular

        val categoryList: ArrayList<CategoryDomain> = ArrayList();
        categoryList.add(CategoryDomain("Beaches", "cat1"))
        categoryList.add(CategoryDomain("Camps", "cat2"))
        categoryList.add(CategoryDomain("Forest", "cat3"))
        categoryList.add(CategoryDomain("Desert", "cat4"))
        categoryList.add(CategoryDomain("Mountain", "cat5"))

        recyclerViewCategory = findViewById(R.id.view_category)
        recyclerViewCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        adapterCategory = CategoryAdapter(categoryList)
        recyclerViewCategory.adapter = adapterCategory
    }
}