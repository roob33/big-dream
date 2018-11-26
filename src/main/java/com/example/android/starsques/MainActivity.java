package com.example.android.starsques;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String q1E = "Leonardo dicaprio"; //The correct answer to the EditText.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view) {
        //Set the correct answers.
        CheckBox answer1 = findViewById(R.id.answer_1);
        CheckBox answer3 = findViewById(R.id.answer_3);
        CheckBox answer5 = findViewById(R.id.answer_5);
        CheckBox answer8 = findViewById(R.id.answer_8);
        CheckBox answer9 = findViewById(R.id.answer_9);
        CheckBox answer11 = findViewById(R.id.answer_11);
        CheckBox answer12 = findViewById(R.id.answer_12);

        //Set the wrong answers.
        CheckBox answer2 = findViewById(R.id.answer_2);
        CheckBox answer4 = findViewById(R.id.answer_4);
        CheckBox answer6 = findViewById(R.id.answer_6);
        CheckBox answer7 = findViewById(R.id.answer_7);
        CheckBox answer10 = findViewById(R.id.answer_10);

        int point = 0;

        // Answers A.
        if (answer1.isChecked() && answer3.isChecked() && !answer2.isChecked() && !answer4.isChecked()) {
            point += 2;
        }
        //Answers B.
        if (answer5.isChecked() && answer8.isChecked() && !answer6.isChecked() && !answer7.isChecked()) {
            point += 2;
        }
        //Answers C.
        if (answer9.isChecked() && answer11.isChecked() && answer12.isChecked() && !answer10.isChecked()) {
            point += 3;
        }

        //definition of RadioButton And the calculation of its results.

        RadioButton option1 = findViewById(R.id.option_1);
        if (option1.isChecked()) {
            point += 1;
        }

        RadioButton option2 = findViewById(R.id.option_2);
        if (option2.isChecked()) {
        }

        //Set the correct answer for the EditText.
        EditText question_text = findViewById(R.id.question_text);
        String answer = question_text.getText().toString().trim();
        if (answer.equalsIgnoreCase(q1E)) {
            point += 1;
        }

        //Set the sum of the result  and show it.
        int result = 9;
        if (result <= point) {
            Toast.makeText(this, "Congratulations You  got a full score You  got 9 points Out of 9 Answers are correct\n", Toast.LENGTH_LONG).show();
        } else if (result > point) {
            Toast.makeText(this, "You must combine 9 correct points to Try again", Toast.LENGTH_LONG).show();
        }

        String message = displayShow(answer, point);

        showMessage(message);
    }

    private String displayShow(String answer, int point) {
        String showMessage = "He :" + answer;
        showMessage = showMessage + "\n points : " + point;
        showMessage = showMessage + "\n Good job";
        return showMessage;
    }

    private void showMessage(String message) {
        TextView showTextView = findViewById(R.id.show_text_view);
        showTextView.setText(message);
    }
}
