package com.twu.biblioteca;

public class Movie{

    private String name;
    private String year;
    private String director;
    private Rating rating;

    public Movie(String name, String year, String director, Rating rating){
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getTitle(){
        return name;
    }
    public String getYear(){
        return year;
    }
    public String getDirector(){
        return director;
    }
    public Rating getRating(){
        return rating;
    }

    public String toString(){
        String ratingString;
        if (rating == null){
            ratingString = "No Rating";
        }
        else {
            ratingString = Integer.toString(rating.getRating());
        }
        return name +" "+ year +" "+ director +" "+ ratingString +"\n";
    }
}
