package com.dicoding.submissone.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.submissone.adapter.EventAdapter
import com.dicoding.submissone.databinding.FragmentPastEventsBinding
import com.dicoding.submissone.ui.EventViewModel

class PastEventsFragment : Fragment() {
    private var _binding: FragmentPastEventsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: EventViewModel by viewModels()
    private lateinit var adapter: EventAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPastEventsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = EventAdapter(emptyList()) { event ->
            // Tangani klik event di sini
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        observeViewModel()
        viewModel.fetchPastEvents()
    }

    private fun observeViewModel() {
        viewModel.pastEvents.observe(viewLifecycleOwner) { events ->
            adapter.updateEvents(events)
        }

        viewModel.error.observe(viewLifecycleOwner) { error ->
            error?.let {
                Log.e("PastEventsFragment", it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
