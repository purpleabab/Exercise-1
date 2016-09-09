package com.matc.entity;

import javax.ejb.Local;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


/**
 * A class to represent a user.
 *
 * @author pwaite
 */
public class User {
    private String firstName;
    private String lastName;
    private String userid;
    private LocalDate dateOfBirth;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName   the first name
     * @param lastName    the last name
     * @param userid      the userid
     * @param dateOfBirth the birthdate
     */
    public User(String firstName, String lastName, String userid, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userid = userid;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets birth date
     *
     * @return the birth date
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }


    /**
     * Sets birth date
     *
     * @return the birth date
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

//    /**
//     * nicer method, as of 9/7/16
//     */
//    public int calculateAge() {
//        if (dateOfBirth != null) {
//            return Period.between(dateOfBirth, LocalDate.now()).getYears();
//        } else {
//            return 0;
//        }
//    }

    /**
     * Calculates age
     *
     * @return the age
     */
    public int getAge() {
        if (dateOfBirth != null) {
            return Period.between(dateOfBirth, LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets userid.
     *
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Sets userid.
     *
     * @param userid the userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }


    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userid='" + userid + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", age='" + this.getAge() + '\'' +
                '}';
    }


}
