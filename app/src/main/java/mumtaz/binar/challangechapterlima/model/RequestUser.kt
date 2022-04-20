package mumtaz.binar.challangechapterlima.model

import com.google.gson.annotations.SerializedName

data class RequestUser(
    @SerializedName("address")
    val address: Any,
    @SerializedName("complete_name")
    val completeName: Any,
    @SerializedName("dateofbirth")
    val dateofbirth: Any,
    @SerializedName("username")
    val username: String
)