package com.wuerthcs.platform.filtering.auth

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.Authentication

class ApiKeyAuthManager(val apiKey: String) : AuthenticationManager {

    override fun authenticate(authentication: Authentication?): Authentication {

        val principal: String? = authentication?.principal as String?

        if (principal == apiKey) {
            authentication?.isAuthenticated = true
            return authentication!!
        } else {
            throw BadCredentialsException("bad api key")
        }

    }
}