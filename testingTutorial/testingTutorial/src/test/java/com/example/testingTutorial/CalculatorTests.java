package com.example.testingTutorial;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;

public class CalculatorTests {

    Calculator c = new Calculator();

    @BeforeEach
    public void beforeEveryTest() {
        System.out.println("This is executed before every test");
    }

    @AfterEach
    public void afterEveryTest() {
        System.out.println("This is executed after every test");
    }

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is executed before all the test cases of the class");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("This is executed after all the test cases of the class");
    }

    @Test
    @DisplayName("This is test case for testing add function")
    @Order(1)
    public void testAdd() {
        System.out.println("This is test 1");
        int x = 10;
        int y = 5;
        int expected = 15;
        int actual = c.add(x,y);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @Order(2)
    public void testIsEvenWhenNumberIsEven() {
        System.out.println("This is test 2");
        int x = 10;
        boolean actual = c.isEven(x);
        Assertions.assertTrue(actual);
    }

    @Test
    @Order(0)
    public void testIsEvenWhenNumberIsOdd() {
        System.out.println("This is test 3");
        int x = 15;
        boolean actual = c.isEven(x);
        Assertions.assertFalse(actual);
    }
}
