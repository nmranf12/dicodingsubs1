package com.dicoding.submissone.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.submissone.data.response.EventResponse
import com.dicoding.submissone.data.retrofit.ApiConfig
import kotlinx.coroutines.launch

class EventViewModel : ViewModel() {

    private val _upcomingEvents = MutableLiveData<List<EventResponse>>()
    val upcomingEvents: LiveData<List<EventResponse>> = _upcomingEvents

    private val _pastEvents = MutableLiveData<List<EventResponse>>()
    val pastEvents: LiveData<List<EventResponse>> = _pastEvents

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    // Mengambil acara yang akan datang
    fun fetchUpcomingEvents() {
        viewModelScope.launch {
            try {
                val response = ApiConfig.getRetrofitService().getUpcomingEvents()
                if (!response.error) {
                    _upcomingEvents.value = response.events
                } else {
                    _error.value = "Gagal memuat acara yang akan datang: ${response.message}"
                }
            } catch (e: Exception) {
                _error.value = "Error: ${e.message}"
            }
        }
    }

    // Mengambil acara yang telah berlalu
    fun fetchPastEvents() {
        viewModelScope.launch {
            try {
                val response = ApiConfig.getRetrofitService().getPastEvents()
                if (!response.error) {
                    _pastEvents.value = response.events
                } else {
                    _error.value = "Gagal memuat acara yang telah berlalu: ${response.message}" // Pastikan ini tidak memanggil message()
                }
            } catch (e: Exception) {
                _error.value = "Error: ${e.message}"
            }
        }
    }
}
