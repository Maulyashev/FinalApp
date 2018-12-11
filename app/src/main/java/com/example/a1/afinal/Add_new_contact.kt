package com.example.a1.afinal

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.add_new_contact.*
import kotlinx.android.synthetic.main.post_item_activity.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Add_new_contact : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_new_contact)

        val gson = GsonBuilder().create()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
        okHttpClient.addInterceptor(interceptor)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient.build())
            .build()

        val apiEndpoint = retrofit.create(ApiEndpoint::class.java)

        btn_add.setOnClickListener{
            val post_id = Edit_id.text.toString()
            val post_name = Edit_name.text.toString()
            val post_mobile_number = Edit_mobile_number.text.toString()
            val post_home_number = Edit_home_number.text.toString()

            val post = Post (
                1, mobile_number = post_mobile_number, home_number = post_home_number, title = post_id, body = post_name)

            val call = apiEndpoint.createPost(post)

            call.enqueue(object : Callback<Post> {

                override fun onResponse(call: Call<Post>?, response: Response<Post>?) {
                    val post = response?.body()
                    Log.d("Post: ", post.toString())
                }

                override fun onFailure(call: Call<Post>?, t: Throwable?) {
                    Log.e("Error: ", t?.message)
                }

            })
            val result = Intent()
            result.putExtra("post_id", title )
            result.putExtra("post_name", body)
            result.putExtra("post_mobile_number", mobile_number)
            result.putExtra("post_home_number", home_number)


            setResult(Activity.RESULT_OK, result)
            finish()
        }
    }
}
