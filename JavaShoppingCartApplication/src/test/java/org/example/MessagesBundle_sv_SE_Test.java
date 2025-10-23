package org.example;

import org.junit.jupiter.api.Test;

public class MessagesBundle_sv_SE_Test {

    @Test
    void testSwedishBundlePieces() {
        java.util.Locale locale = new java.util.Locale("sv", "SE");
        java.util.ResourceBundle rb = java.util.ResourceBundle.getBundle("MessagesBundle", locale);
        assert rb.getString("pieces").equals("Ange antalet varor att köpa:");
    }
    @Test
    void testSwedishBundlePrice() {
        java.util.Locale locale = new java.util.Locale("sv", "SE");
        java.util.ResourceBundle rb = java.util.ResourceBundle.getBundle("MessagesBundle", locale);
        assert rb.getString("price").equals("Ange priset för varan {0}:");
    }
    @Test
    void testSwedishBundleQuantity() {
        java.util.Locale locale = new java.util.Locale("sv", "SE");
        java.util.ResourceBundle rb = java.util.ResourceBundle.getBundle("MessagesBundle", locale);
        assert rb.getString("quantity").equals("Ange mängden varor {0}:");
    }
    @Test
    void testSwedishBundleTotal() {
        java.util.Locale locale = new java.util.Locale("sv", "SE");
        java.util.ResourceBundle rb = java.util.ResourceBundle.getBundle("MessagesBundle", locale);
        assert rb.getString("total").equals("Total kostnad {0} {1}:");
    }
}
