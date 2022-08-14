package com.tozmd.bardx.services.impl

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.tozmd.bardx.services.AccountService
import javax.inject.Inject

/*
Implementation of FirebaseAuth
 */
class AccountServiceImpl @Inject constructor(): AccountService {
    override fun authenticate(email: String, password: String, onResult: (Throwable?) -> Unit) {
        Firebase.auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{ onResult(it.exception) }
    }

        override fun createAccount(email: String, password: String, onResult: (Throwable?) -> Unit) {
        Firebase.auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { onResult(it.exception) }
    }

    override fun createAnonymousAccount(onResult: (Throwable?) -> Unit) {
        Firebase.auth.signInAnonymously()
            .addOnCompleteListener { onResult(it.exception) }
    }
}