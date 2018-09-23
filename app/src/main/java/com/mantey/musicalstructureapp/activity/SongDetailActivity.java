package com.mantey.musicalstructureapp.activity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.mantey.musicalstructureapp.R;
import com.mantey.musicalstructureapp.model.Song;

public class SongDetailActivity extends AppCompatActivity {
    private Song song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);

        //Setting the back button icon on ActionBar
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView songName = findViewById(R.id.song_name);
        TextView artistName = findViewById(R.id.artist_name);
        ImageView musicImageView = findViewById(R.id.music_preview_image);

        //Check for empty extras
        if (getIntent().getExtras() != null) {
            song = (Song) getIntent().getParcelableExtra(Song.SONG_PARCEL_DATA);
            songName.setText(song.getSongName());
            artistName.setText(song.getArtistName());
            musicImageView.setImageResource(song.getMusicImage());
        }


        changeSeekBarDefaultStyle();
    }


    private void changeSeekBarDefaultStyle() {
        SeekBar seekBar = findViewById(R.id.seekbar);
        seekBar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
        seekBar.getThumb().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.music_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            case R.id.music_info:
                Intent intent = new Intent(SongDetailActivity.this, SongInfoActivity.class);
                intent.putExtra(Song.SONG_PARCEL_DATA, song);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
