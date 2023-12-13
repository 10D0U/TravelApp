package com.projects.travelapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.projects.travelapp.Adapters.CategoryAdapter
import com.projects.travelapp.Adapters.PopularAdapter
import com.projects.travelapp.R

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val introButton: ConstraintLayout = findViewById(R.id.intro_button)
        introButton.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}