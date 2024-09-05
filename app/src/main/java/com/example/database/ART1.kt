package com.example.database


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ART1(
    @SerialName("client_type")
    val clientType: String,
    @SerialName("dest")
    val dest: String,
    @SerialName("dest_size")
    val destSize: Int,
    @SerialName("expires")
    val expires: String,
    @SerialName("generator")
    val generator: String,
    @SerialName("output")
    val output: String,
    @SerialName("percent")
    val percent: Int,
    @SerialName("src")
    val src: String,
    @SerialName("src_size")
    val srcSize: Int
)