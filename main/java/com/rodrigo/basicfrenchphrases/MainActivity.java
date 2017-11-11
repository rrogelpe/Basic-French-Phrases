package com.rodrigo.basicfrenchphrases;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    int[] audioFileArray = new int[]{R.raw.doyouspeakenglish, R.raw.goodevening, R.raw.hello, R.raw.howareyou,
                                   R.raw.ilivein, R.raw.mynameis, R.raw.please, R.raw.welcome};

    String[] fileNameArray = new String[]{"Do you speak English?", "Good evening", "Hello", "How are you",
                                          "I live in", "My name is", "Please", "Welcome"};

    public void translate(View view){
        // There are two ways to play sound...
        /*******************************************/
        //First approach is to set tags to equal the index of the matching element. When button is clicked the array will be indexed at the
        //button's tag and play respective sound.
        Button button = (Button) view;
        String tag = button.getTag().toString();
        mediaPlayer = MediaPlayer.create(this, audioFileArray[Integer.parseInt(tag)]);

        /*******************************************/
        //Second approach is to set element's id to the audio file name and do the following...
        /*String id = view.getResources().getResourceEntryName(view.getId());
        int resourceID = getResources().getIdentifier(id,"raw","com.rodrigo.basicfrenchphrases");
        mediaPlayer = MediaPlayer.create(this, resourceID);
        */
        mediaPlayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout grid = (GridLayout) findViewById(R.id.grid);

        for (int i=0; i<grid.getChildCount(); i++){

            ((Button) grid.getChildAt(i)).setText(fileNameArray[i]);
            ((Button) grid.getChildAt(i)).setMaxWidth(grid.getWidth()/2);
            Log.i ("id", fileNameArray[i]);
        }
    }
}
