package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieList {

    private static ArrayList<Movie> movieList = new ArrayList<Movie>();

    public static void MovieList(){
        movieList.add(new Movie("Movie1", "1990", "director", new Rating(3)));
        movieList.add(new Movie("Movie2", "1990", "director", new Rating(9)));
        movieList.add(new Movie("Movie3", "1990", "director", new Rating(1)));
        movieList.add(new Movie("Movie4", "1990", "director", null));
    }

    public static ArrayList<Movie> getMovieList(){
        return movieList;
    }
}
