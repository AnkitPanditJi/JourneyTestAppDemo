package com.trendnxt.utils

import android.os.AsyncTask
import android.util.Log
import java.io.*
import java.net.HttpURLConnection
import java.net.URL

class ServerConnector: AsyncTask<String, String, String>() {

    var urlParameters: String? = null
    var accessToken: String? = null
    private var isget = false
    var isHeaderTypeApplicationJson = false
    private var mListener: onAsyncTaskComplete? = null

    fun constructor() {
    }

    fun setParameter(urlParameters: String?){
        this.urlParameters = urlParameters
    }

    fun setAccessTokens(accessToken: String?){
        this.accessToken = accessToken
    }

    fun GET(urls: String?): String? {
        val url: URL
        var result = ""
        var urlConnection: HttpURLConnection? = null
        try {
            url = URL(urls)
            Log.e("", url.toString())
            urlConnection = url
                .openConnection() as HttpURLConnection
            val `in` = urlConnection.inputStream
            //
            val rd = BufferedReader(InputStreamReader(`in`))
            var line: String?
            val response = StringBuffer()
            while (rd.readLine().also { line = it } != null) {
                response.append(line)
                response.append('\r')
            }
            rd.close()
            result = response.toString()
            /* InputStreamReader isw = new InputStreamReader(in);
            result = convertInputStreamToString(in);
            int data = isw.read();
            while (data != -1) {
                char current = (char) data;
                data = isw.read();
                System.out.print(current);
            }*/
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            urlConnection?.disconnect()
        }
        return result
    }

    @Throws(IOException::class)
    private fun convertInputStreamToString(inputStream: InputStream): String? {
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        var line: String? = ""
        var result: String? = ""
        while (bufferedReader.readLine().also { line = it } != null) result += line
        inputStream.close()
        return result
    }

    fun setIsget(isget: Boolean) {
        this.isget = isget
    }

    fun setHeaderTypeAppJson(_isHeaderTypeApplicationJson: Boolean) {
        isHeaderTypeApplicationJson = _isHeaderTypeApplicationJson
    }

    fun excutePost(targetURL: String?, urlParameters: String?): String? {
        val url: URL
        var connection: HttpURLConnection? = null
        return try {
            //Create connection
            url = URL(targetURL)
            Log.e("",url.toString())
            Log.e("", "Parameter : $urlParameters")
            connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection!!.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded")
            connection.setRequestProperty("Content-Length", "" +
                    Integer.toString(urlParameters!!.toByteArray().size))
            connection.setRequestProperty("Content-Language", "en-US")
            // this line is mainly added for API
            // http://103.91.90.234:8002/cloud-api because in this header type is application/json
            // to get Captured Business card image details
            if (isHeaderTypeApplicationJson) {
                connection.setRequestProperty("Content-Type", "application/json")
                connection.setRequestProperty("Authorization", "Bearer " + accessToken)
                connection.requestMethod = "PUT"
            }
            connection.useCaches = false
            connection.doInput = true
            connection.doOutput = true

            //Send request
            val wr = DataOutputStream(
                connection.outputStream)
            wr.writeBytes(urlParameters)
            wr.flush()
            wr.close()

            //Get Response
            val `is` = connection.inputStream
            val rd = BufferedReader(InputStreamReader(`is`))
            var line: String?
            val response = StringBuffer()
            while (rd.readLine().also { line = it } != null) {
                response.append(line)
                response.append('\r')
            }
            rd.close()
            response.toString()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        } finally {
            connection?.disconnect()
        }
    }

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun doInBackground(vararg urls: String?): String? {
        var response: String? = ""
        try {
            response = if (isget) GET(urls[0]) else excutePost(urls[0], urlParameters)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return response
    }

    override fun onPostExecute(s: String?) {
        super.onPostExecute(s)
        mListener!!.OnResponse(s)
    }

    fun setDataDowmloadListner(dataDowmloadListner: onAsyncTaskComplete) {
        mListener = dataDowmloadListner
    }


    interface onAsyncTaskComplete {
        fun OnResponse(response: String?)
    }
}