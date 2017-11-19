package fr.android.androidexercises.service;

import java.util.List;

import fr.android.androidexercises.model.Book;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by senez on 11/19/2017.
 */


public interface BookService {

    @GET("books")
    Call<List<Book>> getBooks();
}