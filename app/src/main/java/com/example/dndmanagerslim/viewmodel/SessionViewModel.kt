package com.example.dndmanagerslim.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dndmanagerslim.data.SessionData
import com.example.dndmanagerslim.repository.DndRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SessionViewModel(
    private val repository: DndRepository
) : ViewModel() {
    private val _sessions = MutableStateFlow<List<SessionData>>(emptyList())
    val sessions: StateFlow<List<SessionData>> = _sessions.asStateFlow()
    private val _session = MutableStateFlow<SessionData?>(null)
    val session: StateFlow<SessionData?> = _session.asStateFlow()

    init {
        fetchSessions()
    }

    private fun fetchSessions() {
        viewModelScope.launch {
            try {
                val result = repository.getSessions()
                _sessions.value = result
            } catch (e: Exception) {
                // Fehlerbehandlung
                e.printStackTrace()
            }
        }
    }

}
