package com.example.animaciones;

import androidx.appcompat.app.AppCompatActivity;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView ivEjex;
    private ImageView ivEjeY;
    private ImageView ivAlpha;
    private ImageView ivRotation;
    private ImageView ivTodo;
    private ImageView ivBucle;
    private ImageView ivScale;

    private Button btEjeX;
    private Button btEjeY;
    private Button btAlpha;
    private Button btRotation;
    private Button btTodo;
    private Button btBucle;
    private Button btScale;
    private Button btMainCancel;

    //ObjectAnimator -> Proporciona soporte para animar objetos

    private ObjectAnimator animatorX;
    private ObjectAnimator animatorY;
    private ObjectAnimator animatorAlpha;
    private ObjectAnimator animatorRotation;
    private ObjectAnimator animatorAll;

    private long animationDuration=1000;

    //AnimatorSet -> Reproduce conjunto de ObjectAnimator en orden específicado. Se puede todas animaciones a la vez.
    private AnimatorSet animatorSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btEjeX = findViewById(R.id.btEjeX);
        ivEjex = findViewById(R.id.ivEjeX);
        btEjeX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animacion("ejeX");
            }
        });

        btEjeY = findViewById(R.id.btEjeY);
        ivEjeY= findViewById(R.id.ivEjeY);
        btEjeY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animacion("ejeY");
            }
        });

        btAlpha=findViewById(R.id.btAlpha);
        ivAlpha=findViewById(R.id.ivAlpha);
        btAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animacion("alpha");
            }
        });

        btRotation=findViewById(R.id.btRotation);
        ivRotation=findViewById(R.id.ivRotation);
        btRotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animacion("rotation");
            }
        });

        btTodo=findViewById(R.id.btTodo);
        ivTodo=findViewById(R.id.ivTodo);
        btTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animacion("todo");
            }
        });

        btBucle=findViewById(R.id.btBucle);
        ivBucle=findViewById(R.id.ivBucle);
        btBucle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animacion("bucle");
            }
        });

        btScale=findViewById(R.id.btScale);
        ivScale=findViewById(R.id.ivScale);
        btScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animacion("scale");
            }
        });

        btMainCancel = findViewById(R.id.btMainActivityCancel);
        btMainCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animatorSet.cancel();
            }
        });
    }

    private void animacion(String animacion){
        switch (animacion){
            case "ejeX":
                animatorX=ObjectAnimator.ofFloat(ivEjex, "x", 420f);
                animatorX.setDuration(animationDuration);
                AnimatorSet animatorSetX=new AnimatorSet();
                animatorSetX.play(animatorX);
                animatorSetX.start();
                break;
            case "ejeY":
                animatorY = ObjectAnimator.ofFloat(ivEjeY, "y", -420f);
                animatorY.setDuration(animationDuration);
                AnimatorSet animatorSetY = new AnimatorSet();
                animatorSetY.play(animatorY);
                animatorSetY.start();
                break;
            case "alpha":
                animatorAlpha = ObjectAnimator.ofFloat(ivAlpha, View.ALPHA, 1.0f, 0.2f);
                animatorAlpha.setDuration(animationDuration);
                AnimatorSet animatorSetAlpha = new AnimatorSet();
                animatorSetAlpha.play(animatorAlpha);
                animatorSetAlpha.start();
                break;
            case "rotation":
                animatorRotation = ObjectAnimator.ofFloat(ivRotation, "rotation", 0f, 360f);
                animatorRotation.setDuration(animationDuration);
                AnimatorSet animatorSetRotation = new AnimatorSet();
                animatorSetRotation.play(animatorRotation);
                animatorSetRotation.start();
                break;
            case "todo":
                animatorAlpha = ObjectAnimator.ofFloat(ivTodo, View.ALPHA, 1.0f, 0.0f);
                animatorAlpha.setDuration(animationDuration);
                animatorX=ObjectAnimator.ofFloat(ivTodo, "x", 420f);
                animatorX.setDuration(animationDuration);
                animatorRotation = ObjectAnimator.ofFloat(ivTodo, "rotation", 0f, 360f);
                animatorRotation.setDuration(animationDuration);
                AnimatorSet animatorSetTodo = new AnimatorSet();
                animatorSetTodo.playTogether(animatorAlpha, animatorX, animatorRotation);
                animatorSetTodo.start();
                break;
            case "bucle":
                animatorX = ObjectAnimator.ofFloat(ivBucle, "x", 420f);
                animatorX.setDuration(animationDuration);
                AnimatorSet animatorSetBucle = new AnimatorSet();
                animatorSetBucle.playTogether(animatorX);
                animatorSetBucle.addListener(new AnimatorListenerAdapter() {
                    private boolean canceled = false;
                    @Override
                    public void onAnimationCancel(Animator animation) {
                        canceled=true;
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        animation.start();
                    }

                    @Override
                    public void onAnimationStart(Animator animation) {
                        canceled=false;
                    }
                });
                animatorSetBucle.start();
                break;
            case "scale":
                Animation animationScale=AnimationUtils.loadAnimation(this, R.anim.scale);
                ivScale.startAnimation(animationScale);
                break;
                default: break;
        }
    }
}