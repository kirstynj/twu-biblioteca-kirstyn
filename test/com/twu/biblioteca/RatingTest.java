package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class RatingTest {

    @Test (expected = IllegalArgumentException.class)
    public void TestCorrectRating(){
        Rating testRating = new Rating(12);
    }

}