package com.imran.spark.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.imran.spark.model.Expert
import com.imran.spark.repository.ExpertRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by imran on 2020-09-28.
 */
class ExpertViewModel(private val repository: ExpertRepository) : ViewModel() {
    val mErrorLiveData = MutableLiveData<String>()
    val mExpertListLiveData = MutableLiveData<List<Expert>>()

    suspend fun getExpertList() = withContext(Dispatchers.Main) {
        try {
            val experts = repository.getExpertList()
            mExpertListLiveData.postValue(experts)
        } catch (e: Exception) {
            mErrorLiveData.value = e.message
        }
    }
}
