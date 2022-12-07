package com.example.controller

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.CookieValue
import io.micronaut.http.annotation.Get
import io.micronaut.http.cookie.Cookie
import io.micronaut.http.cookie.SameSite

@Controller
class TestController {
    @Get(produces = [MediaType.TEXT_PLAIN])
    fun login(): HttpResponse<String> = HttpResponse.ok("OK").cookie(
        Cookie.of("TEST", "337").domain(".test-a.com").secure(true).sameSite(
            SameSite.None
        ).httpOnly(true)
    )

    @Get(produces = [MediaType.TEXT_PLAIN])
    fun check(@CookieValue("TEST") test: String): String {
        return "Cookie: $test"
    }
}