package com.surfeillance.surfeillanceV2_backend.util;

import com.surfeillance.surfeillanceV2_backend.model.Forecast;
import com.surfeillance.surfeillanceV2_backend.model.Spot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class OnshoreOffshoreTest {

    private OnshoreOffshore onshoreOffshore = new OnshoreOffshore();

    @Test
    public void testWindIsOffshore_DirectOffshore() {
        Spot spot = new Spot("Test Spot", 0.0, 0.0, 0.0);
        Forecast forecast = new Forecast(spot, "2023-07-01", "12:00", 1.0, 0.0, 10.0, 10.0, 180.0, 15.0);
        assertTrue(onshoreOffshore.windIsOffshore(forecast));
    }

    @Test
    public void testWindIsOffshore_DirectOnshore() {
        Spot spot = new Spot("Test Spot", 0.0, 0.0, 0.0);
        Forecast forecast = new Forecast(spot, "2023-07-01", "12:00", 1.0, 0.0, 10.0, 10.0, 0.0, 15.0);
        assertFalse(onshoreOffshore.windIsOffshore(forecast));
    }

    @Test
    public void testWindIsOffshore_EdgeCase1() {
        Spot spot = new Spot("Test Spot", 0.0, 0.0, 0.0);
        Forecast forecast = new Forecast(spot, "2023-07-01", "12:00", 1.0, 0.0, 10.0, 10.0, 100.0, 15.0);
        assertTrue(onshoreOffshore.windIsOffshore(forecast));
    }

    @Test
    public void testWindIsOffshore_EdgeCase2() {
        Spot spot = new Spot("Test Spot", 0.0, 0.0, 0.0);
        Forecast forecast = new Forecast(spot, "2023-07-01", "12:00", 1.0, 0.0, 10.0, 10.0, 100.1, 15.0);
        assertTrue(onshoreOffshore.windIsOffshore(forecast));
    }

    @Test
    public void testWindIsOffshore_FullCircle() {
        Spot spot = new Spot("Test Spot", 0.0, 0.0, 0.0);
        Forecast forecast = new Forecast(spot, "2023-07-01", "12:00", 1.0, 0.0, 10.0, 10.0, 360.0, 15.0);
        assertFalse(onshoreOffshore.windIsOffshore(forecast));
    }

    @Test
    public void testWavesAreOnshore_DirectOnshore() {
        Spot spot = new Spot("Test Spot", 0.0, 0.0, 0.0);
        Forecast forecast = new Forecast(spot, "2023-07-01", "12:00", 1.0, 0.0, 10.0, 10.0, 0.0, 15.0);
        assertTrue(onshoreOffshore.wavesAreOnshore(forecast));
    }

    @Test
    public void testWavesAreOnshore_DirectOffshore() {
        Spot spot = new Spot("Test Spot", 0.0, 0.0, 0.0);
        Forecast forecast = new Forecast(spot, "2023-07-01", "12:00", 1.0, 180.0, 10.0, 10.0, 0.0, 15.0);
        assertFalse(onshoreOffshore.wavesAreOnshore(forecast));
    }

    @Test
    public void testWavesAreOnshore_EdgeCase1() {
        Spot spot = new Spot("Test Spot", 0.0, 0.0, 0.0);
        Forecast forecast = new Forecast(spot, "2023-07-01", "12:00", 1.0, 74.9, 10.0, 10.0, 0.0, 15.0);
        assertTrue(onshoreOffshore.wavesAreOnshore(forecast));
    }

    @Test
    public void testWavesAreOnshore_EdgeCase2() {
        Spot spot = new Spot("Test Spot", 0.0, 0.0, 0.0);
        Forecast forecast = new Forecast(spot, "2023-07-01", "12:00", 1.0, 75.1, 10.0, 10.0, 0.0, 15.0);
        assertFalse(onshoreOffshore.wavesAreOnshore(forecast));
    }

    @Test
    public void testWavesAreOnshore_FullCircle() {
        Spot spot = new Spot("Test Spot", 0.0, 0.0, 0.0);
        Forecast forecast = new Forecast(spot, "2023-07-01", "12:00", 1.0, 360.0, 10.0, 10.0, 0.0, 15.0);
        assertTrue(onshoreOffshore.wavesAreOnshore(forecast));
    }
}