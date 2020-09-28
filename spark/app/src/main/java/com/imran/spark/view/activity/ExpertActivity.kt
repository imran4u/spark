package com.imran.spark.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.imran.spark.R
import com.imran.spark.databinding.ActivityExpertBinding
import com.imran.spark.util.snackbar
import com.imran.spark.view.adapter.ExpertAdapter
import com.imran.spark.viewmodel.ExpertViewModel
import com.imran.spark.viewmodel.factory.ExpertViewModelFactory
import kotlinx.android.synthetic.main.activity_expert.*
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class ExpertActivity : AppCompatActivity(), KodeinAware {

    private lateinit var mViewModel: ExpertViewModel
    private val mFactory: ExpertViewModelFactory by instance()

    private lateinit var mExpertAdapter: ExpertAdapter
    private lateinit var mBinding: ActivityExpertBinding

    override val kodein by kodein()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_expert)
        mViewModel = ViewModelProvider(this, mFactory).get(ExpertViewModel::class.java)
        mExpertAdapter = ExpertAdapter(mViewModel.mExpertList)

        recyclerView.adapter = mExpertAdapter
        recyclerView.layoutManager = StaggeredGridLayoutManager(
            2, // span count
            StaggeredGridLayoutManager.VERTICAL
        )
        if (mViewModel.mExpertList.isEmpty()) {
            lifecycleScope.launch() {
                mViewModel.getExpertList()
            }
        }
        initObserver()

    }

    private fun initObserver() {
        mViewModel.mExpertListLiveData.observe(this, Observer {
            if (it != null) {
                mExpertAdapter.notifyDataSetChanged()
            }
        })
        mViewModel.mErrorLiveData.observe(this, Observer {
            mBinding.root.snackbar(it)
        })
    }
}
