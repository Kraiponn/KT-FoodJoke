package com.codemakerlab.foodmaster.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.codemakerlab.foodmaster.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (
        repository: Repository,
        application: Application
) : AndroidViewModel(application) {
}