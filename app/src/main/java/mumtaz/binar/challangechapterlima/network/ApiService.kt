package mumtaz.binar.challangechapterlima.network

import mumtaz.binar.challangechapterlima.model.GetAllFilmResponseItem
import mumtaz.binar.challangechapterlima.model.PostFilmResponse
import mumtaz.binar.challangechapterlima.model.RequestFilm
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("apifilm.php")
    fun getAllFilm() : Call<List<GetAllFilmResponseItem>>

    @POST("login.php/{email}/{password}")
    fun getLogin()
}