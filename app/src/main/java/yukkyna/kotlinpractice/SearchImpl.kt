package yukkyna.kotlinpractice

import android.content.Context
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class SearchImpl(context: Context) : AbstractSearch<SearchResult>(context) {
    override fun loadInBackground(): SearchResult? {
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
        val a = stringBuilder.toString()
        val mapper = ObjectMapper().registerModule(KotlinModule())
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        val r: SearchResult = mapper.readValue<SearchResult>(a)
        return r
    }
}