package com.example.application2
import com.example.application2.fragments.SignalerFragment
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface Endpoint {


    @GET("getrole/{roleName}/{password}")
    suspend fun getrole(@Path("roleName")roleName:String, @Path("password")password:String): Response<user?>
    @GET("getformulaires")
    suspend fun getformulaires(): Response<List<Formulaire>>
    @GET("count")
    suspend fun count(): Response<Int>

    @GET("getfemmespetit")
    suspend fun getfemmespetit(): Response<Int>

    @GET("gethommespetit")
    suspend fun gethommespetit(): Response<Int>

    @GET("getfemmesmoyen")
    suspend fun getfemmesmoyen(): Response<Int>

    @GET("gethommesmoyen")
    suspend fun gethommesmoyen(): Response<Int>

    @GET("getfemmesgrand")
    suspend fun getfemmesgrand(): Response<Int>

    @GET("gethommesgrand")
    suspend fun gethommesgrand(): Response<Int>

}