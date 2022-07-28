package co.saltpay.kotlindemo.integration.saltid.config

import co.saltpay.kotlindemo.integration.saltid.SaltIdApiConfigProperties
import co.saltpay.kotlindemo.integration.saltid.UserService
import com.saltpay.merchantportalbff.service.integration.saltid.service.SaltIdUserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class MyConfig {

    @Bean
    fun restTemplate(): RestTemplate =
        RestTemplate();

    @Bean
    fun sessionService(restTemplate: RestTemplate, saltIdApiConfigProperties: SaltIdApiConfigProperties):
            UserService = SaltIdUserService(saltIdApiConfigProperties, restTemplate);

}
