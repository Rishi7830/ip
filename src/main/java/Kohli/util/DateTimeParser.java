package Kohli.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTimeParser {
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private static final DateTimeFormatter OUTPUT_FORMATTER = DateTimeFormatter.ofPattern("MMM d yyyy, h:mm a");
    private static final DateTimeFormatter FILE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static LocalDateTime parse(String dateTime) throws DateTimeParseException {
        return LocalDateTime.parse(dateTime, INPUT_FORMATTER);
    }

    public static String format(LocalDateTime dateTime) {
        return dateTime.format(OUTPUT_FORMATTER);
    }

    public static LocalDateTime parseFromFile(String dateTime) throws DateTimeParseException {
        return LocalDateTime.parse(dateTime, FILE_FORMATTER);
    }

    public static String formatForFile(LocalDateTime dateTime) {
        return dateTime.format(FILE_FORMATTER);
    }
}
