package com.mantey.musicalstructureapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.mantey.musicalstructureapp.R;
import com.mantey.musicalstructureapp.model.Song;

public class SongInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_info);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView songName = findViewById(R.id.song_name);
        TextView artistName = findViewById(R.id.artist_name);

        if (getIntent().getExtras() != null) {
            Song song = (Song) getIntent().getParcelableExtra(Song.SONG_PARCEL_DATA);

            songName.setText(song.getSongName());
            artistName.setText(song.getArtistName());
        }

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
