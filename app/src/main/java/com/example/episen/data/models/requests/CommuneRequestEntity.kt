package com.example.episen.data.models.requests

import com.google.gson.annotations.SerializedName

data class CommuneRequestEntity(
    @SerializedName("nom") var nom: String?,
)