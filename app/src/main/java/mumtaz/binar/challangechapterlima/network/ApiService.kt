package mumtaz.binar.challangechapterlima.network

import mumtaz.binar.challangechapterlima.model.*
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
    ) : Call<Responseuser>

    @POST("updateuser.php")
    @FormUrlEncoded
    fun updateUser(
        @Field ("id") id : Int,
        @Field("address") address: String,
        @Field("complete_name") complete_name: String,
        @Field("dateofbirth") dateofbirth: String,
        @Field("username") username: String

    ) : Call<UpdateUser>
}