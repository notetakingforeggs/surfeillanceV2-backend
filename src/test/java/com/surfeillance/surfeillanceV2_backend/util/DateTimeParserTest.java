package com.surfeillance.surfeillanceV2_backend.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeParserTest {

    private DateTimeParser dateTimeParser;

    // happy paths only - basic functionality. Is it worth testing otherwise? why? in case the public api breaks and gives me invalid dates? maybe worthwhile idk.

    @BeforeEach
    public void setUp() {
        dateTimeParser = new DateTimeParser();
    }

    @Test
    void getTime() {
        String dateTime = "2024-12-02T14:00";
        String expectedTime = "14:00";

        String time = dateTimeParser.getTime(dateTime);

        assertEquals(time, expectedTime);

    }

    @Test
    void getDate() {
        String dateTime = "2024-12-02T14:00";
        String expectedDate = "2024-12-02";

        String date = dateTimeParser.getDate(dateTime);

        assertEquals(date, expectedDate);

    }
}