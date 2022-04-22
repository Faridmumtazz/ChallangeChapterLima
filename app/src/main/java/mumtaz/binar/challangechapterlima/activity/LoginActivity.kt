package mumtaz.binar.challangechapterlima.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import mumtaz.binar.challangechapterlima.R
import mumtaz.binar.challangechapterlima.model.RequestLogin
import mumtaz.binar.challangechapterlima.model.Responseuser
import mumtaz.binar.challangechapterlima.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    lateinit var prefs : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tv_daftar.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        prefs = getSharedPreferences("DATANAMA", Context.MODE_PRIVATE)

        btn_masuk.setOnClickListener {
            val email = et_email.text.toString()
            val pass = et_pass.text.toString()

            val sf = prefs.edit()
            sf.putString("NAMA", email)
            sf.apply()

            postDataLogin(email, pass)
            finish()

        }
    }

    fun postDataLogin(email : String, pass: String){
        ApiClient.instance.loginUser(email,pass)
            .enqueue(object : Callback<Responseuser>{
                override fun onResponse(
                    call: Call<Responseuser>,
                    response: Response<Responseuser>
                ) {
                    if (response.isSuccessful){
                        val data = response.body()
                        val sf = prefs.edit()
                        sf.putString("id", data?.id.toString())
                        sf.apply()
                        startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                        Toast.makeText(this@LoginActivity, "Berhasil", Toast.LENGTH_LONG).show()
                    }else {
                        Toast.makeText(this@LoginActivity, "Gagal", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<Responseuser>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, "Gagal", Toast.LENGTH_LONG).show()
                }

            })
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}