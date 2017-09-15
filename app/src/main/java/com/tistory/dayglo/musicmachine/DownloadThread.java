package com.tistory.dayglo.musicmachine;

import android.os.Looper;
import android.util.Log;

import static java.lang.System.in;

/**
 * Created by user on 2017-09-14.
 */

public class DownloadThread extends Thread{
    private static final String TAG = DownloadThread.class.getSimpleName();
    public DownloadHandler mHandler;

    @Override
    public void run() {
        Looper.prepare();
        mHandler = new DownloadHandler();
        Looper.loop();
    }

}
