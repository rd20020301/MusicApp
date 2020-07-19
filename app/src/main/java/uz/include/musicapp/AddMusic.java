package uz.include.musicapp;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;


public class AddMusic extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private TextView textView;
    private Intent myFilesIntent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_music);

        button = findViewById(R.id.upload_music);

        button.setOnClickListener(this);
    }

    public void onClick(View view) {
        Toast.makeText(this,"Error!",Toast.LENGTH_SHORT).show();
        myFilesIntent = new Intent(Intent.ACTION_GET_CONTENT);
        myFilesIntent.setType("audio/*");
        startActivityForResult(myFilesIntent, 10);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK) {
                    String path = data.getData().getPath();
                    textView.setText(path);
                    break;
                }
                super.onActivityResult(requestCode, resultCode, data);
        }
    }
}