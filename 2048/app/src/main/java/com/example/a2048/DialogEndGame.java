package com.example.a2048;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogEndGame extends AppCompatDialogFragment {

    private EditText userName;
    private EditText userID;
    private EditText country;
    private EditText finalScore;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.registrar_usuario_activity, null);

        builder.setView(view).setTitle("Registrar").setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });

        userName = view.findViewById(R.id.name_ID);
        userName = view.findViewById(R.id.IDUser_ID);
        userName = view.findViewById(R.id.country_ID);

        return builder.create();
    }
}
