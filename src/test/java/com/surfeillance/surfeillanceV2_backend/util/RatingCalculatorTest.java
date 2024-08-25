package com.surfeillance.surfeillanceV2_backend.util;

import com.surfeillance.surfeillanceV2_backend.model.Forecast;
import com.surfeillance.surfeillanceV2_backend.model.Spot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RatingCalculatorTest {

    private RatingCalculator ratingCalculator;
    private Spot thurso = new Spot("thurso", 58.5927, -3.5359, 330D);
    private Spot dunbar = new Spot("dunbar", 56.0006, -2.5142, 35D);
    private Spot arbroath = new Spot("arbroath", 56.5632, -2.5874, 135D);



    @BeforeEach
    public void setUp() {
        ratingCalculator = new RatingCalculator();
    }

    @Test
    void isDecentTest() {
        //Arrange
        Forecast noWind = new Forecast(thurso, "date", "time", 1.8, 299D, 14D, 0D, 299D, 60D);
        //Act
        noWind.updateRating();
        //Assert
        assertTrue(noWind.getIsDecent());
    }

    @Test
    void tooWindyTest() {
        Forecast tooWindy = new Forecast(thurso, "date", "time", 1.8, 299D, 14D, 50D, 299D, 60D);
        tooWindy.updateRating();
        assertFalse(tooWindy.getIsDecent());
    }

    @Test
    void tooWindyOnshoreTest() {
        Forecast tooWindyOnshore = new Forecast(thurso, "date", "time", 1.8, 299D, 14D, 21D, 299D, 30D);
        tooWindyOnshore.updateRating();
        assertFalse(tooWindyOnshore.getIsDecent());
    }

    @Test
    void tooWindyOffshoreTest() {
        Forecast tooWindyOffshore = new Forecast(thurso, "date", "time", 1.8, 299D, 14D, 36D, 120D, 60D);
        tooWindyOffshore.updateRating();
        assertFalse(tooWindyOffshore.getIsDecent());
    }

    @Test
    public void tooBigTest() {
        Forecast tooBig = new Forecast(thurso, "date", "time", 3.2, 299D, 14D, 0D, 299D, 0D);
        tooBig.updateRating();
        assertFalse(tooBig.getIsDecent());
    }

    @Test
    void tooSmallTest() {
        Forecast tooSmall = new Forecast(thurso, "date", "time", 0.3, 299D, 14D, 0D, 299D, 0D);
        tooSmall.updateRating();
        assertFalse(tooSmall.getIsDecent());
    }


    @Test
            void notHittingTest() {
        Forecast notHitting = new Forecast(dunbar, "date", "time", 1.8, 120D, 14D, 0D, 299D, 00D);
        notHitting.updateRating();
        assertFalse(notHitting.getIsDecent());
    }
  @Test
            void notHittingTest2() {
        Forecast notHitting = new Forecast(dunbar, "date", "time", 1.8, 285D, 14D, 0D, 299D, 00D);
        notHitting.updateRating();
        assertFalse(notHitting.getIsDecent());
    }
  @Test
            void notHittingTest3() {
        Forecast notHitting = new Forecast(dunbar, "date", "time", 1.8, 165D, 14D, 0D, 299D, 00D);
        notHitting.updateRating();
        assertFalse(notHitting.getIsDecent());
    }

     @Test
             public void periodTooShortTest(){
        Forecast periodTooShort = new Forecast(thurso, "date", "time", 1.8, 299D, 6D, 0D, 299D, 0D);
        periodTooShort.updateRating();
        assertFalse(periodTooShort.getIsDecent());
     }
}

