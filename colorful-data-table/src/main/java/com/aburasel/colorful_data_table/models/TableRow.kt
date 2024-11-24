package com.aburasel.colorful_data_table.models

import android.graphics.Color

//
// Created by RASEL on 12-Nov-24.


class TableRow(var values: ArrayList<ColorCell>) {
    class Builder {
        private var values = ArrayList<ColorCell>()

        fun value(value: ColorCell): Builder {
            values.add(value)
            return this
        }

        fun value(
            value: String,
            backgroundColor: Int = Color.TRANSPARENT,
            textColor: Int = Color.BLACK
        ): Builder {
            values.add(ColorCell(value, textColor, backgroundColor))
            return this
        }

        fun value(value: String): Builder {
            values.add(ColorCell(value))
            return this
        }

        fun values(values: ArrayList<ColorCell>): Builder {
            this.values = values
            return this
        }

        fun build(): TableRow {
            return TableRow(this.values)
        }
    }
}
