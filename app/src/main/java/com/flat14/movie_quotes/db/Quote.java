package com.flat14.movie_quotes.db;

public class Quote {

    public final String quote;
    public final String author;
    public final String movieTitle;

    public Quote(String quote, String author, String movieTitle) {
        this.quote = quote;
        this.author = author;
        this.movieTitle = movieTitle;
    }

}
