package com.example.trynewthingsinandroid.utils

import timber.log.Timber

fun log(tag: String, message: String) {
    Timber.d("_logs -> $tag : $message")
}