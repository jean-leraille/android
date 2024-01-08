package com.example.episen.data.models

import com.google.gson.annotations.SerializedName

data class Commune(
    @SerializedName("code") var code: String?,
    @SerializedName("nom") var nom: String?,
)


