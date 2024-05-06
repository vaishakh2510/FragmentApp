package com.example.fragmentapp
import retrofit2.Response
import retrofit2.http.GET
data class App (
    var id: String,
    var cnt: Int
)
interface AppCrud {
    @GET("/simple/app")
    suspend fun apps() : Response<List<App>>
}

fun abc() : String? = null