package com.imran.spark.model

/**
 * Created by imran on 2020-09-28.
 */
data class AccountAction(
    val like: Int,
    //View count is missing in json file
    val view: Int? = 0
)
