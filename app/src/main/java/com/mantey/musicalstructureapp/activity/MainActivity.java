package com.mantey.musicalstructureapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mantey.musicalstructureapp.R;
import com.mantey.musicalstructureapp.model.Song;
import com.mantey.musicalstructureapp.adapter.SongAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(getString(R.string.music_library));

        //Add list of songs, artist name and album image to the song class
        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song(getString(R.string.song_name_bambi), getString(R.string.artist_name_bambi), R.drawable.bambi_image_view));
        songs.add(new Song(getString(R.string.song_name_warn_dem), getString(R.string.artist_name_shatta_wale), R.drawable.music_default_icon));
        songs.add(new Song(getString(R.string.song_name_single), getString(R.string.artist_name_kofi), R.drawable.kofi_kinaata_image_view));
        songs.add(new Song(getString(R.string.song_name_sweetio), getString(R.string.artist_name_raquel), R.drawable.music_default_icon));
        songs.add(new Song(getString(R.string.song_name_mary), getString(R.string.artist_name_sarkodie), R.drawable.sarkodie_image_view));
        songs.add(new Song(getString(R.string.song_name_akwaaba), getString(R.string.artist_name_eazi), R.drawable.akwaaba_image_view));
        songs.add(new Song(getString(R.string.song_name_abena), getString(R.string.artist_name_king), R.drawable.music_default_icon));
        songs.add(new Song(getString(R.string.song_name_vibe), getString(R.string.artist_name_r2bees), R.drawable.music_default_icon));
        songs.add(new Song(getString(R.string.song_name_woara), getString(R.string.artist_name_king), R.drawable.music_default_icon));
        songs.add(new Song(getString(R.string.song_name_do), getString(R.string.artist_name_eddie), R.drawable.music_default_icon));
        songs.add(new Song(getString(R.string.song_name_uber), getString(R.string.artist_name_wendy), R.drawable.uber_driver_image_view));
        songs.add(new Song(getString(R.string.song_name_me_ne_woa), getString(R.string.artist_name_manifest), R.drawable.music_default_icon));
        songs.add(new Song(getString(R.string.song_name_hold_on), getString(R.string.artist_name_sir_kolby), R.drawable.music_default_icon));

        SongAdapter adapter = new SongAdapter(this, songs);

        //Get the list view and set the adapter
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        //Clicking each list item to open song details
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song song = (Song) parent.getItemAtPosition(position);

                Intent intent = new Intent(MainActivity.this, SongDetailActivity.class);
                intent.putExtra(Song.SONG_PARCEL_DATA, song);
                startActivity(intent);
            }
        });


        //Current song played, view
        RelativeLayout playButtonLayout = findViewById(R.id.play_button_layout);
        playButtonLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Song song = new Song(getString(R.string.song_name_dont_follow_me), getString(R.string.artist_name_manifest), R.drawable.daytime_fashion_human_1373085);

                Intent intent = new Intent(MainActivity.this, SongDetailActivity.class);
                intent.putExtra(Song.SONG_PARCEL_DATA, song);
                startActivity(intent);
            }
        });
    }
}
