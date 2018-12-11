package com.example.a1.afinal


import com.google.gson.annotations.SerializedName

data class User (

    @SerializedName("userId") var userId: Int?,

    @SerializedName("mobile_number") var mobile_number: String?,

    @SerializedName("home_number") var home_number: String?,

    @SerializedName("title") var title: String?,

    @SerializedName("body") var body: String?
)