package com.imran.spark.model

import com.google.gson.annotations.SerializedName


/**
 * Created by imran on 2020-09-28.
 */
data class Expert(

    @SerializedName("published_at")
    val publishedAt: String,
    val thumbnail: String,
    val description: String,
    val expert: ExpertInfo,
    @SerializedName("action_counts")
    val actionAccount: AccountAction,
)
