package com.example.sportappmaximus.util

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.sportappmaximus.MainActivity
import com.example.sportappmaximus.R
import com.example.sportappmaximus.adapter.ChatRecyclerViewAdapter
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_chat_window.*

fun Context.isLocationPermissionGranted(): Boolean =
    ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) ==
            PackageManager.PERMISSION_GRANTED

fun AppCompatActivity.requestLocationPermission() {
    ActivityCompat.requestPermissions(
        this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 12
    )
}

fun Fragment.mainActivity() = requireActivity() as MainActivity

fun Fragment.chatAdapter() = rv_chat_window.adapter as ChatRecyclerViewAdapter

fun RecyclerView.Adapter<*>.lastItem() = itemCount.minus(1)

fun Fragment.areFieldsValid(viewList: List<TextInputLayout>): Boolean {
    var isValid = true

    viewList.forEach {
        when {
            it.editText?.text.toString().isEmpty() -> {
                isValid = false
                it.apply {
                    isErrorEnabled = true
                    error = getString(R.string.err_empty_field)
                }
            }
            it.editText?.text.toString().trim().length <= 1 -> {
                isValid = false
                it.apply {
                    isErrorEnabled = true
                    error = getString(R.string.err_short_data)
                }
            }
            else -> {
                it.isErrorEnabled = false
            }
        }
    }

    return isValid
}

fun Fragment.isPasswordsEquals(pass: TextInputLayout, confirmPass: TextInputLayout): Boolean {
    return if (pass.editText?.text.toString() != confirmPass.editText?.text.toString()) {
        confirmPass.apply {
            isErrorEnabled = true
            error = getString(R.string.err_pass_not_equals)
        }
        false
    } else true
}