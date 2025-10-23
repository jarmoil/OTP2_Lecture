package org.example;

import org.junit.jupiter.api.Test;

public class MessagesBundle_ja_JP_Test {

    @Test
    void testJapaneseBundlePieces() {
        java.util.Locale locale = new java.util.Locale("ja", "JP");
        java.util.ResourceBundle rb = java.util.ResourceBundle.getBundle("MessagesBundle", locale);
        assert rb.getString("pieces").equals("「購入する商品の数を入力してください:」");
    }
    @Test
    void testJapaneseBundlePrice() {
        java.util.Locale locale = new java.util.Locale("ja", "JP");
        java.util.ResourceBundle rb = java.util.ResourceBundle.getBundle("MessagesBundle", locale);
        assert rb.getString("price").equals("「商品の価格を入力してください: {0}」");
    }
    @Test
    void testJapaneseBundleQuantity() {
        java.util.Locale locale = new java.util.Locale("ja", "JP");
        java.util.ResourceBundle rb = java.util.ResourceBundle.getBundle("MessagesBundle", locale);
        assert rb.getString("quantity").equals("「商品の数量を入力してください: {0}」");
    }
    @Test
    void testJapaneseBundleTotal() {
        java.util.Locale locale = new java.util.Locale("ja", "JP");
        java.util.ResourceBundle rb = java.util.ResourceBundle.getBundle("MessagesBundle", locale);
        assert rb.getString("total").equals("「合計金額: {0} {1}」");
    }
}
