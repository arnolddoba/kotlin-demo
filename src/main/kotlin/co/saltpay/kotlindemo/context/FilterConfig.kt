package co.saltpay.kotlindemo.context

import co.saltpay.kotlindemo.integration.saltid.SaltIdApiConfigProperties
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FilterConfig(val saltIdConfigProperties: SaltIdApiConfigProperties) {

    @Bean
    fun userContextFilter(): FilterRegistrationBean<ExecutionContextFilter> {
        val registration = FilterRegistrationBean(ExecutionContextFilter(saltIdConfigProperties))
        registration.order = Int.Companion.MIN_VALUE + 1
        registration.addUrlPatterns("*")
        return registration
    }
}
