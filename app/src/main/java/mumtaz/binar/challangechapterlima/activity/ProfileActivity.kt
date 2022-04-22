package mumtaz.binar.challangechapterlima.activity

import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_profile.*
import mumtaz.binar.challangechapterlima.R
import mumtaz.binar.challangechapterlima.model.UpdateUser
import mumtaz.binar.challangechapterlima.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileActivity : AppCompatActivity() {
    lateinit var prefs : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        prefs = getSharedPreferences("DATANAMA", Context.MODE_PRIVATE)


        btn_updateprofile.setOnClickListener {
            val id = prefs.getString("id","").toString()
            val name = prefs.getString("user", "")
            val nl = profile_namalengkap.text.toString()
            val tgl = profile_tgl.text.toString()
            val alamat = profile_alamat.text.toString()
            updateDataUser(id!!.toInt(),tgl, nl, alamat)
            finish()
        }

        btn_logoutprofile.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("LOGOUT")
                .setMessage("Yakin Ingin Logout?")
                .setNegativeButton("Tidak"){ dialogInterface: DialogInterface, _: Int ->
                    dialogInterface.dismiss()
                }.setPositiveButton("Ya"){_: DialogInterface, _: Int ->
                    val sf = getSharedPreferences("DATANAMA",Context.MODE_PRIVATE )
                    val sff = sf.edit()
                    sff.clear()
                    sff.apply()
                    finish()
                }.show()

        }
    }

    fun updateDataUser( id : Int, address : String, complete_name : String, dateofbirth : String){
        ApiClient.instance.updateUser(id,dateofbirth, complete_name,address)
            .enqueue(object : Callback<UpdateUser>{
                override fun onResponse(call: Call<UpdateUser>, response: Response<UpdateUser>) {
                    if (response.isSuccessful){

                        Toast.makeText(this@ProfileActivity, "Berhasil", Toast.LENGTH_LONG).show()
                    } else{
                        Toast.makeText(this@ProfileActivity, "Gagal", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<UpdateUser>, t: Throwable) {
                    Toast.makeText(this@ProfileActivity, "Gagal", Toast.LENGTH_LONG).show()
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