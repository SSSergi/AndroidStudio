package com.example.questionario;

public class Preguntas {
    private int mTextResId;
    private boolean mAnswerTrue;

    public Preguntas(int textResId, boolean answerTrue){
        mTextResId=textResId;
        mAnswerTrue=answerTrue;
    }

    /*---------------- GETTERS AND SETTERS START ---------------- */

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

    /*---------------- GETTERS AND SETTERS END ---------------- */

}
