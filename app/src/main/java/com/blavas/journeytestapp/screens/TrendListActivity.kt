package com.blavas.journeytestapp.screens

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.blavas.journeytestapp.Adapter.TrendAdapter
import com.blavas.journeytestapp.R
import com.blavas.journeytestapp.databinding.ActivityTrendListBinding
import com.blavas.journeytestapp.models.TrendData
import com.blavas.journeytestapp.screens.ui.CommentListActivity
import com.trendnxt.utils.ServerConfig
import com.trendnxt.utils.ServerConnector
import org.json.JSONArray
import org.json.JSONException

class TrendListActivity : AppCompatActivity(),
    androidx.appcompat.widget.SearchView.OnQueryTextListener {

    lateinit var binding: ActivityTrendListBinding
    lateinit var recyclerView: RecyclerView
    lateinit var progressBar: ProgressBar
    lateinit var message: TextView
    lateinit var searchView: androidx.appcompat.widget.SearchView


    companion object {
        lateinit var key: String
        lateinit var appTitle: String
        lateinit var recyclerDataArrayList: ArrayList<TrendData>
        lateinit var adapter: TrendAdapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trend_list)

        setTitle(getResources().getText(R.string.title_list))
        key = intent.getStringExtra("key").toString()
        appTitle = intent.getStringExtra("title").toString()
        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.progressBar)
        message = findViewById(R.id.message)
        searchView = findViewById(R.id.idSV_posts)

        recyclerDataArrayList = ArrayList()

        // added data to array list

        /* // added data to array list
         recyclerDataArrayList.add(GridData("DSA", R.drawable.politic))
         recyclerDataArrayList.add(GridData("JAVA", R.drawable.politic))
         recyclerDataArrayList.add(GridData("C++", R.drawable.politic))
         recyclerDataArrayList.add(GridData("Python", R.drawable.politic))
         recyclerDataArrayList.add(GridData("Node Js", R.drawable.politic))
         recyclerDataArrayList.add(GridData("Node Js", R.drawable.politic))
         recyclerDataArrayList.add(GridData("Node Js", R.drawable.politic))
         recyclerDataArrayList.add(GridData("Node Js", R.drawable.politic))
         recyclerDataArrayList.add(GridData("Node Js", R.drawable.politic))
 */
        // added data from arraylist to adapter class.

        // added data from arraylist to adapter class.
        adapter = TrendAdapter(recyclerDataArrayList, applicationContext)

        adapter.setCartItemClickListener(object : TrendAdapter.ClickListener {
            override fun onItemClick(position: Int, v: View?) {
                val model: TrendData = recyclerDataArrayList.get(position)

                startActivity(
                    Intent(applicationContext, CommentListActivity::class.java)
                    .putExtra("key_id", model.id))

            }

            override fun onItemLongClick(position: Int, v: View?) {}
        })

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        val layoutManager = LinearLayoutManager(applicationContext)

        // at last set adapter to recycler view.

        // at last set adapter to recycler view.
        recyclerView.setLayoutManager(layoutManager)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(this)
        getTrends()
    }

    @SuppressLint("SuspiciousIndentation")
    private fun getTrends() {
        val loginConnection = ServerConnector()
        loginConnection.setIsget(true)
        recyclerView.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
        message.visibility =View.GONE

        val stringRequest = StringRequest(
            Request.Method.GET, ServerConfig.Trends_url,
            { response ->
                Log.d("strrrrr", ">>$response")

                try {
                    recyclerView.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                    val objArry = JSONArray(response)
                    if (objArry.length()>0) {

                        recyclerDataArrayList = ArrayList<TrendData>()
                        if (recyclerDataArrayList!=null)
                            recyclerDataArrayList.clear()

                        for (i in 0 until objArry.length()) {
                            val dataOb = objArry.getJSONObject(i)
                            var userId: String = ""
                            var id: String = ""
                            var title: String = ""
                            var body: String = ""
                            if (dataOb.has("userId"))
                                userId = dataOb.getString("userId")
                            if (dataOb.has("id"))
                                id = dataOb.getString("id")
                            if (dataOb.has("title"))
                                title = dataOb.getString("title")
                            if (dataOb.has("body"))
                                body = dataOb.getString("body")

                                recyclerDataArrayList.add(TrendData(userId, id, title, body))
                        }
                        adapter.updateList(recyclerDataArrayList)
                    }else{
                        recyclerView.visibility = View.GONE
                        progressBar.visibility = View.GONE
                        message.visibility =View.VISIBLE
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                    recyclerView.visibility = View.GONE
                    progressBar.visibility = View.GONE
                    message.visibility =View.VISIBLE
                }
            },
            { error ->
                //displaying the error in toast if occurrs
                Toast.makeText(applicationContext, error.message, Toast.LENGTH_SHORT).show()
            })

        // request queue
        val requestQueue = Volley.newRequestQueue(this)

        requestQueue.add(stringRequest)

    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        adapter.filter.filter(query)
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        adapter.filter.filter(newText)
        return false
    }

}
