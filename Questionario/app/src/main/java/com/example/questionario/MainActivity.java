package com.example.questionario;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;

    private Preguntas[] mQuestionBank = new Preguntas[] {
            new Preguntas(R.string.first_question, true),
            new Preguntas(R.string.second_question, false),
            new Preguntas(R.string.third_question, true),
            new Preguntas(R.string.fourth_question, true),
            new Preguntas(R.string.fifth_question, true),
            new Preguntas(R.string.sixth_question, true),
            new Preguntas(R.string.seventh_question, true),
            new Preguntas(R.string.eighth_question, false),
            new Preguntas(R.string.ninth_question, true),
            new Preguntas(R.string.tenth_question, false)
    };

    private int mCurrentIndex=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmarPregunta(true);
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmarPregunta(false);
            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                actualizarPregunta();
            }
        });
        actualizarPregunta();
    }

    private void actualizarPregunta(){
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    private void confirmarPregunta(boolean userPressedTrue){
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();

        int messageResId = 0;

        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
        /*Toast toast = Toast.makeText(getApplicationContext(), "Yay!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP,0,250);
        toast.show();*/
    }
}