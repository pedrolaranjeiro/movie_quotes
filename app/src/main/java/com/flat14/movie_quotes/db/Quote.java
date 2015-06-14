package com.flat14.movie_quotes.db;

import android.os.Parcel;
import android.os.Parcelable;

public class Quote implements Parcelable {

    public static final String KEY = Quote.class.getSimpleName()+"key";

    public final String quote;
    public final String author;
    public final String movieTitle;

    public Quote(String quote, String author, String movieTitle) {
        this.quote = quote;
        this.author = author;
        this.movieTitle = movieTitle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(quote);
        parcel.writeString(author);
        parcel.writeString(movieTitle);
    }

    public Quote(Parcel in)
    {
        quote = in.readString();
        author = in.readString();
        movieTitle = in.readString();
    }

    public static final Parcelable.Creator<Quote> CREATOR = new Parcelable.Creator<Quote>() {
        public Quote createFromParcel(Parcel in) {
            return new Quote(in);
        }

        public Quote[] newArray(int size) {
            return new Quote[size];
        }
    };

}
