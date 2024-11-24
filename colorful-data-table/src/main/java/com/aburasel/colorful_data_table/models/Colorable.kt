package com.aburasel.colorful_data_table.models

//
// Created by RASEL on 19-Nov-24.

interface Colorable{
    val text: String
    var cellTextColor: Int
    var cellBackgroundColor: Int
    fun printable(): String
}