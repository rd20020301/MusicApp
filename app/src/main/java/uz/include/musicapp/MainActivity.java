package uz.include.musicapp;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // O`zbekcha musiqalar qatori
        final TextView uzbekbtn = (TextView) findViewById(R.id.uzbek_music);

        uzbekbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent classicalIntent = new Intent(MainActivity.this, UzbekActivity.class);
                startActivity(classicalIntent);
            }
        });


        // Rus musiqalar qatori
        final TextView rusbtn = (TextView) findViewById(R.id.rus_music);

        rusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent classicalIntent = new Intent(MainActivity.this, RusActivity.class);
                startActivity(classicalIntent);
            }
        });


        // jahon musiqasi qatori
        final TextView worldbtn = (TextView) findViewById(R.id.world_music);

        worldbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent classicalIntent = new Intent(MainActivity.this, WorldActivity.class);
                startActivity(classicalIntent);
            }
        });

        final TextView popbtn = (TextView) findViewById(R.id.pop_music);

        popbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent classicalIntent = new Intent(MainActivity.this, PopActivity.class);
                startActivity(classicalIntent);
            }
        });

        final Button addbtn = (Button) findViewById(R.id.add_music);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent classicalIntent = new Intent(MainActivity.this, AddMusic.class);
                startActivity(classicalIntent);
            }
        });
    }

}