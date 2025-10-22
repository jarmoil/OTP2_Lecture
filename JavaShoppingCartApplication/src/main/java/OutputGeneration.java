import java.util.Locale;
import java.util.ResourceBundle;

public class OutputGeneration {
    public void printTheLanguage (String languare, String country) {
        Locale mylocale = new Locale(languare, country);
        ResourceBundle rb = ResourceBundle.getBundle("languages", mylocale);
        System.out.print(rb.getString("language"));
        System.out.print(rb.getString("country"));
    }
}
