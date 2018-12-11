package com.example.a1.afinal

import com.google.gson.annotations.SerializedName

data class Post(

    @SerializedName("userId") var userId: Int?,

    @SerializedName("mobile_number") var mobile_number: String? = null,

    @SerializedName("home_number") var home_number: String? = null,

    @SerializedName("title") var title: String?,

    @SerializedName("body") var body: String?
)