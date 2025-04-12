package com.example.finalprojectenglish;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class HomeFrag extends Fragment {
    private TextToSpeech tts;
    private TextView wordText;
    private ImageButton speakButton;
    private Button newWordButton;
    private int currentIndex = -1;


    public HomeFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // ربط العناصر
        wordText = view.findViewById(R.id.wordText);
        speakButton = view.findViewById(R.id.speakButton);

        // إعداد TextToSpeech
        tts = new TextToSpeech(getContext(), status -> {
            if (status == TextToSpeech.SUCCESS) {
                tts.setLanguage(Locale.ENGLISH);
            }
        });

        // عند الضغط على زر السماعة
        speakButton.setOnClickListener(v -> {
            String word = wordText.getText().toString();
            tts.speak(word, TextToSpeech.QUEUE_FLUSH, null, null);
        });
        newWordButton = view.findViewById(R.id.newWordButton);




        return view;
    }
    public void onDestroy() {
        // إيقاف tts عند تدمير الـ Fragment
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
}
