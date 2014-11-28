package myfirstapp.example.com.nafnogkennitala;

import android.app.Activity;
import android.app.AlertDialog;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import myfirstapp.example.com.nafnogkennitala.R;


public class EmergencyButtonConfirmationActivity extends Activity {

    private String key;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.prompts);
        key = "";
        key += ((int)(Math.random()*9 + 1));
        key += ((int)(Math.random()*10));
        key += ((int)(Math.random()*10));
        ((TextView)findViewById(R.id.promptsNumber)).setText(key);
    }

    public void confirmEmergency(View view) {

        if (confirmInput()) {
            // get GPS and send SMS
            Toast.makeText(this.getApplicationContext(),
                    "Always true?", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this.getApplicationContext(),
                    "Innslegin tala passar ekki við uppgefna tölu!", Toast.LENGTH_LONG).show();
        }
    }

    private boolean confirmInput(){
        String userInput = ((EditText)findViewById(R.id.promptsInput)).getText().toString();
        Toast.makeText(this.getApplicationContext(),
                "Comparing '" + key + "' to '" + userInput + "'", Toast.LENGTH_LONG);
        return userInput.equals(key);
    }

}