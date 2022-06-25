package com.app.hometuition;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import java.util.Locale;

public class TTSSingleton {
    public static TextToSpeech tts;
    public static TextToSpeech ttsUrdu;

    private TTSSingleton() {
    }

    public static TextToSpeech getInstance(Context context) {
        if (tts == null)
            tts = new TextToSpeech(context.getApplicationContext(), status -> {
                if (status == TextToSpeech.SUCCESS) {
                    int result = tts.setLanguage(Locale.US);
                } else
                    Log.e("error", "Initilization Failed!");
            });
        return tts;
    }

    public static TextToSpeech getUrduInstance(Context context) {
        if (ttsUrdu == null)
            ttsUrdu = new TextToSpeech(context, status -> {
                if (status == TextToSpeech.SUCCESS) {
                    int result = ttsUrdu.setLanguage(new Locale("ur"));
                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            });
        return ttsUrdu;
    }

}
