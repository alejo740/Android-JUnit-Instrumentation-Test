package com.example.appjunit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void commandClick(View view) {
        TextView myText = findViewById(R.id.myText);
        if (myText.getText().toString().isEmpty())
            myText.setText(getString(R.string.changed_text));
        else
            myText.setText("");
    }
}
