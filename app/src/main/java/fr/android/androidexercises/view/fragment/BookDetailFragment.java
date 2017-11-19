package fr.android.androidexercises.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import fr.android.androidexercises.R;
import fr.android.androidexercises.model.Book;
import fr.android.androidexercises.util.LibraryUtils;


/**
 * Created by senez on 11/19/2017.
 */

public class BookDetailFragment extends Fragment {

    private Book selectedBook;

    private TextView titleTextView;
    private TextView priceTextView;
    private TextView isbnTextView;
    private TextView synopsisTextView;

    private ImageView coverImageView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book_detail_fragment, container, false);

        selectedBook = getArguments().getParcelable(LibraryUtils.BOOK_KEY);

        titleTextView = view.findViewById(R.id.titleTextView);
        priceTextView = view.findViewById(R.id.priceTextView);
        isbnTextView = view.findViewById(R.id.isbnTextView);
        synopsisTextView = view.findViewById(R.id.synopsisTextView);

        coverImageView = view.findViewById(R.id.coverImageView);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(selectedBook != null){
            titleTextView.setText(selectedBook.getTitle());
            priceTextView.setText(String.format("%s €", selectedBook.getPrice()));
            isbnTextView.setText(String.format("Isbn : %s", selectedBook.getIsbn()));
            synopsisTextView.setText(selectedBook.getSynopsisToDisplay());

            Glide.with(view.getContext())
                    .load(selectedBook.getCover())
                    .into(coverImageView);
        } else {
            // Clearing page because no book has been chosen
            coverImageView.setImageResource(0);
            titleTextView.setText("");
            priceTextView.setText("");
            isbnTextView.setText("");

            synopsisTextView.setText(R.string.no_book_selected);
        }
    }
}
