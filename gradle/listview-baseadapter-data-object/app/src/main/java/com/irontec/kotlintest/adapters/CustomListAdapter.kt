package com.irontec.kotlintest.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.irontec.kotlintest.R
import com.irontec.kotlintest.models.CustomPojo

/**
 * Created by axier on 22/4/15.
 */
open class CustomListAdapter(data: Array<CustomPojo>, context: Context) : BaseAdapter()  {

    var localData = data;

    override fun getCount(): Int {
        return localData.size()
    }

    override fun getItem(position: Int): Any {
        return localData.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    private val mInflater: LayoutInflater?
    {
        mInflater = LayoutInflater.from(context)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {

        val view: View?
        val vh: ListRowHolder
        if (convertView == null) {
            view = mInflater?.inflate(R.layout.row_item, parent, false)
            vh = ListRowHolder(view)
            view?.setTag(vh)
        } else {
            view = convertView
            vh = view.getTag() as ListRowHolder
        }
        vh.label.setText(localData.get(index = position).toString())
        return view;
    }

    private class ListRowHolder(row: View?) {
        public val label: TextView
        {
            this.label = row?.findViewById(R.id.label) as TextView
        }
    }

}