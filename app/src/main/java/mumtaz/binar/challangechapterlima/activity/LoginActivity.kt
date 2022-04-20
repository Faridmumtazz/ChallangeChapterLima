package mumtaz.binar.challangechapterlima.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import mumtaz.binar.challangechapterlima.R
import mumtaz.binar.challangechapterlima.model.RequestLogin
import mumtaz.binar.challangechapterlima.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tv_daftar.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        btn_masuk.setOnClickListener {
            val email = et_email.text.toString()
            val pass = et_pass.text.toString()
            postDataLogin(email, pass)
            finish()

        }
    }

    fun postDataLogin(email : String, pass: String){
        ApiClient.instance.loginUser(email,pass)
            .enqueue(object : Callback<RequestLogin>{
                override fun onResponse(
                    call: Call<RequestLogin>,
                    response: Response<RequestLogin>
                ) {
                    if (response.isSuccessful){
                        startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                        Toast.makeText(this@LoginActivity, "Berhasil", Toast.LENGTH_LONG).show()
                    }else {
                        Toast.makeText(this@LoginActivity, "Gagal", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<RequestLogin>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, "Gagal", Toast.LENGTH_LONG).show()
                }

            })
    }
}