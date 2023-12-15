package com.projects.travelapp.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.projects.travelapp.Domains.PopularDomain
import com.projects.travelapp.R
import org.w3c.dom.Text

class DetailsActivity : AppCompatActivity() {
    private lateinit var titleText: TextView
    private lateinit var locationText: TextView
    private lateinit var bedText: TextView
    private lateinit var guideText: TextView
    private lateinit var wifiText: TextView
    private lateinit var descriptionText: TextView
    private lateinit var scoreText: TextView
    private lateinit var picImage: ImageView
    private lateinit var backButton: ImageView

    private lateinit var item: PopularDomain
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        initView()

        setVariables()
    }

    private fun setVariables() {
        item = intent.getSerializableExtra("object") as PopularDomain

        titleText.text = item.title
        scoreText.text = item.score.toString()
        locationText.text = item.location
        bedText.text = item.bed.toString()
        descriptionText.text = item.description

        if (item.guide) {
            guideText.text = "Guide"
        } else {
            guideText.text = "No-Guide"
        }

        if (item.wifi) {
            wifiText.text = "Wifi"
        } else {
            wifiText.text = "No-Wifi"
        }

        val drawableResId: Int = resources.getIdentifier(item.pic, "drawable", packageName)

        Glide.with(this)
            .load(drawableResId)
            .into(picImage)

        backButton.setOnClickListener { finish() }

    }

    private fun initView() {
        titleText = findViewById(R.id.detail_title)
        locationText = findViewById(R.id.detail_location)
        bedText = findViewById(R.id.bed_text)
        guideText = findViewById(R.id.guide_text)
        wifiText = findViewById(R.id.wifi_text)
        descriptionText = findViewById(R.id.description_text)
        scoreText = findViewById(R.id.detail_score)
        picImage = findViewById(R.id.detail_image)
        backButton = findViewById(R.id.back_arrow)
    }
}