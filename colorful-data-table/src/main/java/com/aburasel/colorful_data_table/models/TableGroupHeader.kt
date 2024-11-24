package com.aburasel.colorful_data_table.models

import android.graphics.Color

//
// Created by RASEL on 12-Nov-24.


class TableGroupHeader(var items: ArrayList<SpannableColorCell>) {
    class Builder {
        private val items: ArrayList<SpannableColorCell> = arrayListOf()

        fun item(name: SpannableColorCell): Builder {
            items.add(name)
            return this
        }

        fun item(name: String, spanCount: Int, cellStartIndex: Int): Builder {
            items.add(SpannableColorCell(name, spanCount, cellStartIndex, Color.BLACK, Color.TRANSPARENT))
            return this
        }

        fun item(
            name: String,
            spanCount: Int,
            cellStartIndex: Int,
            cellBackgroundColor: Int,
            cellTextColor: Int
        ): Builder {
            items.add(
                SpannableColorCell(
                    name,
                    spanCount,
                    cellStartIndex,
                    cellTextColor,
                    cellBackgroundColor
                ).apply {
                    this.cellBackgroundColor = cellBackgroundColor
                    this.cellTextColor = cellTextColor
                })
            return this
        }

        fun build(): TableGroupHeader {
            return TableGroupHeader(this.items)
        }
    }

}
