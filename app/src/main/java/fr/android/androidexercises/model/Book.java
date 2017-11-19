package fr.android.androidexercises.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by senez on 11/19/2017.
 */

public class Book implements Parcelable {

    private String title;
    private String price;
    private String cover;
    private String isbn;
    private String[] synopsis;


    private Book(Parcel in) {
        title = in.readString();
        price = in.readString();
        cover = in.readString();
        isbn = in.readString();
        synopsis = in.createStringArray();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(price);
        dest.writeString(cover);
        dest.writeString(isbn);
        dest.writeStringArray(synopsis);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String[] getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String[] synopsis) {
        this.synopsis = synopsis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }

    public String getSynopsisToDisplay(){
        StringBuilder sb = new StringBuilder();

        for (String s : synopsis) {
            sb.append(s).append("\n\n");
        }

        return sb.toString();
    }
}