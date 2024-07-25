package com.surfeillance.surfeillanceV2_backend.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateTimeParser {
    public String getTime(String dateTime){

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateTime, dateTimeFormatter);

        return parsedDateTime.toLocalTime().toString();
    }

    public String getDate(String dateTime){

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateTime, dateTimeFormatter);

        return parsedDateTime.toLocalDate().toString();
    }
}
