package fr.android.androidexercises.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import fr.android.androidexercises.R;
import fr.android.androidexercises.model.Book;
import fr.android.androidexercises.util.LibraryUtils;
import timber.log.Timber;

public class LibraryActivity extends AppCompatActivity implements BookListFragment.OnBookClickedListener {

    private Book selectedBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Timber.plant(new Timber.DebugTree());

        BookListFragment bookListFragment;

        if(savedInstanceState != null){
            // We are in book detail page
            bookListFragment = (BookListFragment) getSupportFragmentManager().findFragmentByTag(BookListFragment.class.getSimpleName());

            selectedBook = savedInstanceState.getParcelable(LibraryUtils.BOOK_KEY);

            displayBookDetail();
        } else {
            // We are in book list page
            bookListFragment = new BookListFragment();
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerFrameLayout, bookListFragment, BookListFragment.class.getSimpleName())
                .commit();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(LibraryUtils.BOOK_KEY, selectedBook);
    }


    @Override
    public void onBookClicked(Book book) {
        selectedBook = book;
        displayBookDetail();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_library, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void displayBookDetail(){
        boolean isLandscape = getResources().getBoolean(R.bool.isLandscape);

        BookDetailFragment detailFragment = new BookDetailFragment();

        Bundle bundle = new Bundle();
        bundle.putParcelable(LibraryUtils.BOOK_KEY, selectedBook);

        detailFragment.setArguments(bundle);

        if(isLandscape){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.bookDetail, detailFragment, BookDetailFragment.class.getSimpleName())
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containerFrameLayout, detailFragment, BookDetailFragment.class.getSimpleName())
                    .addToBackStack("ComingFromList")
                    .commit();
        }

    }
}