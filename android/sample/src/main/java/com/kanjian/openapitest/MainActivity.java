package com.kanjian.openapitest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.kanjian.openapi.Callback;
import com.kanjian.openapi.KanjianOpenAPI;
import com.kanjian.openapi.bean.KAlbum;
import com.kanjian.openapi.bean.KArtist;
import com.kanjian.openapi.bean.KGenre;
import com.kanjian.openapi.bean.KList;
import com.kanjian.openapi.bean.KTrack;

import io.reactivex.functions.Consumer;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        KanjianOpenAPI.init(this.getApplicationContext(), "test_api", "abcdefg");

        callbackStyleExample();

//        observableStyleExample();
    }

    void callbackStyleExample() {
        KanjianOpenAPI.genres(0, 20, new Callback<KList<KGenre>>() {
            @Override
            public void onFailure(Throwable e) {

            }

            @Override
            public void onSuccess(KList<KGenre> kGenreKList) {
            }
        });

        KanjianOpenAPI.genres(0, new Callback<KList<KGenre>>() {
            @Override
            public void onFailure(Throwable throwable) {
            }

            @Override
            public void onSuccess(KList<KGenre> kGenreKList) {
            }
        });

        KanjianOpenAPI.genreAlbums(1, 0, 20, new Callback<KList<KAlbum>>() {
            @Override
            public void onFailure(Throwable e) {

            }

            @Override
            public void onSuccess(KList<KAlbum> kAlbumKList) {

            }
        });

        KanjianOpenAPI.artists(0, 10, new Callback<KList<KArtist>>() {
            @Override
            public void onFailure(Throwable e) {

            }

            @Override
            public void onSuccess(KList<KArtist> kArtistKList) {

            }
        });

        KanjianOpenAPI.genreTracks(1, 0, new Callback<KList<KTrack>>() {
            @Override
            public void onFailure(Throwable e) {

            }

            @Override
            public void onSuccess(KList<KTrack> kTrackKList) {

            }
        });
    }

    void observableStyleExample() {
        KanjianOpenAPI.genres(0).subscribe(new Consumer<KList<KGenre>>() {
            @Override
            public void accept(KList<KGenre> kGenreKList) throws Exception {

            }
        });

        KanjianOpenAPI.genres(0, 20).subscribe(new Consumer<KList<KGenre>>() {
            @Override
            public void accept(KList<KGenre> kGenreKList) throws Exception {
//                kGenreKList.data_list
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        });

        KanjianOpenAPI.genreTracks(1, 0).subscribe(new Consumer<KList<KTrack>>() {
            @Override
            public void accept(KList<KTrack> kTrackKList) throws Exception {

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        });

        KanjianOpenAPI.track(1212).subscribe(new Consumer<KTrack>() {
            @Override
            public void accept(KTrack kTrack) throws Exception {

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        });

        KanjianOpenAPI.genreAlbums(1, 0).subscribe(new Consumer<KList<KAlbum>>() {
            @Override
            public void accept(KList<KAlbum> kAlbumKList) throws Exception {

            }
        });
    }
}
