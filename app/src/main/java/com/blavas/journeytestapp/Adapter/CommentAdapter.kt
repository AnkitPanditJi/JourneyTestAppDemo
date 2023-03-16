package com.blavas.journeytestapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.blavas.journeytestapp.R
import com.blavas.journeytestapp.models.CommentDataItems

class CommentAdapter : RecyclerView.Adapter<CommentAdapter.RecyclerViewHolder>{

    var courseDataArrayList: ArrayList<CommentDataItems>? = null
    var coursesListFiltered: ArrayList<CommentDataItems>? = null
    private var mcontext: Context? = null

    companion object{
        lateinit var clickListeners: ClickListener
    }

    fun updateList(recyclerDataArrayList: ArrayList<CommentDataItems>?){
        courseDataArrayList = recyclerDataArrayList
        notifyDataSetChanged()
    }

    constructor(recyclerDataArrayList: ArrayList<CommentDataItems>?, mcontext: Context?){
        courseDataArrayList = recyclerDataArrayList
        this.mcontext = mcontext
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        // Inflate Layout
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.trend_item_row, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        // Set the data to textview and imageview.
        val recyclerData: CommentDataItems = courseDataArrayList!![position]
        holder.title.setText(recyclerData.name)
        holder.mainCard.setOnClickListener(View.OnClickListener {
            clickListeners.onItemClick(position, it);
        })

    }

    override fun getItemCount(): Int {
        // this method returns the size of recyclerview
        return courseDataArrayList!!.size
    }

    // View Holder Class to handle Recycler View.
    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener,
        View.OnLongClickListener {
        val title: TextView
        val mainCard: CardView

        init {
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
            title = itemView.findViewById(R.id.title)
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

    fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charString = constraint?.toString() ?: ""
                if (charString.isEmpty()) coursesListFiltered = courseDataArrayList!! else {
                    val filteredList = ArrayList<CommentDataItems>()
                    courseDataArrayList?.filter {
                        (it.id?.contains(constraint!!))!! or
                                (it.name!!.contains(constraint!!))

                    }
                        ?.forEach { filteredList.add(it) }
                    coursesListFiltered = filteredList

                }
                return FilterResults().apply { values = coursesListFiltered }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {

                coursesListFiltered = if (results?.values == null)
                    ArrayList()
                else
                    results.values as ArrayList<CommentDataItems>
                notifyDataSetChanged()
            }
        }
    }

}