package co.saltpay.kotlindemo.integration.saltid

import co.saltpay.kotlindemo.context.getExecutionContext
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.stereotype.Component


@ConfigurationProperties(prefix = "salt-id")
@Component
data class SaltIdApiConfigProperties (
    var baseUrl: String = "",
    var sessionDataUrl: String = "",
    var applicationToken: String = "",
    var authorizationScheme: String = ""
) {
    fun getHeaders(): org.springframework.http.HttpHeaders? {
        val headers = org.springframework.http.HttpHeaders()
        headers.add("accept", APPLICATION_JSON_VALUE)
        headers.add("content-type", APPLICATION_JSON_VALUE)
        headers.add("Authorization", getExecutionContext().saltPaySession)
        headers.accept = listOf(APPLICATION_JSON)
        return headers
    }
}
