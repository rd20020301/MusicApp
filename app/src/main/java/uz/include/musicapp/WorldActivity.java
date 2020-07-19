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

public class WorldActivity
        extends AppCompatActivity
        implements ListView.OnItemClickListener
{

    @Override
    protected void onCreate(Bundle saqlash) {
        super.onCreate(saqlash);
        setContentView(R.layout.play_list);

        ArrayList<Music> musics = new ArrayList<>();

        ListView kurinish = (ListView) findViewById(R.id.ruyxat);

        musics.add(new Music("Alvaro Solar",
                "Loca, loca",R.raw.song));

        musics.add(new Music("Maluma",
                "Maluma Baby",R.raw.song));

        musics.add(new Music("Tom Holland",
                "Ompossible",R.raw.song));

        musics.add(new Music("Alan Walker",
                "Alone (remix)",R.raw.song));

        musics.add(new Music("K-391",
                "Summertime (remix)",R.raw.song));

        MusicsSet sets = new MusicsSet(this,
                musics);


        kurinish.setOnItemClickListener(this);
        kurinish.setAdapter(sets);

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