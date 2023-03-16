package com.blavas.journeytestapp.screens.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.blavas.journeytestapp.Adapter.CommentAdapter
import com.blavas.journeytestapp.R
import com.blavas.journeytestapp.models.CommentDataItems
import com.blavas.journeytestapp.screens.TrendListActivity
import com.trendnxt.utils.ServerConfig
import com.trendnxt.utils.ServerConnector
import org.json.JSONArray
import org.json.JSONException

class CommentListActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    lateinit var recyclerViewcomment: RecyclerView
    lateinit var progressBar: ProgressBar
    lateinit var message: TextView
    lateinit var searchViewComment: androidx.appcompat.widget.SearchView

    companion object {
        lateinit var key_id: String
        lateinit var appTitle: String
        lateinit var recyclerDataCommentArrayList: ArrayList<CommentDataItems>
        lateinit var commentadapter: CommentAdapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment_list)

        setTitle(getResources().getText(R.string.title_comment_screen))
        key_id = intent.getStringExtra("key_id").toString()
       // appTitle = intent.getStringExtra("title").toString()
        recyclerViewcomment = findViewById(R.id.recyclerView_comment)
        progressBar = findViewById(R.id.progressBar_comment)
        message = findViewById(R.id.message_comment)
        searchViewComment = findViewById(R.id.idSV_posts_comment)

        recyclerDataCommentArrayList = ArrayList()

        // added data from arraylist to adapter class.
        commentadapter = CommentAdapter(recyclerDataCommentArrayList, applicationContext)

        commentadapter.setCartItemClickListener(object : CommentAdapter.ClickListener {
            override fun onItemClick(position: Int, v: View?) {
                val model: CommentDataItems = recyclerDataCommentArrayList.get(position)

                /*
                    startActivity(Intent(applicationContext, TrendListActivity::class.java)
                        .putExtra("key", model.getKey()))
                */
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
        recyclerViewcomment.setLayoutManager(layoutManager)
        recyclerViewcomment.setAdapter(commentadapter)

        searchViewComment.setOnQueryTextListener(this)
        getTrendsComments()

    }


    private fun getTrendsComments() {
        val loginConnection = ServerConnector()
        loginConnection.setIsget(true)
        recyclerViewcomment.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
        message.visibility = View.GONE

        val stringRequest = StringRequest(
            Request.Method.GET, ServerConfig.Trends_url_Comments+key_id,
            Response.Listener { response ->
                Log.d("strrrrr", ">>$response")

                try {
                    recyclerViewcomment.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                    val objArry = JSONArray(response)
                    if (objArry.length()>0) {

                        recyclerDataCommentArrayList = ArrayList<CommentDataItems>()
                        if (recyclerDataCommentArrayList!=null)
                            recyclerDataCommentArrayList.clear()

                        for (i in 0 until objArry.length()) {
                            val dataOb = objArry.getJSONObject(i)
                            var postId: String = ""
                            var id: String = ""
                            var name: String = ""
                            var email: String = ""
                            var body: String = ""
                            if (dataOb.has("postId"))
                                postId = dataOb.getString("postId")
                            if (dataOb.has("id"))
                                id = dataOb.getString("id")
                            if (dataOb.has("name"))
                                name = dataOb.getString("name")
                            if (dataOb.has("email"))
                                email = dataOb.getString("email")
                            if (dataOb.has("body"))
                                body = dataOb.getString("body")

                            recyclerDataCommentArrayList.add(CommentDataItems(postId, id, name, email, body))
                        }
                        commentadapter.updateList(recyclerDataCommentArrayList)
                    }else{
                        recyclerViewcomment.visibility = View.GONE
                        progressBar.visibility = View.GONE
                        message.visibility = View.VISIBLE
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                    recyclerViewcomment.visibility = View.GONE
                    progressBar.visibility = View.GONE
                    message.visibility = View.VISIBLE
                }
            },
            Response.ErrorListener { error ->
                //displaying the error in toast if occurrs
                Toast.makeText(applicationContext, error.message, Toast.LENGTH_SHORT).show()
            })

        // request queue
        val requestQueue = Volley.newRequestQueue(this)

        requestQueue.add(stringRequest)

    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        commentadapter.getFilter().filter(query)
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        commentadapter.getFilter().filter(newText)
        return false
    }

}