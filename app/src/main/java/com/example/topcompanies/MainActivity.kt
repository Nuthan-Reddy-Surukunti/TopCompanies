package com.example.topcompanies

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ListView
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.content.Context
import android.widget.BaseAdapter
import android.content.Intent

data class CompanyType(val name: String, val imageResId: Int)

class CompanyTypeAdapter(private val context: Context, private val items: List<CompanyType>) : BaseAdapter() {
    override fun getCount(): Int = items.size
    override fun getItem(position: Int): Any = items[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item_company, parent, false)
        val item = items[position]
        val imageView = view.findViewById<ImageView>(R.id.image_company)
        val textView = view.findViewById<TextView>(R.id.text_company_name)
        imageView.setImageResource(item.imageResId)
        textView.text = item.name
        return view
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val companies = listOf(
            CompanyType("Android companies", R.drawable.andriod),
            CompanyType("iOS companies", R.drawable.ios),
            CompanyType("React companies", R.drawable.react),
            CompanyType("Full Stack companies", R.drawable.fullstack)
        )
        val listView = findViewById<ListView>(R.id.list_item)
        listView.adapter = CompanyTypeAdapter(this, companies)
        listView.setOnItemClickListener { _, _, position, _ ->
            val selected = companies[position]
            val intent = Intent(this, CompanyListActivity::class.java)
            intent.putExtra("company_type", selected.name)
            startActivity(intent)
        }
    }
}
