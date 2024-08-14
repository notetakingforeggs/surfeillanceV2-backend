package com.surfeillance.surfeillanceV2_backend.util;

import org.springframework.stereotype.Component;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateTimeParserUtil {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    //parse DateTime into a date String
    public String parseDate(String dateTime) {
        validateInput(dateTime);
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime, formatter);
        LocalDate localDate = localDateTime.toLocalDate();
        return localDate.toString();
    }

    //parse DateTime into a time String
    public String parseTime(String dateTime) {
        validateInput(dateTime);
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime, formatter);
        return localDateTime.toLocalTime().toString();
    }

    private void validateInput(String dateTime) {
        try {
            LocalDateTime.parse(dateTime, formatter);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("Invalid date-time format. Please use YYYY-MM-DDTHH:mm format.");
        }
    }
}