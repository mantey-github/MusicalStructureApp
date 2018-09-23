package com.mantey.musicalstructureapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mantey.musicalstructureapp.R;
import com.mantey.musicalstructureapp.activity.SongInfoActivity;
import com.mantey.musicalstructureapp.model.Song;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {
    private Context context;

    public SongAdapter(@NonNull Context context, @NonNull ArrayList<Song> songs) {
        super(context, 0, songs);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.song_list_item, parent, false);
        }

        final Song currentSong = getItem(position);
        TextView songNameTextView = (TextView) listItemView.findViewById(R.id.song_name);
        TextView artistNameTextView = (TextView) listItemView.findViewById(R.id.artist_name);
        ImageView musicImageView = (ImageView) listItemView.findViewById(R.id.music_default_image);
        RelativeLayout moreLayout = (RelativeLayout) listItemView.findViewById(R.id.more_layout);

        if (currentSong != null) {
            songNameTextView.setText(currentSong.getSongName());
            artistNameTextView.setText(currentSong.getArtistName());
            musicImageView.setImageResource(currentSong.getMusicImage());

            moreLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, SongInfoActivity.class);
                    intent.putExtra(Song.SONG_PARCEL_DATA, currentSong);
                    context.startActivity(intent);
                }
            });
        }


        return listItemView;
    }
}
