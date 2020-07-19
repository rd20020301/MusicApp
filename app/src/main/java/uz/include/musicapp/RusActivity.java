package uz.include.musicapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class RusActivity extends AppCompatActivity implements ListView.OnItemClickListener {



    @Override
    protected void onCreate(Bundle saqlash) {
        super.onCreate(saqlash);
        setContentView(R.layout.play_list);

        ListView kurinish = (ListView) findViewById(R.id.ruyxat);

        ArrayList<Music> musics = new ArrayList<>();

        musics.add(new Music("Sergey Lazerov",
                "Eto vsyo ona",R.raw.song));

        musics.add(new Music("Jamala",
                "1944 (Eurovision 2014)",R.raw.song));

        musics.add(new Music("Maksim",
                "Ya tebya toje lyublyu",R.raw.song));

        musics.add(new Music("Dima Bilan",
                "Derji, derji",R.raw.song));

        musics.add(new Music("Anna Pugachova",
                "Million, million",R.raw.song));


        MusicsSet sets = new MusicsSet(this, musics);

        kurinish.setAdapter(sets);

        kurinish.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> adaV, View view, int munozora, long id) {
        Music cMusic = (Music) adaV.getItemAtPosition(munozora);

        Intent musiqalar = new Intent(this,
                QushiqActivity.class);

        String musicFP = cMusic.IsmOfMusic();

        String artistFP = cMusic.IsmOfArtist();

        musiqalar.putExtra("music",
                musicFP);
        musiqalar.putExtra("artist",
                artistFP);
        int musicIdFP = cMusic.getMediaPlayeresourceId();
        musiqalar.putExtra("selectedMp3", musicIdFP);
        startActivity(musiqalar);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}