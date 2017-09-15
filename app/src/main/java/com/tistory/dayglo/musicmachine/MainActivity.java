package com.tistory.dayglo.musicmachine;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // what is the difference between getName() and getSimpleName()? - solved.
    private static final String TAG = MainActivity.class.getName();
    private Button mDownloadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // to make thread just one time.
        final DownloadThread thread = new DownloadThread();
        thread.setName("Download thread");
        thread.start();

        mDownloadButton = (Button) findViewById(R.id.download_btn);

        mDownloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Downloading", Toast.LENGTH_SHORT).show();

                // send messages to handler for processing
                for (String song : Playlist.songs) {
                    Message message = Message.obtain();
                    message.obj = song;
                    thread.mHandler.sendMessage(message);
                }
            }
        });
    }
}
