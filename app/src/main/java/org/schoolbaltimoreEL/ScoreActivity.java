package org.schoolbaltimoreEL;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        TextView finalScoreTV = findViewById(R.id.finalScoreTV);
        Button restartBTN = findViewById(R.id.restartBTN);

        // Get the score sent from MainActivity
        int score = getIntent().getIntExtra(MainActivity.EXTRA_SCORE, 0);
        finalScoreTV.setText(String.format(Locale.getDefault(), "%d / 1", score));

        restartBTN.setOnClickListener(v -> {
            // Go back to MainActivity
            Intent intent = new Intent(ScoreActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });
    }
}
