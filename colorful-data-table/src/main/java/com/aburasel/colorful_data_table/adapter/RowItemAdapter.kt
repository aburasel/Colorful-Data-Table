package com.aburasel.colorful_data_table.adapter

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aburasel.colorful_data_table.R
import com.aburasel.colorful_data_table.enums.TextGravity
import com.aburasel.colorful_data_table.models.ColorCell
import com.aburasel.colorful_data_table.models.TableRow
import com.aburasel.colorful_data_table.utils.ViewGenerator

//
// Created by RASEL on 12-Nov-24.


class RowItemAdapter(
    private val context: Context,
    values: ArrayList<TableRow>,
    weights: ArrayList<Int>?,
    dividerThickness: Int,
    dividerColor: Int,
    rowTextColor: Int,
    rowBackgroundColor: Int,
    verticalPadding: Float,
    horizontalPadding: Float,
    verticalMargin: Float,
    horizontalMargin: Float,
    rowTextSize: Float,
    rowGravity: TextGravity,
    leftAlignedColumns: ArrayList<Int>,
    rightAlignedColumns: ArrayList<Int>,
    typeface: Typeface? = null,
    rowAlternatingBackgroundTextColor: Pair<Pair<Int, Int>, Pair<Int, Int>>? = null,
    val onClickCell: (value: ColorCell, rowPosition: Int, celPosition: Int) -> Unit = { _, _, _ -> }
) :
    RecyclerView.Adapter<RowItemAdapter.RowItemViewHolder>() {
    private var values: ArrayList<TableRow>? = null
    private var weights: ArrayList<Int>? = null
    private val dividerThickness: Int
    private val dividerColor: Int
    private val rowTextColor: Int
    private val rowBackgroundColor: Int
    private var rowAlternatingBackgroundTextColor: Pair<Pair<Int, Int>, Pair<Int, Int>>? = null
    private val verticalPadding: Float
    private val horizontalPadding: Float
    private val verticalMargin: Float
    private val horizontalMargin: Float
    private val rowTextSize: Float
    private val rowGravity: TextGravity
    private var typeface: Typeface? = null
    private var leftAlignedColumns = arrayListOf<Int>()
    private var rightAlignedColumns = arrayListOf<Int>()

    init {
        this.values = values
        if (weights != null) this.weights = weights
        else this.weights = ArrayList()

        this.dividerThickness = dividerThickness
        this.dividerColor = dividerColor
        this.rowTextColor = rowTextColor
        this.rowBackgroundColor = rowBackgroundColor
        this.verticalPadding = verticalPadding
        this.horizontalPadding = horizontalPadding
        this.verticalMargin = verticalMargin
        this.horizontalMargin = horizontalMargin
        this.rowTextSize = rowTextSize
        this.rowGravity = rowGravity
        this.leftAlignedColumns = leftAlignedColumns
        this.rightAlignedColumns = rightAlignedColumns
        this.typeface = typeface
        this.rowAlternatingBackgroundTextColor = rowAlternatingBackgroundTextColor
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowItemViewHolder {
        return RowItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RowItemViewHolder, position: Int) {
        holder.removeAllViews()
        val itemLinearLayout: LinearLayout = ViewGenerator.generateHorizontalLinearLayout(
            context
        )
        val valueLinearLayout: LinearLayout = ViewGenerator.generateHorizontalLinearLayout(
            context
        )
        if (values!![position].values.size != weights!!.size) return
        for (j in values!![position].values.indices) {
            var textGravity = rowGravity //defaultGravity
            if (leftAlignedColumns.contains(j)) {
                textGravity = TextGravity.LEFT
            }
            if (rightAlignedColumns.contains(j)) {
                textGravity = TextGravity.RIGHT
            }
            val textView: TextView = ViewGenerator.generateTextView(
                context,
                values!![position].values[j].printable(),
                weights!![j],
                values!![position].values[j].cellBackgroundColor,
                values!![position].values[j].cellTextColor,
                rowBackgroundColor,
                rowTextColor,
                horizontalPadding,
                verticalPadding,
                horizontalPadding,
                verticalPadding,
                horizontalMargin,
                verticalMargin,
                horizontalMargin,
                verticalMargin,
                rowTextSize,
                textGravity,
                typeface,
                Typeface.NORMAL,
                rowAlternatingBackgroundTextColor,
                position % 2 == 0
            )
            textView.setOnClickListener {
                onClickCell(values!![position].values[j], position, j)
            }
            valueLinearLayout.addView(textView)
        }
        itemLinearLayout.addView(valueLinearLayout)

        val divider: View = ViewGenerator.generateDivider(
            context, dividerThickness, dividerColor
        )

        holder.addView(itemLinearLayout)
        holder.addView(divider)
    }

    override fun getItemCount(): Int {
        return values!!.size
    }

    inner class RowItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val rootItem: LinearLayout = itemView.findViewById<LinearLayout>(R.id.row_item_root)

        internal fun removeAllViews() {
            rootItem.removeAllViews()
        }

        fun addView(child: View) {
            rootItem.addView(child)
        }
    }
}
