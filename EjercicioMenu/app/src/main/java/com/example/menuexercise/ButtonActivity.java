package com.example.menuexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;

import android.os.Bundle;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import android.view.View;

import org.w3c.dom.Text;

import java.util.Date;


public class ButtonActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private Button btn;
    private ImageButton imgbtn;
    private CheckBox cb;
    private RadioButton rb;
    private TextView selcolor;
    private TextView mimic;
    private EditText mensaje;
    private String mensajeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_activity);

        cb = (CheckBox) findViewById(R.id.checkbox1);
        cb.setOnCheckedChangeListener(this);


        btn = (Button) findViewById(R.id.timebtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText(new Date().toString());
            }
        });

        imgbtn = (ImageButton) findViewById(R.id.imgbuton);
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMissage();
            }
        });
    }


    /*--------------------------------------------------------------------------------------------*/

    public void sendMissage() {
        mensaje = (EditText) findViewById(R.id.textSend);
        mimic = (TextView) findViewById(R.id.textListener);
        mimic.setText(mensaje.getText());
    }

    /*--------------------------------------------------------------------------------------------*/

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (isChecked) {

            cb.setText("This checkbox is: checked");
        } else {
            cb.setText("This checkbox is: unchecked");
        }
    }

    /*--------------------------------------------------------------------------------------------*/

    public void onRadiobtnclicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();
        String red = "#D20B1D";
        String green = "#139F13";
        String blue = "#1350C2";

        selcolor = (TextView) findViewById(R.id.selcolor);

        switch (view.getId()) {
            case R.id.radiobtn1:
                if (checked) {
                    selcolor.setBackgroundColor(Color.parseColor(blue));
                }
                break;
            case R.id.radiobtn2:
                if (checked) {
                    selcolor.setBackgroundColor(Color.parseColor(red));
                }
                break;
            case R.id.radiobtn3:
                if (checked) {
                    selcolor.setBackgroundColor(Color.parseColor(green));
                }
                break;
        }
    }
}