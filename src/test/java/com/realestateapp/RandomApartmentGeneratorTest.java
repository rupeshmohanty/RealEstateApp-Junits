package com.realestateapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

import java.math.BigDecimal;

public class RandomApartmentGeneratorTest {

    @RepeatedTest(value = 10)
    void should_GenerateCorrectApartment_When_DefaultMinAreaMinPrice() {
        // given
        RandomApartmentGenerator randomApartmentGenerator = new RandomApartmentGenerator();

        // when
        Apartment apartment = randomApartmentGenerator.generate();

        // then
        Assertions.assertNotNull(apartment);
    }

    @RepeatedTest(value = 10)
    void should_GenerateCorrectApartment_When_CustomMinAreaMinPrice() {
        // given
        RandomApartmentGenerator randomApartmentGenerator = new RandomApartmentGenerator(40, new BigDecimal(4000.0));

        // when
        Apartment apartment = randomApartmentGenerator.generate();

        // then
        Assertions.assertNotNull(apartment);
    }

}
