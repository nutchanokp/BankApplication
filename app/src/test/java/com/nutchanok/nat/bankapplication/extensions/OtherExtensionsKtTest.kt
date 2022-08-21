package com.nutchanok.nat.bankapplication.extensions

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test

class OtherExtensionsKtTest {

    @Test
    fun toCurrency_is_equal() {

        val tasks = 123.212
        val answer = "123.21"

        val result = tasks.toCurrency()

        MatcherAssert.assertThat(result, CoreMatchers.`is`(answer))

    }
    @Test
    fun toCurrency_is_not_equal() {

        val tasks = 123.212
        val answer = "123.210"

        val result = tasks.toCurrency()

        MatcherAssert.assertThat(result, CoreMatchers.not(answer))

    }

}