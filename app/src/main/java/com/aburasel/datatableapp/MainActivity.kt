package com.aburasel.datatableapp

import android.graphics.Color
import android.icu.util.Calendar
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aburasel.colorful_data_table.models.TableGroupHeader
import com.aburasel.colorful_data_table.models.TableHeader
import com.aburasel.colorful_data_table.models.TableRow
import com.aburasel.datatableapp.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Locale
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        createGroupHeaderTable()
        createNormalHeaderTable()
    }

    private fun createGroupHeaderTable() {
        binding.content.spannedTable.setHeaderTextSize(10f)
        binding.content.spannedTable.setHeaderHorizontalMargin(1f)
        binding.content.spannedTable.setRowTextSize(10f)
        binding.content.spannedTable.setRowVerticalPadding(16f)
        binding.content.spannedTable.setAlternatingRowColor(
            Color.parseColor("#DCCDDB"),
            Color.BLACK,
            Color.parseColor("#EEE8EE"),
            Color.BLACK
        )
        val myHeader = TableHeader.Builder()
            .item("", 2, Color.parseColor("#92278F"), Color.WHITE)
            .item("UOM", 1, Color.parseColor("#92278F"), Color.WHITE)
            .item("CM", 1, Color.parseColor("#92278F"), Color.WHITE)
            .item("LM", 1, Color.parseColor("#92278F"), Color.WHITE)
            .item("SPLY", 1, Color.parseColor("#92278F"), Color.WHITE)
            .item("LMGR", 1, Color.parseColor("#92278F"), Color.WHITE)
            .item("SPLYGR", 1, Color.parseColor("#92278F"), Color.WHITE)
            .build()

        val mySpannedHeader = TableGroupHeader.Builder()
            .item("UOM-CM-Group", 2, 2, Color.parseColor("#92278F"), Color.WHITE)
            .item("SPLYGR", 2, 5, Color.parseColor("#92278F"), Color.WHITE)
            .build()

        val tableRows = arrayListOf<TableRow>()
        val green = Color.parseColor("#00B050")
        for (i in 0..10) {
            val row = TableRow.Builder()
                .value("Particulars-$i")
                .value("${Random.nextInt(100)}")
                .value("${Random.nextInt(100)}")
                .value("${Random.nextInt(100)}")
                .value("${Random.nextInt(100)}")
                .value(
                    "${Random.nextInt(50)}%",
                    if (Random.nextInt(100) > 80) green else Color.RED,
                    Color.WHITE
                )
                .value(
                    "${Random.nextInt(50)}%",
                    if (Random.nextInt(100) > 80) green else Color.RED,
                    Color.WHITE
                )
                .build()
            tableRows.add(row)
        }

        binding.content.spannedTable.setHeader(myHeader)
        binding.content.spannedTable.setGroupHeader(mySpannedHeader)
        binding.content.spannedTable.setRows(tableRows)
        binding.content.spannedTable.inflate(this)
    }

    private fun createNormalHeaderTable() {
        binding.content.table.setHeaderTextSize(10f)
        binding.content.table.setRowTextSize(10f)
        binding.content.table.setRowVerticalPadding(8f)
        binding.content.table.setAlternatingRowColor(
            Color.parseColor("#F3F3F3"),
            Color.BLACK,
            Color.WHITE,
            Color.BLACK
        )
        val header = TableHeader.Builder()
            .item("Period", 1)
            .item("Due", 1)
            .item("Overdue", 1)
            .item("120+Due", 1)
            .item("180+Due", 1)
            .build()

        val rows = arrayListOf<TableRow>()
        for (item in 0..10) {
            val row = TableRow.Builder()
                .value(getMonthName(Random.nextInt(12)))
                .value("${Random.nextInt(5000)}")
                .value("${Random.nextInt(5000)}")
                .value("${Random.nextInt(5000)}")
                .value("${Random.nextInt(5000)}")
                .build()
            rows.add(row)
        }

        binding.content.table.setHeader(header)
        binding.content.table.setRows(rows)
        binding.content.table.inflate(this)

    }

    private fun getMonthName(monthNumber: Int): String {
        val calendar = Calendar.getInstance()
        calendar[Calendar.MONTH] = monthNumber - 1 // Set the month (0-based)
        val monthFormat = SimpleDateFormat("MMMM", Locale.getDefault()) // Full month name
        return monthFormat.format(calendar.time)
    }
}