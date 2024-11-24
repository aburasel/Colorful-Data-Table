package com.aburasel.colorful_data_table.models

//
// Created by RASEL on 19-Nov-24.

data class SpannableColorCell(
    override var text: String,
    var spanCount: Int,
    var cellStartIndex: Int,
    override var cellTextColor: Int,
    override var cellBackgroundColor: Int,
) : Colorable {
    var markedAsRemove = false
    override fun printable(): String {
        return text
    }

    override fun toString(): String {
        return "$spanCount-$markedAsRemove"
    }
}