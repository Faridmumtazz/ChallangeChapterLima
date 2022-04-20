package mumtaz.binar.challangechapterlima.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register.*
import mumtaz.binar.challangechapterlima.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_daftar.setOnClickListener {

            val username = input_username.text.toString()
            val  email = input_email.text.toString()
            val pass = input_pass.text.toString()
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}