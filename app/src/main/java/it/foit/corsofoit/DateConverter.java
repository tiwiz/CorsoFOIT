package it.foit.corsofoit;


import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public final class DateConverter {

    private static final DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy - HH:mm");

    private DateConverter() {
        throw new RuntimeException("You shal not pa... instantiate!");
    }

    public static String convertToHumanReadableTime(String unixTimestamp) {
        long realTimestamp = Long.parseLong(unixTimestamp) * 1000L;
        DateTime dateTime = new DateTime(realTimestamp);
        return formatter.print(dateTime);
    }

}
