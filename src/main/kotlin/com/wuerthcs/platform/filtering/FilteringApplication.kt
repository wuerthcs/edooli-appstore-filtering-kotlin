package com.wuerthcs.platform.filtering

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType
import io.swagger.v3.oas.annotations.security.SecurityScheme
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@SecurityScheme(
		name = "wuerthcs-appstore-filtering",
		type = SecuritySchemeType.APIKEY,
		`in` = SecuritySchemeIn.HEADER,
		paramName = "X-API-Key"
)
class FilteringApplication

fun main(args: Array<String>) {
	runApplication<FilteringApplication>(*args)
}
