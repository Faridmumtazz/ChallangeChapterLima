package mumtaz.binar.challangechapterlima.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import mumtaz.binar.challangechapterlima.R
import mumtaz.binar.challangechapterlima.model.GetAllFilmResponseItem

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detailfilm = intent.getParcelableExtra<GetAllFilmResponseItem>("detailfilm")

        tv_detailjudulfilm.text = detailfilm?.title
        tv_tanggal.text = detailfilm?.createdAt
        tv_detaildirector.text = detailfilm?.director
        tv_desc.text = detailfilm?.synopsis

        Glide.with(this).load(detailfilm?.image).into(img_detail)
    }
}