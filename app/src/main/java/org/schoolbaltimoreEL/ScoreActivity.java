package org.schoolbaltimoreEL;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ScoreActivity extends AppCompatActivity {

    Intent incoming;
    int numQ;
    int score;
    TextView scoreDisplayTextView;
    Button SendEmailBTN;
    Button restartbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scoreDisplayTextView = findViewById(R.id.finalScoreTV);
        SendEmailBTN = findViewById(R.id.SendEmailBTN);
        restartbutton = findViewById(R.id.restartBTN);
        numQ = 0;
        score = 0;
        incoming = getIntent();

        numQ = incoming.getIntExtra("TOTAL_KEY", 0);
        score = incoming.getIntExtra("SCORE_KEY", 0);

        scoreDisplayTextView.setText(score + "/" + numQ);

        // add button onClick listener that will call your method



        SendEmailBTN.setOnClickListener(v -> {
            String[] addresses = {"eidenparra30@gmail.com"};
            String subject = "planet Quiz Score";
            String body = "My score is " + score + "/" + numQ;

            composeEmail(addresses, subject, body);
        });
        restartbutton.setOnClickListener(v -> {
            Intent intent = new Intent(ScoreActivity.this, MainActivity.class);
            startActivity(intent);

        });

    }

    public void composeEmail(String[] addresses, String subject, String body) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // Only email apps handle this.
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        startActivity(intent);
    }
}

