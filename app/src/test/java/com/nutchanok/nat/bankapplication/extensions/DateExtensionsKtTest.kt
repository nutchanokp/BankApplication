package com.nutchanok.nat.bankapplication.extensions

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test

class DateExtensionsKtTest {

    @Test
    fun toDateFormat_is_equal() {

        val tasks = "2022-08-10 22:20:22"
        val answer = "10 Aug 2022 - 22:20"

        val result = (tasks).toDateFormat(DateFormat.FROM_SERVICE_TIME, DateFormat.SHOW)

        MatcherAssert.assertThat(result, CoreMatchers.`is`(answer))


    }

}