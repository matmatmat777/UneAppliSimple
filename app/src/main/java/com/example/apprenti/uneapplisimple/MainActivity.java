package com.example.apprenti.uneapplisimple;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText nom;
    EditText prenom;
    CheckBox checkBox;
    Button button;
    TextView felicitation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom = (EditText) findViewById(R.id.nom);
        prenom = (EditText) findViewById(R.id.prenom);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        button = (Button) findViewById(R.id.button);
        felicitation = (TextView) findViewById(R.id.felicitation);



        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                nom.setEnabled(checkBox.isChecked());
                prenom.setEnabled(checkBox.isChecked());
                button.setEnabled(checkBox.isChecked());
                if (!isChecked) {
                    nom.setText(null);
                    prenom.setText(null);
                    felicitation.setVisibility(View.INVISIBLE);

                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (nom.length() != 0 && prenom.length() !=0) {
                    felicitation.setText(getString(R.string.felicitation) + nom.getText()+ " "+prenom.getText());
                    felicitation.setVisibility(View.VISIBLE);

                }

                else
                {

                    Context context = getApplicationContext();
                    CharSequence text = (getString(R.string.toast));
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }
            };

        });
    };}