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

    int ScoreTV = 0;
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
        q1 = new Question(getString(R.string.earth),true);
        q2 = new Question(getString(R.string.triangle),false);
        q3 = new Question(getString(R.string.Water),true);
        q4 = new Question(getString(R.string.Dogs),false);
        q5 = new Question(getString(R.string.France),true);
        q6 = new Question(getString(R.string.hour), true);
        q7 = new Question(getString(R.string.hearts),false);
        q8 = new Question(getString(R.string.Plants),true);
        q9 = new Question(getString(R.string.Basketball),false);
        q10 = new Question(getString(R.string.Pacific),true);

        //Initialize my array
        tenQuestions = new Question[] {q1, q2, q3, q4, q5, q6, q7, q8, q9, q10};



        questionTV = findViewById(R.id.questionTV);
        trueBTN = findViewById(R.id.True);
        falseBTN = findViewById(R.id.False);
        submitBTN = findViewById(R.id.submitBTN);

        // Show first question
        questionTV.setText(
                "1." +
                        "" + tenQuestions[currentQuestion].getQuestionPrompt()
        );

        trueBTN.setOnClickListener(v -> {

            selectedAnswer = true;

            Toast.makeText(
                    this,
                    "Selected: True",
                    Toast.LENGTH_SHORT
            ).show();
        });

        falseBTN.setOnClickListener(v -> {

            selectedAnswer = false;

            Toast.makeText(
                    this,
                    "Selected: False",
                    Toast.LENGTH_SHORT
            ).show();
        });

        submitBTN.setOnClickListener(v -> {

            if (selectedAnswer == null) {

                Toast.makeText(
                        this,
                        "Choose an answer first",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            // Check current answer
            if (selectedAnswer ==
                    tenQuestions[currentQuestion].getCorrectAnswer()) {

                score++;

                Toast.makeText(
                        this,
                        "Correct!",
                        Toast.LENGTH_SHORT
                ).show();

            } else {

                Toast.makeText(
                        this,
                        "Wrong!",
                        Toast.LENGTH_SHORT
                ).show();
            }

            // Move to next question
            currentQuestion++;

            // Reset selected answer
            selectedAnswer = null;

            // If there are still questions left
            if (currentQuestion < tenQuestions.length) {

                questionTV.setText(
                        (currentQuestion + 1)
                                + ". "
                                + tenQuestions[currentQuestion]
                                .getQuestionPrompt()
                );

                // Change button text on question 10
                if (currentQuestion == 9) {
                    submitBTN.setText("SEE SCORE");
                }

            } else {

                // After question 10 go to ScoreActivity
                Intent intent = new Intent(
                        MainActivity.this,
                        ScoreActivity.class
                );

                intent.putExtra(EXTRA_SCORE, score);

                startActivity(intent);
            }
        });
    }
}
