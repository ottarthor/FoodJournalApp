package com.example.foodjournalapplication

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodjournalapplication.CalendarUtils.daysInMonthArray
import com.example.foodjournalapplication.CalendarUtils.monthYearFromDate
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainCalendarActivity : AppCompatActivity(), CalendarAdapter.OnItemListener {
    private lateinit var monthYearText: TextView
    private lateinit var calendarRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar_main)
        initWidgets()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CalendarUtils.selectedDate = LocalDate.now()
        }
        setMonthView()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomnav);
        bottomNavigationView.selectedItemId = R.id.navigation_calendar
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    startActivity(Intent(applicationContext, HomeActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.navigation_search -> {
                    startActivity(Intent(applicationContext, SearchRecipeActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.navigation_recipes -> {
                    startActivity(Intent(applicationContext, MyRecipesActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.navigation_calendar -> true
                R.id.navigation_grocerylist -> {
                    startActivity(Intent(applicationContext, GroceryListActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }

                else -> false
            }
        }
    }

    private fun initWidgets() {
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView)
        monthYearText = findViewById(R.id.monthYearTV)
    }

    private fun setMonthView() {
        monthYearText.text = monthYearFromDate(CalendarUtils.selectedDate)
        val daysInMonth = daysInMonthArray(CalendarUtils.selectedDate)

        val calendarAdapter = CalendarAdapter(daysInMonth, this)
        val layoutManager = GridLayoutManager(applicationContext, 7)
        calendarRecyclerView.layoutManager = layoutManager
        calendarRecyclerView.adapter = calendarAdapter
    }

    fun previousMonthAction(view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CalendarUtils.selectedDate = CalendarUtils.selectedDate.minusMonths(1)
        }
        setMonthView()
    }

    fun nextMonthAction(view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CalendarUtils.selectedDate = CalendarUtils.selectedDate.plusMonths(1)
        }
        setMonthView()
    }

    override fun onItemClick(position: Int, date: LocalDate?) {
        if (date != null) {
            CalendarUtils.selectedDate = date
            setMonthView()
        }
    }

    fun weeklyAction(view: View) {
        startActivity(Intent(this, WeekViewActivity::class.java))
    }
}
