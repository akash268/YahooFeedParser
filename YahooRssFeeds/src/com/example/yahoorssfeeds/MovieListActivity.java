package com.example.yahoorssfeeds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.utils.FetchFeedAsync;

public class MovieListActivity extends FragmentActivity
        implements MovieListFragment.Callbacks {

    private boolean mTwoPane;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
       new FetchFeedAsync().execute("");
        if (findViewById(R.id.movie_detail_container) != null) {
            mTwoPane = true;
            ((MovieListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.movie_list))
                    .setActivateOnItemClick(true);
        }
    }

    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            Bundle arguments = new Bundle();
            arguments.putString(MovieDetailFragment.ARG_ITEM_ID, id);
            MovieDetailFragment fragment = new MovieDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.movie_detail_container, fragment)
                    .commit();

        } else {
            Intent detailIntent = new Intent(this, MovieDetailActivity.class);
            detailIntent.putExtra(MovieDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }
}
