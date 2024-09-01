package upeu.edu.pe.navigationjpc2.api

import retrofit2.Call
import retrofit2.http.GET
import upeu.edu.pe.navigationjpc2.model.User

interface ApiService {
    @GET("users")
    fun getUsers(): Call<List<User>>
}