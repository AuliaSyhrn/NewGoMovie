package com.example.gomovie.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gomovie.R;
import com.example.gomovie.model.Result;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    String title, overview, image;
    ImageView imgDetail;
    TextView tvTitle, tvDeatail;
    Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        tvTitle = findViewById(R.id.tvDetailTitle);
        tvDeatail = findViewById(R.id.tvDetailDeskription);
        imgDetail = findViewById(R.id.imgDetailMovie);

        result = getIntent().getParcelableExtra(EXTRA_MOVIE);

        title = result.getOriginalTitle();
        overview = result.getOverview();
        image = result.getPosterPath();

        tvTitle.setText(title);
        tvDeatail.setText(overview);

        Glide.with(getApplicationContext())
                .load("https://image.tmdb.org/t/p/w185" + image)
                .into(imgDetail);

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}