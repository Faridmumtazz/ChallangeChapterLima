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
            val cn = input_email.text.toString()
            val dob = input_pass.text.toString()
            val alamat = input_ulangipass.text.toString()
            postDataUser(alamat, cn, dob, username)
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    fun postDataUser(alamat : String, cn : String, dob: String, username : String) {
        ApiClient.instance.getLogin(RequestUser(alamat, cn, dob, username))
            .enqueue(object : Callback<List<Responseuser>>{
                override fun onResponse(
                    call: Call<List<Responseuser>>,
                    response: Response<List<Responseuser>>
                ) {
                    if (response.isSuccessful){
                        Toast.makeText(this@RegisterActivity, response.message(), Toast.LENGTH_LONG).show()
                    }else {
                        Toast.makeText(this@RegisterActivity, "failed", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<List<Responseuser>>, t: Throwable) {
                    Toast.makeText(this@RegisterActivity, "failed", Toast.LENGTH_LONG).show()
                }

            })
    }
}