// java
import java.io.PrintStream;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // try to allow UTF-8 output on Windows
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (Exception ignored) {}

        Scanner sc = new Scanner(System.in);

        System.out.println("Select the language to display the message");
        System.out.println("1. English");
        System.out.println("2. Finnish");
        System.out.println("3. Japan");
        System.out.println("4. Swedish");
        System.out.print("Language: ");

        int choice = sc.nextInt(); // simplified: no validation
        switch (choice) {
            case 2: Locale.setDefault(new Locale("fi", "FI")); break;
            case 3: Locale.setDefault(new Locale("ja", "JP")); break;
            case 4: Locale.setDefault(new Locale("sv", "SE")); break;
            default: Locale.setDefault(new Locale("en", "US")); break;
        }

        Locale locale = Locale.getDefault();
        ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", locale);
        NumberFormat currency = NumberFormat.getCurrencyInstance(locale);
        Scanner in = new Scanner(System.in).useLocale(locale);

        System.out.println("Current locale: " + locale.getDisplayLanguage(locale) + " - " + locale.getDisplayCountry(locale));

        System.out.print(rb.getString("pieces") + " ");
        int itemCount = in.nextInt();

        double grandTotal = 0.0;
        for (int i = 1; i <= itemCount; i++) {
            System.out.print(MessageFormat.format(rb.getString("price"), i) + " ");
            double price = in.nextDouble();

            System.out.print(MessageFormat.format(rb.getString("quantity"), i) + " ");
            int qty = in.nextInt();

            double itemTotal = price * qty;
            grandTotal += itemTotal;
            System.out.println(MessageFormat.format(rb.getString("total"), i, currency.format(itemTotal)));
        }

        System.out.println(rb.getString("total") + " " + currency.format(grandTotal));

        in.close();
        sc.close();
    }
}
