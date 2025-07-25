package com.example.dndmanagerslim.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dndmanagerslim.data.QuestData
import com.example.dndmanagerslim.repository.DndRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class QuestViewModel(
    private val repository: DndRepository
) : ViewModel() {

    private val _questList: MutableStateFlow<List<QuestData>> = MutableStateFlow(emptyList())
    val questList: StateFlow<List<QuestData>> = _questList.asStateFlow()
    private val _quest: MutableStateFlow<QuestData?> = MutableStateFlow(null)
    val quest: StateFlow<QuestData?> = _quest.asStateFlow()

    init {
        fetchQuests()
    }

    fun fetchQuests() {
        viewModelScope.launch {
            try {
                val result = repository.getQuests()
                _questList.value = result
            } catch (e: Exception) {
                // Fehlerbehandlung
                e.printStackTrace()
            }
        }
    }
}