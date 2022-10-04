import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class GetAllDateLocaleFormat {

    public static void main(String[] args) {
        Date d = new Date();
        Locale[] locales = DateFormat.getAvailableLocales();
        for (Locale l: locales){
            DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, l);
            System.out.println(l.toString() + "---> " + df.format(d));
        }
    }
}
