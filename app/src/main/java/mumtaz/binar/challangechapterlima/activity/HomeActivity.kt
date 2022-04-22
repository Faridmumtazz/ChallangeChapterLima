package mumtaz.binar.challangechapterlima.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_home.*
import mumtaz.binar.challangechapterlima.R
import mumtaz.binar.challangechapterlima.adapter.AdapterFilm
import mumtaz.binar.challangechapterlima.viewmodel.ViewModelFilm

class HomeActivity : AppCompatActivity() {

    lateinit var prefs : SharedPreferences
    lateinit var adapterfilm : AdapterFilm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        adapterfilm = AdapterFilm(){
            val pindah = Intent(this, DetailActivity::class.java)
            pindah.putExtra("detailfilm", it)
            startActivity(pindah)

        }
        rv_binar.layoutManager = LinearLayoutManager(this)
        rv_binar.adapter = adapterfilm

        img_profile.setOnClickListener {

           val pindah = Intent(this, ProfileActivity::class.java)
            startActivity(pindah)
        }

        prefs = getSharedPreferences("DATANAMA", Context.MODE_PRIVATE)

        val nama = prefs.getString("NAMA", "")
        tv_usernamee.text = nama


        getDataFilm()
    }


    fun getDataFilm(){
        val viewModel = ViewModelProvider(this).get(ViewModelFilm::class.java)
        viewModel.getLiveDataObserver().observe(this, Observer {
            if (it != null){
                adapterfilm.setDataFilm(it)
                adapterfilm.notifyDataSetChanged()
            }
        })
        viewModel.getApiFilm()
    }
}