package org.schoolbaltimoreEL;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        TextView finalScoreTV = findViewById(R.id.finalScoreTV);
        Button restartBTN = findViewById(R.id.restartBTN);

        // Get the score sent from MainActivity
        int score = getIntent().getIntExtra("USER_SCORE", 0);
        finalScoreTV.setText(score + " / 10");

        restartBTN.setOnClickListener(v -> {
            // Go back to MainActivity
            Intent intent = new Intent(ScoreActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });
    }
}
