package yukkyna.kotlinpractice

import android.content.Context
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class SearchImpl(context: Context) : AbstractSearch<String>(context) {
    override fun loadInBackground(): String? {
        val strUrl = "https://itunes.apple.com/search?term=jack+johnson"
        val url = URL(strUrl)
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        connection.connect()
        val reader = BufferedReader(InputStreamReader(connection.inputStream))
        val stringBuilder = StringBuilder()
        for (line in reader.readLines()) {
            line.let { stringBuilder.append(line) }
        }
        reader.close()
        return stringBuilder.toString()
    }
}