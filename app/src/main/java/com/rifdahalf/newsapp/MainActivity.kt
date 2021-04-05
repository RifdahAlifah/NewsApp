package com.rifdahalf.newsapp

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.StructuredPostal.COUNTRY
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.rifdahalf.newsapp.BuildConfig.API_KEY
import com.rifdahalf.newsapp.model.ResponseNews
import com.rifdahalf.newsapp.network.RetrofitConfig
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //buat ngambil tanggal sekarang
    val date = getCurrentDateTime()
    fun getCurrentDateTime(): Date {
        //Berisi tanggal sekarang
        return Calendar.getInstance().time
    }

    //buat nge format tanggalnya
    fun Date.toString(format : String, locale: Locale = Locale.getDefault()): String{
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

    //untuk men clear suatu activity (biar langsung ke home)
    companion object {
        fun getLaunchService (from : Context) = Intent(from, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //untuk menyembunyikan action bar/title bar
//        supportActionBar?.hide()

        iv_profile_setting.setOnClickListener(this)
        tv_date_main.text = date.toString("dd/MM/yyyy")
        getNews()
    }

    private fun getNews() {
        val loading = ProgressDialog.show(this, "Request Data", "Loading ...")

        RetrofitConfig.getInstance().getTopHeadlinesNews(COUNTRY, API_KEY).enqueue(
            object : Callback<ResponseNews> {

                override fun onResponse(call: Call<ResponseNews>, response: Response<ResponseNews>) {
                    //mengecek data
                    Log.d("Response", "Success" + response.body()?.articles)
                    loading.dismiss()

                    if(response.isSuccessful){
                        val status = response.body()?.status
                        if (status.equals("ok")){
                            Toast.makeText(this@MainActivity, "Data Success !", Toast.LENGTH_SHORT).show()

                            //untuk menampung data article
                            val newsData = response.body()?.articles

                            //untuk mengatur data yang paling gede pertama
                            Glide.with(this@MainActivity).load(newsData?.component5()?.urlToImage)
                                .centerCrop().into(iv_breaking_item)
                            title_breaking_item.text = newsData?.component5()?.title.toString()
                            tv_date_release_item.text = newsData?.component5()?.publishedAt.toString()
                            tv_author_breaking.text = newsData?.component5()?.author.toString()

                            //menyambungkan pada adapter
                            val newsAdapter = NewsAdapter(this@MainActivity, newsData)
                            rv_main.adapter = newsAdapter
                            rv_main.layoutManager = LinearLayoutManager(this@MainActivity)

                        } else {
                            //kalau gagal di local
                            Toast.makeText(this@MainActivity, "Data Failed !", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                //proses gagal pada server
                override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                    Log.d("Response", "Failed" + t.localizedMessage)
                    loading.dismiss()

                }

            }
        )
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.iv_profile_setting -> startActivity(Intent(ProfileActivity.getLaunchService(this)))
        }
    }
}