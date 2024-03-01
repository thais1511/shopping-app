package tqthai.demo.core.network.entities

import org.json.JSONObject

class AppNetworkException : Throwable() {

    fun parse(exception: String) {
        try {
            val json = JSONObject(exception)
            val message = json.get("message")
        } catch (e: Exception) {

        }

    }

}