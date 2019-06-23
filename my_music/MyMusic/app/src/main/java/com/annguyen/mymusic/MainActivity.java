package com.annguyen.mymusic;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button1, button2, button3;
    MediaPlayer mpBruno, mpIssues, mpPanic;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        button1 = (Button)findViewById(R.id.btnBruno);
        button2 = (Button)findViewById(R.id.btnIssues);
        button3 = (Button)findViewById(R.id.btnPanic);

        button1.setOnClickListener(bBruno);
        button2.setOnClickListener(bIssues);
        button3.setOnClickListener(bPanic);

        //media player statements
        mpBruno = new MediaPlayer();
        mpBruno = MediaPlayer.create(this, R.raw.bruno);
        mpIssues = new MediaPlayer();
        mpIssues = MediaPlayer.create(this, R.raw.issues);
        mpPanic = new MediaPlayer();
        mpPanic = MediaPlayer.create(this, R.raw.panic);
        playing = 0;
    }

    //first button
    Button.OnClickListener bBruno = new Button.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            switch(playing){
                //plays music
                case 0:
                    mpBruno.start();
                    playing = 1;
                    button1.setText("Pause Bruno Mars");
                    button2.setVisibility(View.INVISIBLE);
                    button3.setVisibility(View.INVISIBLE);
                    break;
                //pauses music
                case 1:
                    mpBruno.pause();
                    playing = 0;
                    button1.setText("Play Bruno Mars");
                    button2.setVisibility(View.VISIBLE);
                    button3.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
    //second button
    Button.OnClickListener bIssues = new Button.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            switch(playing){
                //plays music
                case 0:
                    mpIssues.start();
                    playing = 1;
                    button2.setText("Pause Issues");
                    button1.setVisibility(View.INVISIBLE);
                    button3.setVisibility(View.INVISIBLE);
                    break;
                //pauses music
                case 1:
                    mpIssues.pause();
                    playing = 0;
                    button2.setText("Play Issues");
                    button1.setVisibility(View.VISIBLE);
                    button3.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
    //thrid button
    Button.OnClickListener bPanic = new Button.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            switch(playing){
                //plays music
                case 0:
                    mpPanic.start();
                    playing = 1;
                    button3.setText("Pause Panic at the Disco");
                    button2.setVisibility(View.INVISIBLE);
                    button1.setVisibility(View.INVISIBLE);
                    break;
                //pauses music
                case 1:
                    mpPanic.pause();
                    playing = 0;
                    button3.setText("Play Panic at the Disco");
                    button2.setVisibility(View.VISIBLE);
                    button1.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
}
