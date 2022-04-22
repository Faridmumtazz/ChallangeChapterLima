package mumtaz.binar.challangechapterlima.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mumtaz.binar.challangechapterlima.model.GetAllFilmResponseItem
import mumtaz.binar.challangechapterlima.model.Responseuser
import mumtaz.binar.challangechapterlima.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelUser : ViewModel() {

    lateinit var liveDataUser : MutableLiveData<Responseuser>

    init {
        liveDataUser = MutableLiveData()
    }

    fun getLiveDataObserver() : MutableLiveData<Responseuser> {
        return liveDataUser
    }

    fun getApiUser() {
        ApiClient.instance.getAllUser()
            .enqueue(object : Callback<Responseuser>{
                override fun onResponse(
                    call: Call<Responseuser>,
                    response: Response<Responseuser>
                ) {
                    if (response.isSuccessful){
                        liveDataUser.postValue(response.body())
                    }else{
                        liveDataUser.postValue(null)
                    }
                }

                override fun onFailure(call: Call<Responseuser>, t: Throwable) {
                    liveDataUser.postValue(null)
                }

            })
    }
}