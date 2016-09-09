package com.matc.entity;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

/**
 * Created by karen.rahmeier on 9/7/2016.
 */
public class UserTest {
    User user;

    @Before
    public void setUp() {
        System.out.println("inside setUp");
        user = new User("Test", "Lastname", "1", createLocalDateFromString("08-01-2000"));
    }

    private LocalDate createLocalDateFromString(String inputDate) {
        System.out.println("inside createLocalDateFromString");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        return LocalDate.parse(inputDate, formatter);
    }


    @Test
    public void testCalculateAge() throws Exception {
        System.out.println("inside calculator");
        assertTrue(user.getAge() == 16);
    }

    @Test
    public void testCalculateAge2() throws Exception {
        System.out.println("inside calculator2");
        int expectedValue = 15;
        User user = new User("Betty", "Boop", "2" ,createLocalDateFromString("01-01-2001"));
        assertTrue(user.getAge() == expectedValue);
    }

}