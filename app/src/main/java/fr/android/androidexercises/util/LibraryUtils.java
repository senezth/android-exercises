package fr.android.androidexercises.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by senez on 11/19/2017.
 */

public class LibraryUtils {

    private static final String URL = "http://henri-potier.xebia.fr/";

    public static final String BOOK_KEY = "BOOK";
    public static final String BOOKS_KEY = "BOOKS";

    public static Retrofit buildRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
