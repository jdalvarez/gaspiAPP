package com.example.gapiapp.dto

import com.google.gson.annotations.SerializedName

data class RedditResponse (val data:RedditData?)

data class RedditData(val children: List<ChildrenData>?)

data class ChildrenData(val data:ChildrenDataItem?)

data class ChildrenDataItem(
    @SerializedName("title") val title:String?,
    @SerializedName("num_comments") val numComments:Int?,
    @SerializedName("secure_media") val secureMedia: SecureMedia?)

data class SecureMedia(val oembed: ImageData?)

data class ImageData(@SerializedName("thumbnail_url") val thumbnailUrl: String?)