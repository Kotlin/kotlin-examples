package org.jetbrains.kotlin.testJunit.test

import org.junit.Assert
import org.junit.Test


public class KotlinJunitTest {
    @Test public fun firstTest() {
        Assert.assertTrue(1 == 1)
    }
}

