package com.blavas.journeytestapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.blavas.journeytestapp.R
import com.blavas.journeytestapp.models.TrendData
import kotlin.collections.ArrayList

class TrendAdapter : RecyclerView.Adapter<TrendAdapter.RecyclerViewHolder>, Filterable {

    var courseDataArrayList: ArrayList<TrendData>? = ArrayList()
    var photosListFiltered: ArrayList<TrendData> = ArrayList()
    private var mcontext: Context? = null

    companion object{
        lateinit var clickListeners: ClickListener
    }

    fun updateList(recyclerDataArrayList: ArrayList<TrendData>?){
        courseDataArrayList = recyclerDataArrayList
        notifyDataSetChanged()
    }

    constructor(recyclerDataArrayList: ArrayList<TrendData>?, mcontext: Context?){
        courseDataArrayList = recyclerDataArrayList
        this.mcontext = mcontext
        this.courseDataArrayList = ArrayList<TrendData>()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        // Inflate Layout
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.trend_item_row, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        // Set the data to textview and imageview.
        val recyclerData: TrendData = courseDataArrayList!![position]
        holder.title.setText(recyclerData.title)
        holder.body_description.setText(recyclerData.body)
        holder.mainCard.setOnClickListener(View.OnClickListener {
            clickListeners.onItemClick(position, it);
        })

    }

    fun addData(list: List<TrendData>) {
        courseDataArrayList = list as ArrayList<TrendData>
        photosListFiltered = courseDataArrayList as ArrayList<TrendData>
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        // this method returns the size of recyclerview
        return courseDataArrayList!!.size
    }

    // View Holder Class to handle Recycler View.
    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener,
        View.OnLongClickListener {
        val title: TextView
        val body_description: TextView
        val mainCard: CardView

        init {
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
            title = itemView.findViewById(R.id.title)
            body_description = itemView.findViewById(R.id.body_description)
            mainCard = itemView.findViewById(R.id.mainCard)
        }
        override fun onClick(v: View) {
            clickListeners.onItemClick(getAdapterPosition(), v);
        }

        override fun onLongClick(v: View): Boolean {
            return false
        }

    }


    interface ClickListener {
        fun onItemClick(position: Int, v: View?)
        fun onItemLongClick(position: Int, v: View?)
    }

    fun setCartItemClickListener(clickListener: ClickListener) {
        clickListeners = clickListener
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charString = constraint?.toString() ?: ""
                if (charString.isEmpty()) photosListFiltered = courseDataArrayList!! else {
                    val filteredList = ArrayList<TrendData>()
                    courseDataArrayList?.filter {
                        (it.id?.contains(constraint!!))!! or
                                (it.title!!.contains(constraint!!))

                    }
                        ?.forEach { filteredList.add(it) }
                    photosListFiltered = filteredList

                }
                return FilterResults().apply { values = photosListFiltered }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {

                photosListFiltered = if (results?.values == null)
                    ArrayList()
                else
                    results.values as ArrayList<TrendData>
                notifyDataSetChanged()
            }
        }
    }

}
