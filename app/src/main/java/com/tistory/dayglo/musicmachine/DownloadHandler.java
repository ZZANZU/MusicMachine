package com.tistory.dayglo.musicmachine;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * Created by user on 2017-09-14.
 */

public class DownloadHandler extends Handler {
    private static final String TAG = DownloadHandler.class.getSimpleName();

    @Override
    public void handleMessage(Message msg) {
        downloadSong(msg.obj.toString());
    }

    private void downloadSong(String song) {
        long endTime = System.currentTimeMillis() + 10*1000; // adding 10 seconds to the current time

        while(System.currentTimeMillis() < endTime) {
            try {
                DownloadThread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, song + " downloaded!");
    }
}
