package com.imran.spark.repository

import android.content.Context
import com.google.gson.Gson
import com.imran.spark.model.Expert
import com.imran.spark.model.ExpertResult
import java.io.InputStream


/**
 * Created by imran on 2020-09-28.
 */

class ExpertRepository(val context: Context) {

    suspend fun getExpertList(): List<Expert>? {
        return Gson().fromJson(readJSONFromAsset(), ExpertResult::class.java).results
    }

    private suspend fun readJSONFromAsset(): String? {
        var json: String? = null
        try {

            val inputStream: InputStream = context.assets.open("expert.json")
            json = inputStream.bufferedReader().use { it.readText() }
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}
