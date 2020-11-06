package com.kmt.party.utils;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

public class MusicPlayerUtils {
    public static MediaPlayer mediaPlayer = null;

    public static void playSound(final Context context, final String fileName) {
        mediaPlayer = new MediaPlayer();
        try {
            AssetFileDescriptor afd = context.getAssets().openFd(fileName);
            mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            mediaPlayer.setLooping(true);
            afd.close();
            mediaPlayer.prepare();
        } catch (final Exception e) {
            e.printStackTrace();
        }
        mediaPlayer.start();
    }

    public static void stopSound() {
        if (mediaPlayer != null)
            mediaPlayer.stop();
    }

}
