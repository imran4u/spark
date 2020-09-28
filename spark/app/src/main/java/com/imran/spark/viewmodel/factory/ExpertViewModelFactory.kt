package com.imran.spark.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.imran.spark.repository.ExpertRepository
import com.imran.spark.viewmodel.ExpertViewModel

/**
 * Created by imran on 2020-09-28.
 */
class ExpertViewModelFactory(
    private val repository: ExpertRepository,
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ExpertViewModel(repository) as T
    }
}
