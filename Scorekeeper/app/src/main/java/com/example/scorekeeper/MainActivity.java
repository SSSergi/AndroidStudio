package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

/* ----------------------------------------  TEAM 1 ---------------------------------------- */
    private int score1;
    private ImageButton mMinusBtn1;
    private ImageButton mPlusBtn1;
    private TextView mTextMark1;
    private int mScore1=0;

/* ----------------------------------------  TEAM 2 ---------------------------------------- */
    private int score2;
    private ImageButton mMinusBtn2;
    private ImageButton mPlusBtn2;
    private TextView mTextMark2;
    private int mSCore2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMark1=(TextView) findViewById(R.id.scoreview1);
        mTextMark2=(TextView) findViewById(R.id.scoreview2);


        mMinusBtn1 = (ImageButton) findViewById(R.id.minusbtn1);
        mMinusBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView p1=mTextMark1;
                decreaseScore(p1);
            }
        });

        mPlusBtn1 = (ImageButton) findViewById(R.id.plusbtn1);
        mPlusBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView p1=mTextMark1;
                increaseScore(p1);
            }
        });

        mMinusBtn2 = (ImageButton) findViewById(R.id.minusbtn2);
        mMinusBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView p2=mTextMark2;
                decreaseScore(p2);
            }
        });

        mPlusBtn2 = (ImageButton) findViewById(R.id.plusbtn2);
        mPlusBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView p2=mTextMark2;
                increaseScore(p2);
            }
        });
    }

    public void increaseScore(TextView view){

        String cadena = view.getText().toString();
        int puntos = Integer.parseInt(cadena);
        puntos = puntos+1;
        cadena = Integer.toString(puntos);
        view.setText(cadena);
    }

    public void decreaseScore(TextView view){

        String cadena = view.getText().toString();
        int puntos = Integer.parseInt(cadena);
        if(puntos>0){
            puntos = puntos-1;
            cadena = Integer.toString(puntos);
            view.setText(cadena);
        }
    }


}