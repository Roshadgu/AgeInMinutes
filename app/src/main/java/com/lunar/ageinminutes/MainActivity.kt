package com.lunar.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity()
{
  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val btnDatePicker = findViewById<Button>(R.id.btnDatePicker)
    btnDatePicker.setOnClickListener{
      view ->
      clickDatePicker(view)
      Toast.makeText(this, "Button works", Toast.LENGTH_LONG).show()}
  }

  fun clickDatePicker(view: View)
  {
    val myCalendar = Calendar.getInstance()
    val year = myCalendar.get(Calendar.YEAR)
    val month = myCalendar.get(Calendar.MONTH)
    val day = myCalendar.get(Calendar.DAY_OF_MONTH)

    DatePickerDialog(this, DatePickerDialog.OnDateSetListener {view, selectedYear, selectedMonth, selectedDayOfMonth ->
      Toast.makeText(this, "The chosen year is $selectedYear, the month is ${selectedMonth + 1} and the day is $selectedDayOfMonth"
              , Toast.LENGTH_LONG).show()

      val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear" //String to hold the date
      val tvSelectedDate = findViewById<TextView>(R.id.tvSelectedDate) //Connecting the XML id to a variable in the code

      tvSelectedDate.setText(selectedDate)

      val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH) //Formats the date string into a readable day/month/year format
      val theDate = sdf.parse(selectedDate)
      val selectedDatInMinutes = theDate.time
    },
            year,
            month,
            day).show()
  }
}