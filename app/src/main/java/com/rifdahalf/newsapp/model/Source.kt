package com.rifdahalf.newsapp.model


import android.annotation.SuppressLint
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class Source(
    @SerializedName("id")
    val id: String? , // null
    @SerializedName("name")
    val name: String? // Tirto.id
) : Parcelable