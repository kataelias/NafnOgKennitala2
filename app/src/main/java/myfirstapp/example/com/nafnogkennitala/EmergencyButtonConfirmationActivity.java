package myfirstapp.example.com.nafnogkennitala;

import android.app.Activity;
import android.app.AlertDialog;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import myfirstapp.example.com.nafnogkennitala.R;


public class EmergencyButtonConfirmationActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //Toast.makeText(this.getApplicationContext(), "Please?", Toast.LENGTH_SHORT);
        setContentView(R.layout.prompts);
    }

    public void bla(){
        final Context context = this.getApplicationContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View promptView = layoutInflater.inflate(R.layout.prompts, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        alertDialogBuilder.setView(promptView);


        int num2 = (int) Math.round(Math.random() * 1000);
        final String number = num2 < 10 ? "00" + num2 : num2 < 100 ? "0" + num2 : "" + num2;


        EditText input = (EditText) promptView.findViewById(R.id.userInput);
        final String text = (input.getText().toString());

        // setup a dialog window
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {


                        if(text.equals(number))

                        {

                            //Kata, have fun

                        }

                        else

                        {

                            CharSequence text2 = "Reyndu aftur";
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, text2, duration);
                            toast.show();
                        }
                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        // create an alert dialog
        AlertDialog alertD = alertDialogBuilder.create();

        alertD.show();


    }

}