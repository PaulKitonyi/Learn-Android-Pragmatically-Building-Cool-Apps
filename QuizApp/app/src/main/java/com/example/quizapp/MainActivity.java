package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button yesButton;
    private Button noButton;
    private TextView questiontextView;
    private ImageButton nextButton;
    private ImageButton previousButton;

    private int currentQuestionIndex = 0;

    private Question[] questions = new Question[] {
            new Question(R.string.declaration_question, true),
            new Question(R.string.question1, true),
            new Question(R.string.question2, false),
            new Question(R.string.question3, false),
            new Question(R.string.question4, false),
            new Question(R.string.question5, true),
            new Question(R.string.question6, true),
            new Question(R.string.question7, true),
            new Question(R.string.question8, true),
            new Question(R.string.question9, true),
            new Question(R.string.question10, true),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yesButton = findViewById(R.id.yes_button);
        noButton = findViewById(R.id.no_button);
        questiontextView = findViewById(R.id.answer_text_view);
        nextButton = findViewById(R.id.next_btn);
        previousButton = findViewById(R.id.previous);

        yesButton.setOnClickListener(this);
        noButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        previousButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.yes_button:
                isAnswerTrue(true);
                break;

            case R.id.no_button:
                isAnswerTrue(false);
                break;

            case R.id.next_btn:
                if(currentQuestionIndex != questions.length - 1) {
                    currentQuestionIndex = (currentQuestionIndex + 1) % questions.length;
                    updateQuestion();
                }

                break;

            case R.id.previous:
                if(currentQuestionIndex > 0) {
                    currentQuestionIndex = (currentQuestionIndex - 1) % questions.length;
                    updateQuestion();
                }

        }
    }

    public void updateQuestion() {
        questiontextView.setText(questions[currentQuestionIndex].getQuestionResId());
    }

    public void isAnswerTrue(boolean rigthAnswer) {
        boolean answerIsTrue = questions[currentQuestionIndex].isAnswer();
        int toastMessageId;

        if (rigthAnswer == answerIsTrue) {
            toastMessageId = R.string.right_answer;
        }else {
            toastMessageId = R.string.wrong_answer;
        }

        Toast.makeText(MainActivity.this, toastMessageId, Toast.LENGTH_SHORT).show();
    }
}
