package com.prathameshmore.texttospeech;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener,View.OnClickListener
{

    private Button speakBtn;
    private EditText inputText;
    String text;
    int res;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        speakBtn = (Button) findViewById(R.id.speakBtn);
        inputText = (EditText) findViewById(R.id.inputText);
        speakBtn.setOnClickListener(this);

        textToSpeech = new TextToSpeech(this,this);

    }

    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS)
        {
            res = textToSpeech.setLanguage(Locale.US);

        }

    }

    @Override
    public void onClick(View v) {

        if (res == TextToSpeech.LANG_MISSING_DATA || res == TextToSpeech.LANG_NOT_SUPPORTED)
        {
            Toast.makeText(this, "Language is not supported", Toast.LENGTH_SHORT).show();
        }
        else
        {
            text = inputText.getText().toString();
            Toast.makeText(this, "Speaking...", Toast.LENGTH_SHORT).show();
            textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
        }
    }
}
