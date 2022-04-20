package mumtaz.binar.challangechapterlima.network

import mumtaz.binar.challangechapterlima.model.GetAllFilmResponseItem
import mumtaz.binar.challangechapterlima.model.RequestLogin
import mumtaz.binar.challangechapterlima.model.RequestUser
import mumtaz.binar.challangechapterlima.model.Responseuser
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("apifilm.php")
    fun getAllFilm() : Call<List<GetAllFilmResponseItem>>

    @POST("register.php")
    @FormUrlEncoded
    fun registerUser(
        @Field ("email")email : String,
        @Field ("password")password : String,
        @Field ("username")username : String
    ) : Call<RequestUser>

    @POST("login.php")
    @FormUrlEncoded
    fun loginUser(
        @Field ("email")email : String,
        @Field ("password")password : String
    ) : Call<RequestLogin>
}