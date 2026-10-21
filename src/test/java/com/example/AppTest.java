// src/test/java/com/example/AppTest.java
package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AppTest {
    @Test
    public void testGreet() {
        App app = new App();
        String result = app.greet("World");
        assertEquals("Hello, World!", result);
    }
}