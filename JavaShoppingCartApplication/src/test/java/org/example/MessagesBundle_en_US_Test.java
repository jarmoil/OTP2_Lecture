package org.example;

import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessagesBundle_en_US_Test {


    @Test
    void testEnglishBundlePieces() {
        Locale locale = new Locale("en", "US");
        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", locale);
        assertEquals("Enter the number of items to purchase:", rb.getString("pieces"));
    }
    @Test
    void testEnglishBundlePrice() {
        Locale locale = new Locale("en", "US");
        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", locale);
        assertEquals("Enter the price for item {0}:", rb.getString("price"));
    }
    @Test
    void testEnglishBundleQuantity() {
        Locale locale = new Locale("en", "US");
        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", locale);
        assertEquals("Enter the quantity for item {0}:", rb.getString("quantity"));
    }
    @Test
    void testEnglishBundleTotal() {
        Locale locale = new Locale("en", "US");
        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", locale);
        assertEquals("Total cost {0} {1}:", rb.getString("total"));
    }


}
