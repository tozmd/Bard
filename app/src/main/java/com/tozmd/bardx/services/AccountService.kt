package com.tozmd.bardx.services


/*
FirebaseAuth service
 */
interface AccountService {
    fun authenticate(email: String, password: String, onResult: (Throwable?) -> Unit)
    fun createAccount(email: String, password: String, onResult: (Throwable?) -> Unit)
    fun createAnonymousAccount(onResult: (Throwable?) -> Unit)
}