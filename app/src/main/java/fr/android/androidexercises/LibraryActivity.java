package fr.android.androidexercises;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        // Plant logger cf. Android Timber
        Timber.plant(new Timber.DebugTree());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://henri-potier.xebia.fr")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HenriPotierService service = retrofit.create(HenriPotierService.class);

        service.listBooks().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                for (Book book : response.body()){
                    Timber.d(book.getTitle());
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Timber.d(t);
            }
        });



        // TODO log books

        // TODO display book as a list
    }

}
