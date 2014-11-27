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


        int randomNumber = (int) Math.round(Math.random() * 1000);
        final String number = randomNumber < 10 ? "00" + randomNumber : randomNumber < 100 ? "0" + randomNumber : "" + randomNumber;


        EditText input = (EditText) promptView.findViewById(R.id.userInput);
        final String text = (input.getText().toString());

        // setup a dialog window
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public int onClick(DialogInterface dialog, int id) {


                        if(text.equals(number))

                        {
                            //Fyrir prófanadrifna forritun
                            return 1;
                            
                            //Kata, have fun

                        }

                        else

                        {

                            CharSequence text2 = "Reyndu aftur";
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, text2, duration);
                            toast.show();
                            //Fyrir prófanadrifna forritun
                            return 0;
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