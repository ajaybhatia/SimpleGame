package com.ajaybhatia.simplegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static TextView randomNumberTextView;
    private static TextView randomResultTextView;
    private static EditText inputEditText;
    private String mResult;

    private static String random() {
        Random rand = new Random();
        return String.valueOf(rand.nextInt(100));
    }

    private static String result() {
        int x = Integer.parseInt(randomNumberTextView.getText().toString());
        int y = Integer.parseInt(inputEditText.getText().toString());
        int z = Integer.parseInt(randomResultTextView.getText().toString());

        return x+y == z ? "You Win!" : "You Lose!";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomNumberTextView = (TextView) findViewById(R.id.randomNumberTextView);
        randomResultTextView = (TextView) findViewById(R.id.randomResultTextView);
        inputEditText = (EditText) findViewById(R.id.guessNumberEditText);

        initComponents();
    }

    private static void initComponents() {
        randomNumberTextView.setText(random());
        randomResultTextView.setText(random());
    }

    public void submit(View view) {
        mResult = result();

        // Clear EditText
        inputEditText.setText("");

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("result", mResult);

        startActivity(intent);
    }

    public void refresh(View view) {
        initComponents();
    }
}
