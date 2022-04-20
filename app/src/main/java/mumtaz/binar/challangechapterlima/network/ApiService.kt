package mumtaz.binar.challangechapterlima.network

import mumtaz.binar.challangechapterlima.model.GetAllFilmResponseItem
import mumtaz.binar.challangechapterlima.model.RequestUser
import mumtaz.binar.challangechapterlima.model.Responseuser
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("apifilm.php")
    fun getAllFilm() : Call<List<GetAllFilmResponseItem>>

    @POST("login.php")
    fun getLogin(@Body req : RequestUser) : Call<List<Responseuser>>
}