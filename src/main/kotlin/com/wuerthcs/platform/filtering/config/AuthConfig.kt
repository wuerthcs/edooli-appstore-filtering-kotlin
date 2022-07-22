package com.wuerthcs.platform.filtering.config

import com.wuerthcs.platform.filtering.auth.ApiKeyAuthFilter
import com.wuerthcs.platform.filtering.auth.ApiKeyAuthManager
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy

@Configuration
@EnableWebSecurity
class AuthConfig : WebSecurityConfigurerAdapter() {

    companion object {
        const val API_KEY_AUTH_HEADER_NAME = "X-API-Key"
    }

    //@Value("\${addonfilter.apikey}")
    @Value("test")
    lateinit var apiKey: String

    override fun configure(http: HttpSecurity) {
        val filter = ApiKeyAuthFilter(API_KEY_AUTH_HEADER_NAME)
        filter.setAuthenticationManager(ApiKeyAuthManager(apiKey))
        http.antMatcher("/api/v1/**")
            .csrf().disable().sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .addFilter(filter)
            .authorizeRequests()
            .anyRequest()
            .authenticated()
    }
}