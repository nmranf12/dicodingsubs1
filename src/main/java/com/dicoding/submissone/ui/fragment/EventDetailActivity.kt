package com.dicoding.submissone.ui.fragment

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.dicoding.submissone.data.response.EventResponse
import com.dicoding.submissone.databinding.ActivityEventDetailBinding

class EventDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEventDetailBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Update this line to avoid deprecation warning
        val event = intent.getParcelableExtra<EventResponse>("EVENT_DATA", EventResponse::class.java)

        event?.let {
            Glide.with(this).load(it.image).into(binding.imageView)
            binding.textViewName.text = it.name
            binding.textViewOwner.text = it.ownerName
            binding.textViewTime.text = it.beginTime
            binding.textViewQuota.text = (it.quota - it.registrant).toString()
            binding.textViewDescription.text = it.description
        } ?: run {
            binding.textViewName.text = "Event not found"
            binding.textViewOwner.text = ""
            binding.textViewTime.text = ""
            binding.textViewQuota.text = ""
            binding.textViewDescription.text = "No details available."
        }
    }
}
