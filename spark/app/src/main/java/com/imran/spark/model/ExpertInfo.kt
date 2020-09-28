package com.imran.spark.model

import com.google.gson.annotations.SerializedName

/**
 * Created by imran on 2020-09-28.
 */
data class ExpertInfo(
    val name: String,
    @SerializedName("short_bio")
    val shortBio: String,
    @SerializedName("profile_pic")
    val profilePIc: String,


    )
