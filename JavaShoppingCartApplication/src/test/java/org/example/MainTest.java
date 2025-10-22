package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    private static final double EPS = 1e-9;

    @Test
    void testItemTotal_positive() {
        double price = 1.5;
        int qty = 4;
        double expected = 6.0;
        assertEquals(expected, CartCalculator.itemTotal(price, qty), EPS);
    }

    @Test
    void testItemTotal_zeroQuantity() {
        assertEquals(0.0, CartCalculator.itemTotal(9.99, 0), EPS);
    }

    @Test
    void testItemTotal_zeroPrice() {
        assertEquals(0.0, CartCalculator.itemTotal(0.0, 5), EPS);
    }

    @Test
    void testGrandTotal_multipleItems() {
        double t1 = CartCalculator.itemTotal(1.0, 3);   // 3.0
        double t2 = CartCalculator.itemTotal(2.5, 2);   // 5.0
        double t3 = CartCalculator.itemTotal(3.33, 1);  // 3.33
        double expected = 11.33;
        assertEquals(expected, CartCalculator.grandTotal(t1, t2, t3), 1e-6);
    }

    @Test
    void testGrandTotal_empty() {
        assertEquals(0.0, CartCalculator.grandTotal(), EPS);
    }

    @Test
    void testGrandTotal_null() {
        assertEquals(0.0, CartCalculator.grandTotal((double[]) null), EPS);
    }
}
