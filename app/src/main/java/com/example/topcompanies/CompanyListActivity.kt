package com.example.topcompanies

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Data class for top company
 data class TopCompany(val name: String, val description: String, val imageResId: Int)

// Adapter for top companies
class TopCompanyAdapter(private val context: Context, private val items: List<TopCompany>) : BaseAdapter() {
    override fun getCount(): Int = items.size
    override fun getItem(position: Int): Any = items[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item_top_company, parent, false)
        val item = items[position]
        val imageView = view.findViewById<ImageView>(R.id.image_top_company)
        val nameView = view.findViewById<TextView>(R.id.text_top_company_name)
        val descView = view.findViewById<TextView>(R.id.text_top_company_desc)
        imageView.setImageResource(item.imageResId)
        nameView.text = item.name
        descView.text = item.description
        return view
    }
}

class CompanyListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_list)

        // For now, just set up the adapter with demo data
        val companies = List(10) { i ->
            TopCompany(
                name = "Demo Company ${i+1}",
                description = "This is a description for Demo Company ${i+1}.",
                imageResId = R.drawable.ic_launcher_foreground
            )
        }
        val listView = findViewById<ListView>(R.id.list_top_companies)
        listView.adapter = TopCompanyAdapter(this, companies)
    }
}
