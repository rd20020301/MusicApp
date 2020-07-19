package uz.include.musicapp;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class PopActivity extends AppCompatActivity implements ListView.OnItemClickListener {



    @Override
    protected void onCreate(Bundle saqlash) {
        super.onCreate(saqlash);
        setContentView(R.layout.play_list);
        ListView kurinish = (ListView) findViewById(R.id.ruyxat);


        ArrayList<Music> musics = new ArrayList<>();

        musics.add(new Music("One Direction",
                "One thing",R.raw.song));

        musics.add(new Music("Beyonce",
                "I was here",R.raw.song));

        musics.add(new Music("Katy Perry",
                "Dark Horse",R.raw.song));

        musics.add(new Music("Taylor Swift ",
                "I believe ",R.raw.song));

        musics.add(new Music("Justin Timberlake",
                "I can`t stop",R.raw.song));

        MusicsSet sets = new MusicsSet(this, musics);
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
