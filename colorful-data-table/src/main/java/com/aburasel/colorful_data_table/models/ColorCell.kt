package com.aburasel.colorful_data_table.models

//
// Created by RASEL on 13-Nov-24.
/*

data class ColorCell (
    val text: String,
    var cellTextColor: Int = -2,
    var cellBackgroundColor: Int = -2
) {
    fun printable(): String {
        return text
    }
}*/
data class ColorCell(
    override val text: String,
    override var cellTextColor: Int = -2,
    override var cellBackgroundColor: Int = -2,
) : Colorable {
    override fun printable(): String {
        return text
    }
}