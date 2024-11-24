# Colorful-Data-Table
A library for creating android table. It has feature of creating colorful table cell, table group header, normal header. Easily customizeable datatable library

![WhatsApp Image 2024-11-24 at 17 58 17_7719b623](https://github.com/user-attachments/assets/599f7700-b77f-480d-bdc8-97ec01a599d4)

##  Installation

Add it in your root build.gradle at the end of repositories:
>
    dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}
>
    dependencies {
	        implementation 'com.github.aburasel:Colorful-Data-Table:1.0.0'
	}

##  Usages:

### Create layout for table in xml as like-
>
    <com.aburasel.colorful_data_table.ColorfulDataTable
        android:id="@+id/table"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="8dp"
        android:padding="8dp"
        app:direction="ltr"
        app:header_background_color="#fff"
        app:header_gravity="center"
        app:header_horizontal_padding="0dp"
        app:header_text_color="#000"
        app:header_text_size="12sp"
        app:header_vertical_padding="4dp"
        app:row_gravity="center"
        app:row_text_size="12sp"
        app:row_vertical_padding="16dp" />

### Create table header
>
    val header = TableHeader.Builder()
        .item("Period", 1)
        .item("Due", 1)
        .item("Overdue", 1)
        .item("120+Due", 1)
        .item("180+Due", 1)
        .build()
### Create table rows-
>   
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
Make sure that header column count matches with rows column count.

### To create Group Header do this-
>   
    val myGroupHeader = TableGroupHeader.Builder()
        .item("UOM-CM-Group", 2, 2, Color.parseColor("#92278F"), Color.WHITE)
        .item("SPLYGR", 2, 5, Color.parseColor("#92278F"), Color.WHITE)
        .build()
`param 2` is spanCount for Group header cell, `param 3` is start index of this cell, next params for background and foreground color respectively. Make sure that cell start index and spans do not overlaps for multiple group cell and also do not exceed the total column count.
### Set headers and rows before inflate.
>   
    binding.content.table.setHeader(header)
    binding.content.table.setGroupHeader(mySpannedHeader)
    binding.content.table.setRows(rows)
    binding.content.table.inflate(this)
###  If you want to add alternating row color then-
>
    binding.content.table.setAlternatingRowColor(
            Color.parseColor("#DCCDDB"),
            Color.BLACK,
            Color.parseColor("#EEE8EE"),
            Color.BLACK
        )
##  Available methods-
>
    binding.content.table.setHeaderTextSize(10f)
    binding.content.table.setRowTextSize(10f)
    binding.content.table.setRowVerticalPadding(8f)
    binding.content.table.setTypeface(yourTypeface)
    binding.content.table.setDirection(direction: Direction)
    binding.content.table.setRowTextColor(Color.BLACK)
    binding.content.table.setRowBackgroundColor
    binding.content.table.setHeaderTextSize(12f)
    binding.content.table.setHeaderTextColor(Color.BLACK)
    binding.content.table.setHeaderVerticalPadding(4f)
    binding.content.table.setHeaderHorizontalPadding(4f)
    binding.content.table.setHeaderVerticalMargin(4f)
    binding.content.table.setHeaderHorizontalMargin(4f)
    binding.content.table.setRowHorizontalPadding(4f)
    binding.content.table.setRowVerticalMargin(4f)
    binding.content.table.setRowHorizontalMargin(4f)
    binding.content.table.setDividerThickness(1f)
    binding.content.table.setDividerColor(Color.GREY)
    binding.content.table.setHeaderGravity(TextGravity.CENTER)
      

