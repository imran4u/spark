package com.imran.spark.application

import android.app.Application
import com.imran.spark.repository.ExpertRepository
import com.imran.spark.viewmodel.factory.ExpertViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

/**
 * Created by imran on 2020-09-28.
 */
class ExpertApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@ExpertApplication))
        bind() from singleton { ExpertRepository(instance()) }
        bind() from singleton { ExpertViewModelFactory(instance()) }
    }
}
