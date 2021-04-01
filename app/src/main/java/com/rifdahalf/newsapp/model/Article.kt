package com.rifdahalf.newsapp.model


import android.annotation.SuppressLint
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class Article(
    @SerializedName("author")
    val author: String?, // Rizka Alifa Rahmadhani, Rizka Alifa Rahmadhani, Dipna Videlia Putsanra
    @SerializedName("content")
    val content: String?, // tirto.id - Permukaan bumi terbentuk dan mengalami perubahan selama beberapa waktu. Bentuk permukaan bumi yang tidak rata timbul karena pengaruh tekanan dari dalam dan luar permukaan bumi. Adanya bent… [+8069 chars]
    @SerializedName("description")
    val description: String?, // Pengertian tenaga endogen, macam-macamnya, dan pengaruhnya pada kehidupan.
    @SerializedName("publishedAt")
    val publishedAt: String?, // 2021-03-31T06:18:07Z
    @SerializedName("source")
    val source: Source?,
    @SerializedName("title")
    val title: String?, // Pengertian Tenaga Endogen, Macam, dan Pengaruhnya pada Kehidupan - tirto.id
    @SerializedName("url")
    val url: String?, // https://tirto.id/pengertian-tenaga-endogen-macam-dan-pengaruhnya-pada-kehidupan-gbEs
    @SerializedName("urlToImage")
    val urlToImage: String? // https://mmc.tirto.id/image/otf/1024x535/2020/03/17/istock-847586126.jpg
) : Parcelable