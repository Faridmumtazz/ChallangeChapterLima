package mumtaz.binar.challangechapterlima.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*
import mumtaz.binar.challangechapterlima.R
import mumtaz.binar.challangechapterlima.model.RequestUser
import mumtaz.binar.challangechapterlima.model.Responseuser
import mumtaz.binar.challangechapterlima.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_daftar.setOnClickListener {

            val username = input_username.text.toString()
            val email = input_email.text.toString()
            val pass = input_pass.text.toString()
            val pw = input_ulangipass.text.toString()
            postDataUser( email, pass, username)
            val pindah = Intent(this, LoginActivity::class.java)
            pindah.putExtra("updateuser", username)
            startActivity(pindah)
        }
    }

    fun postDataUser( email : String, pass: String, username : String) {
        ApiClient.instance.registerUser(email, pass, username)
            .enqueue(object : Callback<RequestUser>{
                override fun onResponse(
                    call: Call<RequestUser>,
                    response: Response<RequestUser>
                ) {
                    if (response.isSuccessful){
                        Toast.makeText(this@RegisterActivity, "berhasil", Toast.LENGTH_LONG).show()
                    }else {
                        Toast.makeText(this@RegisterActivity, "gagal", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<RequestUser>, t: Throwable) {
                    Toast.makeText(this@RegisterActivity, "gagal", Toast.LENGTH_LONG).show()
                }

            })
    }
}