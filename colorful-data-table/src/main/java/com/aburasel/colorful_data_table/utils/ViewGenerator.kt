package com.aburasel.colorful_data_table.utils

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aburasel.colorful_data_table.adapter.RowItemAdapter
import com.aburasel.colorful_data_table.enums.TextGravity

//
// Created by RASEL on 12-Nov-24.


object ViewGenerator {
    fun generateTextView(
        context: Context,
        text: String,
        weight: Int,
        cellBackgroundColor: Int,
        cellTextColor: Int,
        rowBackgroundColor: Int,
        rowTextColor: Int,
        leftPadding: Float,
        topPadding: Float,
        rightPadding: Float,
        bottomPadding: Float,
        leftMargin: Float,
        topMargin: Float,
        rightMargin: Float,
        bottomMargin: Float,
        textSize: Float,
        gravity: TextGravity,
        typeface: Typeface? = null,
        style: Int? = null,
        alternatingRowColor: Pair<Pair<Int, Int>, Pair<Int, Int>>? = null,
        isEvenRow: Boolean = true,
    ): TextView {
        val tv = TextView(context)
        tv.text = text
        tv.id = View.generateViewId()
        val layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT)
        layoutParams.weight = weight.toFloat()
        layoutParams.leftMargin = leftMargin.toInt()
        layoutParams.topMargin = topMargin.toInt()
        layoutParams.rightMargin = rightMargin.toInt()
        layoutParams.bottomMargin = bottomMargin.toInt()
        tv.layoutParams = layoutParams

        if (alternatingRowColor != null) {
            if (isEvenRow) {
                tv.setBackgroundColor(alternatingRowColor.first.first)
                tv.setTextColor(alternatingRowColor.first.second)
            } else {
                tv.setBackgroundColor(alternatingRowColor.second.first)
                tv.setTextColor(alternatingRowColor.second.second)
            }

            if (cellBackgroundColor != -2) {
                tv.setBackgroundColor(cellBackgroundColor)
            }
            if (cellTextColor != -2) {
                tv.setTextColor(cellTextColor)
            }

        } else {
            if (cellBackgroundColor == -2) {
                tv.setBackgroundColor(rowBackgroundColor)
            } else {
                tv.setBackgroundColor(cellBackgroundColor)
            }
            if (cellTextColor == -2) {
                tv.setTextColor(rowTextColor)
            } else {
                tv.setTextColor(cellTextColor)
            }
        }

        tv.gravity = when (gravity) {
            TextGravity.RIGHT -> Gravity.END
            TextGravity.CENTER -> Gravity.CENTER
            TextGravity.LEFT -> Gravity.START
        }
        tv.setPadding(
            leftPadding.toInt(),
            topPadding.toInt(),
            rightPadding.toInt(),
            bottomPadding.toInt()
        )
        tv.textSize = textSize
        if (typeface != null) tv.setTypeface(typeface, style ?: Typeface.NORMAL)
        else tv.setTypeface(null, style ?: Typeface.NORMAL)
        return tv
    }

    fun generateRecyclerView(context: Context, rowItemAdapter: RowItemAdapter): RecyclerView {
        val recyclerView = RecyclerView(
            context
        )
        val layoutParams = RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        recyclerView.layoutParams = layoutParams
        recyclerView.id = View.generateViewId()
        recyclerView.adapter = rowItemAdapter
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        return recyclerView
    }

    fun generateVerticalLinearLayout(context: Context?): LinearLayout {
        val verticalLinearLayout = LinearLayout(context)
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        verticalLinearLayout.orientation = LinearLayout.VERTICAL
        verticalLinearLayout.id = View.generateViewId()
        verticalLinearLayout.layoutParams = layoutParams
        return verticalLinearLayout
    }

    fun generateHorizontalLinearLayout(context: Context?): LinearLayout {
        val horizontalLinearLayout = LinearLayout(context)
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        horizontalLinearLayout.orientation = LinearLayout.HORIZONTAL
        horizontalLinearLayout.id = View.generateViewId()
        horizontalLinearLayout.layoutParams = layoutParams
        horizontalLinearLayout.gravity = Gravity.CENTER_VERTICAL
        return horizontalLinearLayout
    }

    fun generateDivider(context: Context?, height: Int?, @ColorInt color: Int?): View {
        val view = View(context)
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            height ?: 1
        )
        view.layoutParams = layoutParams
        view.setBackgroundColor(color ?: Color.parseColor("#e0e2e5"))
        view.id = View.generateViewId()
        return view
    }
}
