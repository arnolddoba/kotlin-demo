package co.saltpay.kotlindemo.integration.saltid.data

import com.fasterxml.jackson.annotation.JsonProperty

data class User (
    var email: String,
    @JsonProperty("first_name")
    val firstName: String,
    @JsonProperty("display_name")
    val displayName: String,
    @JsonProperty("last_name")
    val lastName: String,
    val locale: String
)
