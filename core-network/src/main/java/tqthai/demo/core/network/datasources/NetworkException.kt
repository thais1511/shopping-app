package tqthai.demo.core.network.datasources

import org.json.JSONObject

class NetworkException: Throwable() {

    fun parse(exception: String){
        val message = try {
            val json = JSONObject(exception)
            json.get("message")
        } catch (e: Exception){

        }
    }
}