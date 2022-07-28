package co.saltpay.kotlindemo.integration.saltid

import co.saltpay.kotlindemo.integration.saltid.data.User

interface UserService {
    fun retrieveUserData(): User?
}
