package org.example;

public final class CartCalculator {
    private CartCalculator() {}

    public static double itemTotal(double price, int quantity) {
        return price * quantity;
    }

    public static double grandTotal(double... itemTotals) {
        double sum = 0.0;
        if (itemTotals == null) return sum;
        for (double t : itemTotals) sum += t;
        return sum;
    }
}
