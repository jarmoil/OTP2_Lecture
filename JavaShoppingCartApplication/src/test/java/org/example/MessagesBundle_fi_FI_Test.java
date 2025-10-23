package org.example;

import org.junit.jupiter.api.Test;

public class MessagesBundle_fi_FI_Test {

    @Test
    void testFinnishBundlePieces() {
        java.util.Locale locale = new java.util.Locale("fi", "FI");
        java.util.ResourceBundle rb = java.util.ResourceBundle.getBundle("MessagesBundle", locale);
        assert rb.getString("pieces").equals("Syötä ostettavien tuotteiden määrä:");
    }
    @Test
    void testFinnishBundlePrice() {
        java.util.Locale locale = new java.util.Locale("fi", "FI");
        java.util.ResourceBundle rb = java.util.ResourceBundle.getBundle("MessagesBundle", locale);
        assert rb.getString("price").equals("Syötä tuotteen hinta (tuote {0}):");
    }
    @Test
    void testFinnishBundleQuantity() {
        java.util.Locale locale = new java.util.Locale("fi", "FI");
        java.util.ResourceBundle rb = java.util.ResourceBundle.getBundle("MessagesBundle", locale);
        assert rb.getString("quantity").equals("Syötä tuotteen määrä (tuote {0}):");
    }
    @Test
    void testFinnishBundleTotal() {
        java.util.Locale locale = new java.util.Locale("fi", "FI");
        java.util.ResourceBundle rb = java.util.ResourceBundle.getBundle("MessagesBundle", locale);
        assert rb.getString("total").equals("Kokonaishinta {0} {1}:");
    }
}
