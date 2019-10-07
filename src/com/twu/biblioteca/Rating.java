package com.twu.biblioteca;

public class Rating {

    private int rating;

    public Rating(int rating) throws IllegalArgumentException{

        if (rating < 1 || rating > 10){
            throw new IllegalArgumentException("rating has to be between 1 and 10");
        }
        this.rating = rating;
    }

    public int getRating(){
        return rating;
    }
}
