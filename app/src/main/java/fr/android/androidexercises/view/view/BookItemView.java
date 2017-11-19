package fr.android.androidexercises.view.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import fr.android.androidexercises.R;
import fr.android.androidexercises.model.Book;

/**
 * Created by senez on 11/19/2017.
 */

public class BookItemView extends LinearLayout {

    private TextView titleTextView;
    private TextView priceTextView;
    private ImageView coverImageView;

    public BookItemView(Context context) {
        super(context);
    }

    public BookItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BookItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        titleTextView = findViewById(R.id.titleTextView);
        priceTextView = findViewById(R.id.priceTextView);
        coverImageView = findViewById(R.id.coverImageView);
    }

    public void bindView(Book book){
        titleTextView.setText(book.getTitle());
        priceTextView.setText(String.format("%s €", book.getPrice()));

        Glide.with(this)
                .load(book.getCover())
                .into(coverImageView);
    }
}
