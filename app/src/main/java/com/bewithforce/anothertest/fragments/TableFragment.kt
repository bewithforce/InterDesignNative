package com.bewithforce.anothertest.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bewithforce.anothertest.R
import com.bewithforce.anothertest.model.Data
import kotlinx.android.synthetic.main.fragment_table.*


class TableFragment : Fragment() {

   /* override fun onStart() {
        super.onStart()
        val tableLayout = this.table_layout
        val data = (arguments?.get("data") as Data).data

        for (list in data!!){
            val tableRow = TableRow(this.context)
            for(word in list){
                val labelText = TextView(this.context)
                labelText.text = word
                labelText.setPadding(5, 5, 5, 5)
                tableRow.addView(labelText) // add the column to the table row here
            }
            tableLayout.addView(tableRow)
        }
    }*/

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val data = (arguments?.get("data") as Data).data

        for (list in data!!){
            val tableRow = TableRow(this.context)
            for(word in list){
                val labelText = TextView(this.context)
                labelText.text = word
                labelText.setPadding(5, 5, 5, 5)
                tableRow.addView(labelText) // add the column to the table row here
            }
            this.table_layout?.addView(tableRow)
            //Log.e("asdasdadsa", container.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        return inflater.inflate(R.layout.fragment_table, container, false)
    }

}