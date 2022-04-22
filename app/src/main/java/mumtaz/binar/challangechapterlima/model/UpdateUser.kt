package mumtaz.binar.challangechapterlima.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UpdateUser(
    @SerializedName("id")
    val id: Int,
    @SerializedName("address")
    val address: String,
    @SerializedName("complete_name")
    val completeName: String,
    @SerializedName("dateofbirth")
    val dateofbirth: String,
    @SerializedName("username")
    val username: String
) : Parcelable
