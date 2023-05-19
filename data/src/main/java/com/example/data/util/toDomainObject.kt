package com.example.data.util

import com.google.gson.Gson

fun<T> Any.toDomainobject(clazz: Class<T>) : T {

    val gson = Gson()
    val jsonString = gson.toJson(this)
    val type = gson.fromJson(jsonString,clazz)

    return type



}