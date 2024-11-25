package com.aburasel.colorful_data_table

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import com.aburasel.colorful_data_table.adapter.RowItemAdapter
import com.aburasel.colorful_data_table.enums.Direction
import com.aburasel.colorful_data_table.enums.TextGravity
import com.aburasel.colorful_data_table.models.SpannableColorCell
import com.aburasel.colorful_data_table.models.TableHeader
import com.aburasel.colorful_data_table.models.TableRow
import com.aburasel.colorful_data_table.models.TableGroupHeader
import com.aburasel.colorful_data_table.utils.ViewGenerator

//
// Created by RASEL on 12-Nov-24.


class ColorfulDataTable : FrameLayout {
    private var headerTextSize: Float = 0f
    private var rowTextSize: Float = 0f
    private var headerTextColor: Int = 0
    private var headerBackgroundColor: Int = 0
    private var rowTextColor: Int = 0
    private var rowBackgroundColor: Int = 0
    private var typeface: Typeface? = null
    private var headerVerticalPadding: Float = 0f
    private var headerHorizontalPadding: Float = 0f
    private var headerVerticalMargin: Float = 0f
    private var headerHorizontalMargin: Float = 0f
    private var rowVerticalPadding: Float = 0f
    private var rowHorizontalPadding: Float = 0f
    private var rowVerticalMargin: Float = 0f
    private var rowHorizontalMargin: Float = 0f
    private var dividerThickness: Float = 0f
    private var dividerColor: Int = 0
    private var headerGravity: TextGravity = TextGravity.CENTER
    private var rowGravity: TextGravity = TextGravity.CENTER
    private var direction = 0
    private lateinit var header: TableHeader
    private var groupHeader: TableGroupHeader? = null
    private var rows: ArrayList<TableRow> = arrayListOf()
    private var alternatingRowColor: Pair<Pair<Int, Int>, Pair<Int, Int>>? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        fetchAttrs(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        fetchAttrs(context, attrs)
    }

    fun getRowGravity(): TextGravity {
        return rowGravity
    }

    fun setRowGravity(rowGravity: TextGravity) {
        this.rowGravity = rowGravity
    }

    fun getTypeface(): Typeface? {
        return typeface
    }

    fun setTypeface(typeface: Typeface?) {
        this.typeface = typeface
    }

    fun setAlternatingRowColor(
        evenRowBackColor: Int,
        evenRowTextColor: Int,
        oddRowBackColor: Int,
        oddRowTextColor: Int
    ) {
        this.alternatingRowColor =
            Pair(Pair(evenRowBackColor, evenRowTextColor), Pair(oddRowBackColor, oddRowTextColor))
    }

    fun getAlternatingRowColor(): Pair<Pair<Int, Int>, Pair<Int, Int>>? {
        return this.alternatingRowColor
    }


    fun getDirection(): Direction {
        return if (this.direction == LAYOUT_DIRECTION_LTR) Direction.LTR
        else Direction.RTL
    }

    fun setDirection(direction: Direction) {
        when (direction) {
            Direction.LTR -> {
                this.direction = LAYOUT_DIRECTION_LTR
                this.direction = LAYOUT_DIRECTION_RTL
            }

            Direction.RTL -> this.direction =
                LAYOUT_DIRECTION_RTL
        }
    }

    fun getHeader(): TableHeader {
        return header
    }

    fun setHeader(header: TableHeader) {
        this.header = header
    }

    fun getGroupHeader(): TableGroupHeader? {
        return groupHeader
    }

    fun setGroupHeader(header: TableGroupHeader) {
        this.groupHeader = header
    }

    fun getRows(): ArrayList<TableRow> {
        return rows
    }

    fun setRows(rows: ArrayList<TableRow>) {
        this.rows = rows
    }


    fun getHeaderTextSize(): Float {
        return headerTextSize
    }

    fun setHeaderTextSize(headerTextSize: Float) {
        this.headerTextSize = headerTextSize
    }

    fun getRowTextSize(): Float {
        return rowTextSize
    }

    fun setRowTextSize(rowTextSize: Float) {
        this.rowTextSize = rowTextSize
    }

    fun getHeaderTextColor(): Int {
        return headerTextColor
    }

    fun setHeaderTextColor(headerTextColor: Int) {
        this.headerTextColor = headerTextColor
    }

    fun getHeaderBackgroundColor(): Int {
        return headerBackgroundColor
    }

    fun setHeaderBackgroundColor(headerBackgroundColor: Int) {
        this.headerBackgroundColor = headerBackgroundColor
    }

    fun getRowTextColor(): Int {
        return rowTextColor
    }

    fun setRowTextColor(rowTextColor: Int) {
        this.rowTextColor = rowTextColor
    }

    fun getRowBackgroundColor(): Int {
        return rowBackgroundColor
    }

    fun setRowBackgroundColor(rowBackgroundColor: Int) {
        this.rowBackgroundColor = rowBackgroundColor
    }

    fun getHeaderVerticalPadding(): Float {
        return headerVerticalPadding
    }

    fun setHeaderVerticalPadding(headerVerticalPadding: Float) {
        this.headerVerticalPadding = headerVerticalPadding
    }

    fun getHeaderHorizontalPadding(): Float {
        return headerHorizontalPadding
    }

    fun setHeaderHorizontalPadding(headerHorizontalPadding: Float) {
        this.headerHorizontalPadding = headerHorizontalPadding
    }

    fun getHeaderVerticalMargin(): Float {
        return headerVerticalMargin
    }

    fun setHeaderVerticalMargin(headerVerticalMargin: Float) {
        this.headerVerticalMargin = headerVerticalMargin
    }

    fun getHeaderHorizontalMargin(): Float {
        return headerHorizontalMargin
    }

    fun setHeaderHorizontalMargin(headerHorizontalMargin: Float) {
        this.headerHorizontalMargin = headerHorizontalMargin
    }

    fun getRowVerticalPadding(): Float {
        return rowVerticalPadding
    }

    fun setRowVerticalPadding(rowVerticalPadding: Float) {
        this.rowVerticalPadding = rowVerticalPadding
    }

    fun getRowHorizontalPadding(): Float {
        return rowHorizontalPadding
    }

    fun setRowHorizontalPadding(rowHorizontalPadding: Float) {
        this.rowHorizontalPadding = rowHorizontalPadding
    }

    fun getRowVerticalMargin(): Float {
        return rowVerticalMargin
    }

    fun setRowVerticalMargin(rowVerticalMargin: Float) {
        this.rowVerticalMargin = rowVerticalMargin
    }

    fun getRowHorizontalMargin(): Float {
        return rowHorizontalMargin
    }

    fun setRowHorizontalMargin(rowHorizontalMargin: Float) {
        this.rowHorizontalMargin = rowHorizontalMargin
    }

    fun getDividerThickness(): Float {
        return dividerThickness
    }

    fun setDividerThickness(dividerThickness: Float) {
        this.dividerThickness = dividerThickness
    }

    fun getDividerColor(): Int {
        return dividerColor
    }

    fun setDividerColor(dividerColor: Int) {
        this.dividerColor = dividerColor
    }

    fun getHeaderGravity(): TextGravity {
        return headerGravity
    }

    fun setHeaderGravity(headerGravity: TextGravity) {
        this.headerGravity = headerGravity
    }


    private fun fetchAttrs(context: Context, attrs: AttributeSet?) {
        @SuppressLint("CustomViewStyleable") val ta =
            context.obtainStyledAttributes(attrs, R.styleable.ColorfulDataTable, 0, 0)
        try {
            headerTextSize = ta.getDimension(R.styleable.ColorfulDataTable_header_text_size, 16.0f)
            rowTextSize = ta.getDimension(R.styleable.ColorfulDataTable_row_text_size, 16.0f)
            this.headerTextColor =
                ta.getColor(R.styleable.ColorfulDataTable_header_text_color, Color.BLACK)
            this.headerBackgroundColor =
                ta.getColor(
                    R.styleable.ColorfulDataTable_header_background_color,
                    Color.TRANSPARENT
                )
            this.rowTextColor =
                ta.getColor(R.styleable.ColorfulDataTable_row_text_color, Color.BLACK)
            this.rowBackgroundColor =
                ta.getColor(R.styleable.ColorfulDataTable_row_background_color, Color.TRANSPARENT)
            this.headerVerticalPadding =
                ta.getDimension(R.styleable.ColorfulDataTable_header_vertical_padding, 0.0f)
            this.headerHorizontalPadding =
                ta.getDimension(R.styleable.ColorfulDataTable_header_horizontal_padding, 0.0f)
            this.headerVerticalMargin =
                ta.getDimension(R.styleable.ColorfulDataTable_header_vertical_margin, 0.0f)
            this.headerHorizontalMargin =
                ta.getDimension(R.styleable.ColorfulDataTable_header_horizontal_margin, 0.0f)
            this.rowVerticalPadding =
                ta.getDimension(R.styleable.ColorfulDataTable_row_vertical_padding, 0.0f)
            this.rowHorizontalPadding =
                ta.getDimension(R.styleable.ColorfulDataTable_row_horizontal_padding, 0.0f)
            this.rowVerticalMargin =
                ta.getDimension(R.styleable.ColorfulDataTable_row_vertical_margin, 0.0f)
            this.rowHorizontalMargin =
                ta.getDimension(R.styleable.ColorfulDataTable_row_horizontal_margin, 0.0f)
            this.dividerThickness =
                ta.getDimension(R.styleable.ColorfulDataTable_divider_thickness, 1.0f)
            this.dividerColor =
                ta.getColor(
                    R.styleable.ColorfulDataTable_divider_color,
                    Color.parseColor("#e0e2e5")
                )
            val rg = ta.getInt(R.styleable.ColorfulDataTable_row_gravity, 2)
            when (rg) {
                0 -> this.rowGravity = TextGravity.RIGHT
                1 -> this.rowGravity = TextGravity.CENTER
                2 -> this.rowGravity = TextGravity.LEFT
                else -> this.rowGravity = TextGravity.CENTER
            }
            val hg = ta.getInt(R.styleable.ColorfulDataTable_header_gravity, 2)
            when (hg) {
                0 -> this.headerGravity = TextGravity.RIGHT
                1 -> this.headerGravity = TextGravity.CENTER
                2 -> this.headerGravity = TextGravity.LEFT
                else -> this.headerGravity = TextGravity.CENTER
            }
            val di = ta.getInt(R.styleable.ColorfulDataTable_direction, 0)
            this.direction = if ((di == 0)) LAYOUT_DIRECTION_LTR else LAYOUT_DIRECTION_RTL
        } finally {
            ta.recycle()
        }
    }

    fun inflate(context: Context) {
        if ((header.items.isEmpty()) || (header.weights.isEmpty()) || (header.items.size != header.weights.size)) return
        val headerWeightSum = header.weights.sum()
        groupHeader?.let {
            if (groupHeader!!.items.isEmpty()) {
                Log.e(
                    ColorfulDataTable::class.simpleName,
                    "Group header is empty"
                )
            }
            if (groupHeader!!.items.sumOf { it.spanCount } > header.weights.sum()) {
                Log.e(
                    ColorfulDataTable::class.simpleName,
                    "Group header span count sum exceeds total header weights"
                )
                return
            }

            groupHeader!!.items.sortedBy { it.cellStartIndex }.let {
                groupHeader?.items = ArrayList(it ?: emptyList())
            }

            for (i in groupHeader!!.items.indices) {
                val expectedCellStart =
                    groupHeader!!.items[i].cellStartIndex + groupHeader!!.items[i].spanCount
                val item = groupHeader!!.items.getOrNull(i + 1)
                item?.let {
                    if (item.cellStartIndex < expectedCellStart) {
                        Log.e(
                            ColorfulDataTable::class.simpleName,
                            "Group header cell start index overlaps spans"
                        )
                        return
                    }
                    if ((item.cellStartIndex + item.spanCount) > (headerWeightSum+1)) {
                        Log.e(
                            ColorfulDataTable::class.simpleName,
                            "Group header cell goes out of table"
                        )
                        return
                    }
                }
            }

        }

        // table
        val tableLinearLayout: LinearLayout = ViewGenerator.generateVerticalLinearLayout(context)
        tableLinearLayout.layoutDirection = direction

        // table header
        val headerLinearLayout: LinearLayout = ViewGenerator.generateHorizontalLinearLayout(
            context
        )
        // table header
        val spannedHeaderLinearLayout: LinearLayout = ViewGenerator.generateHorizontalLinearLayout(
            context
        )

        if (groupHeader != null) {
            //create empty cell as much as of header weight count
            val spannedCells = arrayListOf<SpannableColorCell>()
            for (i in 0..<headerWeightSum) {
                spannedCells.add(
                    SpannableColorCell(
                        "",
                        1,
                        i,
                        headerTextColor,
                        headerBackgroundColor
                    )
                )
            }
            for (spanItem in groupHeader!!.items) {
                spannedCells[spanItem.cellStartIndex].spanCount = spanItem.spanCount
                spannedCells[spanItem.cellStartIndex].text = spanItem.text
                spannedCells[spanItem.cellStartIndex].cellTextColor = spanItem.cellTextColor
                spannedCells[spanItem.cellStartIndex].cellBackgroundColor =
                    spanItem.cellBackgroundColor
                if (spanItem.spanCount > 1) {
                    val indexOfItemToRemove = spanItem.cellStartIndex + spanItem.spanCount
                    for (i in (spanItem.cellStartIndex + 1)..<indexOfItemToRemove) {
                        spannedCells[i].markedAsRemove = true
                    }
                }
            }

            spannedCells.removeIf { it.markedAsRemove }
            for (item in spannedCells) {
                val textView: TextView = ViewGenerator.generateTextView(
                    context,
                    item.printable(),
                    item.spanCount,
                    item.cellBackgroundColor,
                    item.cellTextColor,
                    headerBackgroundColor,
                    headerTextColor,
                    headerHorizontalPadding,
                    headerVerticalPadding,
                    headerHorizontalPadding,
                    headerVerticalPadding,
                    headerHorizontalMargin,
                    headerVerticalMargin,
                    headerHorizontalMargin,
                    headerVerticalMargin,
                    headerTextSize,
                    headerGravity,
                    typeface,
                    Typeface.BOLD
                )
                spannedHeaderLinearLayout.addView(textView)
            }
            tableLinearLayout.addView(spannedHeaderLinearLayout)
        }

        for (i in header.items.indices) {
            val textView: TextView = ViewGenerator.generateTextView(
                context,
                header.items[i].printable(),
                header.weights[i],
                header.items[i].cellBackgroundColor,
                header.items[i].cellTextColor,
                headerBackgroundColor,
                headerTextColor,
                headerHorizontalPadding,
                headerVerticalPadding,
                headerHorizontalPadding,
                headerVerticalPadding,
                headerHorizontalMargin,
                headerVerticalMargin,
                headerHorizontalMargin,
                headerVerticalMargin,
                headerTextSize,
                headerGravity,
                typeface,
                Typeface.BOLD
            )
            headerLinearLayout.addView(textView)
        }

        //divider
        val divider: View = ViewGenerator.generateDivider(
            context,
            dividerThickness.toInt(), this.dividerColor
        )


        // add views
        tableLinearLayout.addView(headerLinearLayout)
        tableLinearLayout.addView(divider)

        // recycler view
        val adapter = RowItemAdapter(
            context,
            this.rows,
            header.weights,
            dividerThickness.toInt(),
            this.dividerColor,
            this.rowTextColor,
            this.rowBackgroundColor,
            this.rowVerticalPadding,
            this.rowHorizontalPadding,
            this.rowVerticalMargin,
            this.rowHorizontalMargin,
            this.rowTextSize,
            this.rowGravity,
            typeface,
            this.alternatingRowColor
        )
        tableLinearLayout.addView(
            ViewGenerator.generateRecyclerView(
                context,
                adapter
            )
        )


        //card view
        this.removeAllViews()
        this.addView(tableLinearLayout)
//        this.radius = this.cornerRadius
//        this.cardElevation = this.shadow
    }
}
