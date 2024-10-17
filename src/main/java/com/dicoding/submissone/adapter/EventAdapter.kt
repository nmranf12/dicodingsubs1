package com.dicoding.submissone.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.submissone.R
import com.dicoding.submissone.data.response.EventResponse
import com.dicoding.submissone.databinding.ItemEventBinding

class EventAdapter(
    private var events: List<EventResponse>,
    private val onClick: (EventResponse) -> Unit
) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    inner class EventViewHolder(private val binding: ItemEventBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(event: EventResponse) {
            binding.textViewName.text = event.name
            binding.textViewOwner.text = event.ownerName
            binding.textViewTime.text = event.beginTime

            // Memastikan bahwa URL gambar tidak null atau kosong sebelum memuat
            if (!event.image.isNullOrEmpty()) {
                Glide.with(binding.root.context).load(event.image).into(binding.imageView)
            } else {
                binding.imageView.setImageResource(R.drawable.placeholder_image) // Gambar placeholder
            }

            binding.root.setOnClickListener { onClick(event) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val binding = ItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(events[position])
    }

    override fun getItemCount(): Int = events.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateEvents(newEvents: List<EventResponse>) {
        events = newEvents
        notifyDataSetChanged() // Memperbarui tampilan dengan data baru
    }
}
