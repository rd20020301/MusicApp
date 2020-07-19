package uz.include.musicapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

public class UzbekActivity extends AppCompatActivity implements ListView.OnItemClickListener {
    private MediaPlayer mediaPlayer;
    private int musicIdFX;
    private int c=0;

    public void onCreate(Bundle saqlash) {
        super.onCreate(saqlash);
        setContentView(R.layout.play_list);

        final ArrayList<Music> musics = new ArrayList<>();

        ListView kurinish = (ListView)
                findViewById(R.id.ruyxat);

        musics.add(new Music("Rayhon",
                "Sevgingni menga ayt", R.raw.song));

        musics.add(new Music("Munisa Rizayeva",
                "Jonim dilozorim", R.raw.song));

        musics.add(new Music("Jasur Umirov",
                "Jamila, Jamila, Muhabbat", R.raw.song));

        musics.add(new Music("Alisher Fayz",
                "Rashk qilasan ", R.raw.song));

        musics.add(new Music("Otabek",
                "Vatanim mani O`zbekiston", R.raw.song));

        MusicsSet sets = new MusicsSet(this, musics);
        kurinish.setAdapter(sets);
        kurinish.setOnItemClickListener(this);
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onItemClick(AdapterView<?> adaV, View view, int munozora, long id) {
        Music cMusic = (Music) adaV.getItemAtPosition(munozora);
        Intent musiqalar = new Intent(this, QushiqActivity.class);
        String musicFP = cMusic.IsmOfMusic();

        String artistFP = cMusic.IsmOfArtist();

        int musicIdFP = cMusic.getMediaPlayeresourceId();

        musiqalar.putExtra("music",
                musicFP);

        musiqalar.putExtra("artist",
                artistFP);

        musiqalar.putExtra("selectedMp3",musicIdFP);

        startActivity(musiqalar);
    }
}

