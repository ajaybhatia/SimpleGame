package com.ajaybhatia.simplegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultTextView = (TextView) findViewById(R.id.textView);

        Intent intent = getIntent();
        String result = intent.getStringExtra("result");

        resultTextView.setText(result);
    }
}
