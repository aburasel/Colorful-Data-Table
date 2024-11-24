package com.aburasel.colorful_data_table.models

import android.graphics.Color

//
// Created by RASEL on 12-Nov-24.


class TableHeader(var items: ArrayList<ColorCell>, var weights: ArrayList<Int>) {
    class Builder {
        private val items: ArrayList<ColorCell> = arrayListOf()
        private val weights = ArrayList<Int>()

        fun item(name: ColorCell, weight: Int): Builder {
            items.add(name)
            weights.add(weight)
            return this
        }

        fun item(name: String, weight: Int): Builder {
            items.add(ColorCell(name))
            weights.add(weight)
            return this
        }

        fun item(
            name: String,
            weight: Int,
            cellBackgroundColor: Int = Color.TRANSPARENT,
            cellTextColor: Int = Color.BLACK
        ): Builder {
            items.add(ColorCell(name, cellTextColor, cellBackgroundColor))
            weights.add(weight)
            return this
        }

        fun build(): TableHeader {
            return TableHeader(this.items, this.weights)
        }
    }

}
