package org.schoolbaltimoreEL;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    // 1. Declare variables
    TextView questionTV;
    Button trueBTN, falseBTN, submitBTN;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. Initialize Views
        questionTV = findViewById(R.id.questionTV);
        trueBTN = findViewById(R.id.True);
        falseBTN = findViewById(R.id.False);
        submitBTN = findViewById(R.id.submitBTN);

        // Logic for True Button
        trueBTN.setOnClickListener(v -> {
            score = 10; // Earth goes around the Sun is True
            trueBTN.setBackgroundColor(ContextCompat.getColor(this, R.color.lime));
            falseBTN.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        });

        // Logic for False Button
        falseBTN.setOnClickListener(v -> {
            score = 0;
            falseBTN.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
            trueBTN.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        });

        // SUBMIT BUTTON - Navigate to ScoreActivity
        submitBTN.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
            intent.putExtra("USER_SCORE", score);
            startActivity(intent);
        });
    }
}
