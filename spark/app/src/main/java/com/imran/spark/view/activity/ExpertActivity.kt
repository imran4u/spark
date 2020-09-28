package com.imran.spark.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.imran.spark.R
import com.imran.spark.viewmodel.ExpertViewModel
import com.imran.spark.viewmodel.factory.ExpertViewModelFactory
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class ExpertActivity : AppCompatActivity(), KodeinAware {

    private lateinit var mViewModel: ExpertViewModel
    private val mFactory: ExpertViewModelFactory by instance()

    override val kodein by kodein()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expert)
        mViewModel = ViewModelProvider(this, mFactory).get(ExpertViewModel::class.java)
        lifecycleScope.launch(){
            mViewModel.getExpertList()
        }

        mViewModel.mExpertListLiveData.observe(this, Observer {
            it?.forEach{ export->
                Log.d("imran", export.description)
            }
        })
    }
}
