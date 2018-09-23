package com.mantey.musicalstructureapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Song implements Parcelable {
    public static final String SONG_PARCEL_DATA = "SONG_DATA_PARCEL_KEY";
    private String songName;
    private String artistName;
    private int musicImage;

    public Song(String songName, String artistName, int musicImage) {
        this.songName = songName;
        this.artistName = artistName;
        this.musicImage = musicImage;
    }

    private Song(Parcel in) {
        songName = in.readString();
        artistName = in.readString();
        musicImage = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(songName);
        dest.writeString(artistName);
        dest.writeInt(musicImage);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

    public String getSongName() {
        return songName;
    }


    public String getArtistName() {
        return artistName;
    }

    public int getMusicImage() {
        return musicImage;
    }

}
