package com.realestateapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentRaterTest {
    @ParameterizedTest
    @CsvSource({"800, 300.0", "1000, 400.0", "600, 200.0"})
    void should_ReturnCorrectRating_When_CorrectApartment(Double area, Double price) {
        // given
        Apartment apartment = new Apartment(area, new BigDecimal(price));

        // when
        int rating = ApartmentRater.rateApartment(apartment);

        // then
        assertEquals(0, rating);
    }

    @ParameterizedTest
    @CsvSource({"0, 0.0"})
    void should_ReturnErrorValue_When_IncorrectApartment(Double area, Double price) {
        // given
        Apartment apartment = new Apartment(area, new BigDecimal(price));

        // when
        int rating = ApartmentRater.rateApartment(apartment);

        // then
        assertEquals(-1, rating);
    }

    @Test
    void should_CalculateAverageRating_When_CorrectApartmentList() {
        // given
        List<Apartment> apartmentList = new ArrayList<>();
        apartmentList.add(new Apartment(1000, new BigDecimal(6000000.0)));
        apartmentList.add(new Apartment(2000, new BigDecimal(7000000.0)));
        apartmentList.add(new Apartment(3000, new BigDecimal(5000000.0)));

        // when
        double avgRating = ApartmentRater.calculateAverageRating(apartmentList);

        // then
        assertEquals(0.3333333333333333, avgRating);
    }

    @Test
    void should_ThrowExceptionInCalculateAverageRating_When_EmptyApartmentList() {
        // given
        List<Apartment> apartmentList = new ArrayList<>();

        // when
        Executable executable = () -> ApartmentRater.calculateAverageRating(apartmentList);

        // then
        assertThrows(RuntimeException.class, executable);
    }
}