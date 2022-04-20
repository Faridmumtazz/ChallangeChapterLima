package mumtaz.binar.challangechapterlima.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import mumtaz.binar.challangechapterlima.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tv_daftar.setOnClickListener{


            startActivity(Intent(this, RegisterActivity::class.java))
        }

        btn_masuk.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}