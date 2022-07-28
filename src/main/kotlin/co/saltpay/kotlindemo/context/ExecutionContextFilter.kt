package co.saltpay.kotlindemo.context

import co.saltpay.kotlindemo.integration.saltid.SaltIdApiConfigProperties
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ExecutionContextFilter(val saltIdApiConfigProperties: SaltIdApiConfigProperties) : OncePerRequestFilter() {


    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        setContext(request);
        filterChain.doFilter(request, response)
    }

    private fun setContext(request: HttpServletRequest) {
        val authorization = request.getHeader("Authorization")
        val authHeader = StringBuilder().append("SALTPAY-API-TOKEN")
            .append(" ")
            .append(saltIdApiConfigProperties.applicationToken)
            .append(":")
            .append(authorization).toString()
        setExecutionContext(ExecutionContext(authHeader));
    }
}
