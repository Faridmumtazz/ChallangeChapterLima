package mumtaz.binar.challangechapterlima.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mumtaz.binar.challangechapterlima.model.GetAllFilmResponseItem
import mumtaz.binar.challangechapterlima.model.Responseuser

class ViewModelUser : ViewModel() {

    lateinit var liveDataUser : MutableLiveData<Responseuser>

    init {
        liveDataUser = MutableLiveData()
    }

    fun getLiveDataObserver() : MutableLiveData<Responseuser> {
        return liveDataUser
    }
}