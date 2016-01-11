package org.jetbrains.kotlin.testJunit.test

import org.junit.Test
import kotlin.test.assertTrue

public class KotlinJunitTest {

    @Test
    public fun firstTest() {
        assertTrue(1 == 1)
    }
}

