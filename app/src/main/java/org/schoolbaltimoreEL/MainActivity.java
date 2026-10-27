package org.schoolbaltimoreEL;

import android.content.Intent;
import android.net.Uri;
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

    int currentQuestion = 0;

    TextView questionTV;
    Button trueBTN;
    Button falseBTN;
    Button submitBTN;
    Button HintBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize question prompt and correct answer
        q1 = new Question(getString(R.string.earth),true, "https://science.nasa.gov/solar-system/");
        q2 = new Question(getString(R.string.triangle),false,"https://www.mathsisfun.com/triangle.html");
        q3 = new Question(getString(R.string.Water),true, "https://www.usgs.gov/special-topics/water-science-school");
        q4 = new Question(getString(R.string.Dogs),false,"https://kids.nationalgeographic.com/animals/mammals/facts/domestic-dog");
        q5 = new Question(getString(R.string.France),true, "https://kids.nationalgeographic.com/geography/countries/article/france");
        q6 = new Question(getString(R.string.hour), true, "https://www.mathsisfun.com/measure/time.html");
        q7 = new Question(getString(R.string.hearts),false,"https://kidshealth.org/en/kids/heart.html");
        q8 = new Question(getString(R.string.Plants),true,"https://kids.nationalgeographic.com/nature/article/photosynthesis");
        q9 = new Question(getString(R.string.Basketball),false, "https://www.britannica.com/sports/basketball");
        q10 = new Question(getString(R.string.Pacific),true,"https://oceanservice.noaa.gov/facts/biggestocean.html");

        //Initialize my array
        tenQuestions = new Question[] {q1, q2, q3, q4, q5, q6, q7, q8, q9, q10};

        questionTV = findViewById(R.id.questionTV);
        trueBTN = findViewById(R.id.True);
        falseBTN = findViewById(R.id.False);
        submitBTN = findViewById(R.id.submitBTN);
        HintBTN = findViewById(R.id.hintBTN);


        // Show first question
        displayCurrentQuestion();

        trueBTN.setOnClickListener(v -> {
            selectedAnswer = true;
            Toast.makeText(this, R.string.selected_true, Toast.LENGTH_SHORT).show();
        });

        falseBTN.setOnClickListener(v -> {
            selectedAnswer = false;
            Toast.makeText(this, R.string.selected_false, Toast.LENGTH_SHORT).show();
        });

        submitBTN.setOnClickListener(v -> {
            if (selectedAnswer == null) {
                Toast.makeText(this, R.string.choose_answer, Toast.LENGTH_SHORT).show();
                return;
            }

            if (selectedAnswer == tenQuestions[currentQuestion].getCorrectAnswer()) {
                score++;
                Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, R.string.wrong_toast, Toast.LENGTH_SHORT).show();
            }

            // Move to next question
            currentQuestion++;

            // Reset selected answer
            selectedAnswer = null;

            // If there are still questions left
            if (currentQuestion < tenQuestions.length) {
                displayCurrentQuestion();
            } else {
                // After question 10 go to ScoreActivity
                Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
                intent.putExtra(EXTRA_SCORE, score);
                startActivity(intent);
                finish();
            }

        });
        HintBTN.setOnClickListener(v -> {
            // hint code here
            String websiteUrl = tenQuestions[currentQuestion].getHintLink();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl));
            // Verify that there is an app available to handle the intent
            startActivity(intent);
        });
    }

    private void displayCurrentQuestion() {
        String questionText = (currentQuestion + 1) + ". " + tenQuestions[currentQuestion].getQuestionPrompt();
        questionTV.setText(questionText);

        if (currentQuestion == tenQuestions.length - 1) {
            submitBTN.setText(getString(R.string.btn_see_score));
        } else {
            submitBTN.setText(getString(R.string.btn_submit));


        }
    }
}


