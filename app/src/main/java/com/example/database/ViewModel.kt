package com.example.database

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.launch

/* Created by Taha https://github.com/tahaak67/ at 5/9/2024 */

class ArtViewModel : ViewModel() {

    val client = Provider.client

    var artList by mutableStateOf(emptyList<ART1>())
        private set

    init {
        viewModelScope.launch {
            // TODO: Handle failure ex: no internet
            artList = client.get("https://freefakeapi.io/api/posts").body<List<ART1>>()
        }
    }

}