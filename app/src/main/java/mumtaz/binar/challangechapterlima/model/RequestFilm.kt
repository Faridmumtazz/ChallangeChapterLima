package mumtaz.binar.challangechapterlima.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RequestFilm (
    @SerializedName("synopsis")
    val synopsis: String,
    @SerializedName("director")
    val director: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("title")
    val title: String
) : Parcelable