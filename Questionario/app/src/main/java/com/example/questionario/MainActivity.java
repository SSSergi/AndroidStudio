package com.example.questionario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mCheatButton;
    private ImageButton mBackButton;
    private ImageButton mNextButton;
    private TextView mQuestionTextView;
    private int mCurrentIndex=0;
    private int totalCorrectas=0;
    private boolean Contestado = false;

    private static final String TAG="MainActivity";
    private static final String KEY_INDEX = "index";

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX,0);
        }

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentIndex==mQuestionBank.length-1){
                    puntuar(totalCorrectas);
                }else{
                    mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                    actualizarPregunta();
                    Contestado = false;
                }
            }
        });

        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Contestado){
                    confirmarPregunta(true);
                    Contestado=true;
                }
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Contestado){
                    confirmarPregunta(false);
                    Contestado=true;
                }
            }
        });

        mCheatButton = (Button)findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this, CheatActivity.class);
                startActivity(intent);
            }
        });

        mBackButton = (ImageButton) findViewById(R.id.back_button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCurrentIndex>=1){
                    mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
                }
                actualizarPregunta();
            }
        });

        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentIndex==mQuestionBank.length-1){
                    puntuar(totalCorrectas);
                }else{
                    mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                    actualizarPregunta();
                    Contestado = false;
                }
            }
        });
        actualizarPregunta();
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG,"onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
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
            totalCorrectas=totalCorrectas+1;
        } else {
            messageResId = R.string.incorrect_toast;
        }

        Toast toast = Toast.makeText(getApplicationContext(), messageResId, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP,0,250);
        toast.show();
    }

    private void puntuar(int totalCorrectas){
        int nota=0;
        nota=(100*totalCorrectas)/mQuestionBank.length;

        Toast toast = Toast.makeText(getApplicationContext(), "Has acertado el "+ nota +"% del questionario.", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP,0,250);
        toast.show();
    }
}