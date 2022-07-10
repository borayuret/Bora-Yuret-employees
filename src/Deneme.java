import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class Deneme {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String tarih1 = "2022-07-10";
        String tarih2 = "2022-07-14";

        long diff = sdf.parse(tarih1).getTime() - sdf.parse(tarih2).getTime();

        System.out.println(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));

        if (sdf.parse(tarih1).after(sdf.parse(tarih2)))
            System.out.println("Büyüktür");
    }
}
