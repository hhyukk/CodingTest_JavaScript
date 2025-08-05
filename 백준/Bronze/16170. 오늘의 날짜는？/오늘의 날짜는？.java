import java.time.LocalDate;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) {
        LocalDate UTC = LocalDate.now(ZoneId.of("UTC"));

        System.out.println(UTC.getYear());
        if (UTC.getMonthValue() < 10) {
            System.out.println("0" + UTC.getMonthValue());
        } else {
            System.out.println(UTC.getMonthValue());
        }
        System.out.println(UTC.getDayOfMonth());
    }
}
