package com.example.sportappmaximus.model

import android.graphics.Bitmap
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ExerciseModel(
    var image: Bitmap? = null,
    var text: String = ""
) : Parcelable