package com.example.butterknife.library

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife

class SimpleAdapter(context: Context) : BaseAdapter() {
    private companion object {
        private val CONTENTS = "The quick brown fox jumps over the lazy dog"
                .split(" ".toRegex())
                .dropLastWhile { it.isEmpty() }
                .toTypedArray()
    }

    private val inflater = LayoutInflater.from(context)

    override fun getCount() = CONTENTS.size
    override fun getItem(position: Int) = CONTENTS[position]
    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, savedView: View?, parent: ViewGroup): View {
        var view = savedView

        val holder: ViewHolder
        if (view != null) {
            holder = view.tag as ViewHolder
        } else {
            view = inflater.inflate(R.layout.simple_list_item, parent, false)
            holder = ViewHolder(view)
            view!!.tag = holder
        }

        val word = getItem(position)

        // Note: don't actually do string concatenation like this in an adapter's getView.
        holder.word.text = "Word: " + word
        holder.length.text = "Length: " + word.length
        holder.position.text = "Position: " + position

        return view
    }

    internal class ViewHolder(view: View) {
        @BindView(R2.id.word)
        lateinit var word: TextView

        @BindView(R2.id.length)
        lateinit var length: TextView

        @BindView(R2.id.position)
        lateinit var position: TextView

        init {
            ButterKnife.bind(this, view)
        }
    }
}
