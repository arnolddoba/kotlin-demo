package com.saltpay.merchantportalbff.service.integration.saltid.service

import co.saltpay.kotlindemo.integration.saltid.SaltIdApiConfigProperties
import co.saltpay.kotlindemo.integration.saltid.UserService
import co.saltpay.kotlindemo.integration.saltid.data.User
import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate

@Slf4j
class SaltIdUserService(
    var saltIdApiConfigProperties: SaltIdApiConfigProperties,
    var restTemplate: RestTemplate
) : UserService {

    override fun retrieveUserData(): User? {
        val entity: HttpEntity<*> = HttpEntity<Any?>(saltIdApiConfigProperties.getHeaders()!!)
        val responseEntity: ResponseEntity<User> = restTemplate.exchange(
            saltIdApiConfigProperties.sessionDataUrl, HttpMethod.GET, entity,
            User::class.java
        )
        return responseEntity.body;
    }

}
