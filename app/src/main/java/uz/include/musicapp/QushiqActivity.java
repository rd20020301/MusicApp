package uz.include.musicapp;


import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class QushiqActivity extends AppCompatActivity{
    public MediaPlayer mediaPlayer;
    private ImageView playb1,pauseb1,stopb1;
    private SeekBar seekBar;
    private Runnable runnable;
    private int c=0;
    private Handler handler;
    public void playing() {
        Intent musicIntent = getIntent();

        String musicForPlay = musicIntent.getStringExtra("music");

        TextView musicTextView = findViewById(R.id.music_nom);

        musicTextView.setText(musicForPlay);

        String artistForPlay = musicIntent.getStringExtra("artist");

        TextView artistTextView = findViewById(R.id.music_artist);

        artistTextView.setText(artistForPlay);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player);
        handler=new Handler();
        seekBar=findViewById(R.id.seekbar);
        playb1=findViewById(R.id.playb);
        pauseb1=findViewById(R.id.pauseb);
        stopb1=findViewById(R.id.stopb);
        int musicIdFP=getIntent().getIntExtra("selectedMp3",-1);
        mediaPlayer=MediaPlayer.create(this,musicIdFP);
        mediaPlayer.start();

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBar.setMax(mediaPlayer.getDuration());
                ChangeSeekBar();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b){
                    mediaPlayer.seekTo(i);

                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        playing();

        playb1.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v) {
        mediaPlayer.start();
        }
        });
        pauseb1.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
        mediaPlayer.pause();
        }
        });
        stopb1.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
        mediaPlayer.stop();
        }
        });

    }
    private void ChangeSeekBar() {
        seekBar.setProgress(mediaPlayer.getCurrentPosition());
        if(mediaPlayer.isPlaying()){
            runnable=new Runnable() {
                @Override
                public void run() {
                    ChangeSeekBar();
                }
            };
            handler.postDelayed(runnable,1000);
        }
    }
}


