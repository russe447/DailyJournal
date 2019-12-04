package com.example.dailyjournal
import java.util.ArrayList
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class EventAdapter(private val mContext: Context) : BaseAdapter() {
    private var inflater : LayoutInflater = LayoutInflater.from(mContext)
    private val events = ArrayList<Event>()

   fun addEvent(newEvent: Event) {

        events.add(newEvent)

    }

    override fun getCount(): Int {

        return events.size

    }


    override fun getItem(pos: Int): Any {

        return events[pos]

    }

    // Get the ID for the ToDoItem
    // In this case it's just the position

    override fun getItemId(pos: Int): Long {

        return pos.toLong()

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val newView: View

        val event = events[position]
        val viewHolder: ViewHolder

        if (null == convertView) {
            newView = inflater.inflate(R.layout.event_list, parent, false)

            viewHolder = ViewHolder()
            newView.tag = viewHolder

            viewHolder.eventLayout = newView.findViewById(R.id.relLayout)
            //viewHolder.name = newView.findViewById<TextView>(R.id.eventTitle)
        } else {
            newView = convertView
            viewHolder = convertView.tag as ViewHolder
        }

        val stored = newView.tag as ViewHolder
        stored.name?.text = event.title
        return viewHolder.eventLayout
    }

    internal class ViewHolder {
        var name: TextView? = null
        var eventLayout: RelativeLayout? = null
    }
}
