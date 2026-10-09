package org.schoolbaltimoreEL;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_SCORE = "USER_SCORE";
    private Boolean selectedAnswer = null;
    private int score = 0;
    Question q1;
    Question q2;
    Question q3;
    Question q4;
    Question q5;
    Question q6;
    Question q7;
    Question q8;
    Question q9;
    Question q10;

    Question[] tenQuestions;

    int Score = 0;
    int currentQuestion = 0;

    TextView questionTV;
    Button trueBTN;
    Button falseBTN;
    Button submitBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize question prompt and correct answer
        q1 = new Question("The Earth goes around the Sun.", true);
        q2 = new Question("A triangle has four sides.", false);
        q3 = new Question("Water freezes at 0°C.", true);
        q4 = new Question("Dogs are reptiles.", false);
        q5 = new Question("The capital of France is Paris.", true);
        q6 = new Question("There are 60 minutes in one hour.", true);
        q7 = new Question("The human body has three hearts.", false);
        q8 = new Question("Plants need sunlight to grow.", true);
        q9 = new Question("Basketball is played with a bat.", false);
        q10 = new Question("The Pacific Ocean is an ocean.", true);

        //Initialize my array
        tenQuestions = new Question[] {q1, q2, q3, q4, q5, q6, q7, q8, q9, q10};


        TextView questionTV = findViewById(R.id.questionTV);
        if (questionTV != null) {
            questionTV.setText(q1.getQuestionPrompt());
        }

        Button trueBTN = findViewById(R.id.True);
        Button falseBTN = findViewById(R.id.False);
        Button submitBTN = findViewById(R.id.submitBTN);

        trueBTN.setOnClickListener(v -> {
            selectedAnswer = true;
            Toast.makeText(this, "Selected: True", Toast.LENGTH_SHORT).show();
        });

        falseBTN.setOnClickListener(v -> {
            selectedAnswer = false;
            Toast.makeText(this, "Selected: False", Toast.LENGTH_SHORT).show();
        });

        submitBTN.setOnClickListener(v -> {
            if (selectedAnswer == null) {
                Toast.makeText(this, "Choose an answer first", Toast.LENGTH_SHORT).show();
                return;
            }

            // Grade answer based on Question's correct answer
            if (selectedAnswer == q1.getCorrectAnswer()) {
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
