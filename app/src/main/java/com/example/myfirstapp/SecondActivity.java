package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    TextView taskTextView;
    TextView scoreTextView;

    Button lessButton;
    Button equalButton;
    Button biggerButton;

    int max = 10;
    int min = 1;

    int answer;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        taskTextView = findViewById(R.id.taskTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        lessButton = findViewById(R.id.lessButton);
        equalButton = findViewById(R.id.equalButton);
        biggerButton = findViewById(R.id.moreButton);

        lessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(-1);
            }
        });
        equalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(0);
            }
        });
        biggerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(1);
            }
        });

        this.setTask();
    }

    private void checkAnswer(int answer) {
        if (answer == this.answer) {
            this.score = this.score + 1;
        } else {
            this.score = this.score - 1;
        }
        System.out.println(this.score);
        this.scoreTextView.setText("Score: " + this.score);
        this.setTask();
    }

    private void setTask() {
        Double a = this.getRandom();
        Double b = this.getRandom();
        this.answer = a.compareTo(b);
        this.taskTextView.setText(Math.round(a) + " ? " + Math.round(b));
    }

    private Double getRandom() {
        Random r = new Random();
        return (double) r.nextInt(max - min) + min;
    }
}
