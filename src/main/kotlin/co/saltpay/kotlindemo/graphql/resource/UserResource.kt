package co.saltpay.kotlindemo.graphql.resource

import co.saltpay.kotlindemo.integration.saltid.UserService
import co.saltpay.kotlindemo.integration.saltid.data.User
import io.leangen.graphql.annotations.GraphQLQuery
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi
import org.springframework.stereotype.Service

@Service
@GraphQLApi
class UserResource(var userService: UserService) {

    @GraphQLQuery
    fun userInfo(): User? {
        return userService.retrieveUserData()
    }
}
