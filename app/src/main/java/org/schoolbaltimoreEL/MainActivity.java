package org.schoolbaltimoreEL;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_SCORE = "USER_SCORE";

    int score = 0;
    String answer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button trueBTN = findViewById(R.id.True);
        Button falseBTN = findViewById(R.id.False);
        Button submitBTN = findViewById(R.id.submitBTN);

        trueBTN.setOnClickListener(v -> {
            answer = "True";
            Toast.makeText(this, "You Are Right!", Toast.LENGTH_SHORT).show();
        });

        falseBTN.setOnClickListener(v -> {
            answer = "False";
            Toast.makeText(this, "You Are Wrong!", Toast.LENGTH_SHORT).show();
        });

        submitBTN.setOnClickListener(v -> {

            if (answer.equals("")) {
                Toast.makeText(this, "Choose an answer first", Toast.LENGTH_SHORT).show();
                return;
            }

            if (answer.equals("True")) {
                score = 1;
            } else {
                score = 0;
            }

            Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
            intent.putExtra(EXTRA_SCORE, score);
            startActivity(intent);
        });
    }
}