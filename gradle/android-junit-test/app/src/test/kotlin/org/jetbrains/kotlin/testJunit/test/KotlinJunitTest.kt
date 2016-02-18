package org.jetbrains.kotlin.testJunit.test

import org.junit.Assert
import org.junit.Test


class KotlinJunitTest {

    @Test
    fun firstTest() {
        Assert.assertTrue(1 == 1)
    }

}

