package com.example.episen.data.network
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitClient {
    var headerMap = HashMap<String, String>()

    val api: Api
    companion object {
        var BASE_URL = "https://geo.api.gouv.fr/"
    }

    init {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY



        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(180, TimeUnit.SECONDS)
            .connectTimeout(180, TimeUnit.SECONDS)
        /*    .addInterceptor(
                BasicAuthInterceptor(
                    "hys-test",
                    "hys-test"
                ))*/

        //if(BuildConfig.DEBUG) {
            okHttpClient
                .addInterceptor(loggingInterceptor)
                .build()
        //}

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())
            .build()
        api = retrofit.create(Api::class.java)
    }

    fun addToHeader(key: String, value: String){
        headerMap[key] = value
    }
}