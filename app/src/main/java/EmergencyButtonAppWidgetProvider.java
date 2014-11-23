
import myfirstapp.example.com.nafnogkennitala.MyActivity;
import myfirstapp.example.com.nafnogkennitala.R;

import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.app.PendingIntent;
import android.widget.RemoteViews;
import android.appwidget.AppWidgetProvider;
import android.os.Bundle;
import android.content.ComponentName;
import android.content.IntentFilter;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by katrineliasdottir on 09/11/14.
 *
 * Klasi sem býr til widget hnapp á Home Screen og á Lock Screen,
 * sem virkjar MyActivity klasann þegar smellt er á hann.
 */


public class EmergencyButtonAppWidgetProvider extends AppWidgetProvider {

    final Context context = this;
    private EditText editTextMainScreen;



    public void onUpdate(View view, Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {



        // Perform this loop procedure for each App Widget that belongs to this provider
        for (int i = 0; i < appWidgetIds.length; i++) {
            int appWidgetId = appWidgetIds[i];


            LayoutInflater layoutInflater = LayoutInflater.from(context);

            View promptView = layoutInflater.inflate(R.layout.prompts, null);

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

            alertDialogBuilder.setView(promptView);

            String number = "";
            int num2 = Math.round(Math.random()*1000);
            if(num2 < 10) {
                number = "00" + num2;
            }
            else{
                if(num2 < 100){
                    number = "0" + num2;
                }
                else{
                    number = number + num2;
                }
            }
            EditText input = (EditText) promptView.findViewById(R.id.userInput);
            String text = (input.getText().toString());



            // setup a dialog window
            alertDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            if(text == number){

                                //Kata, have fun

                            }
                            else{
                                Context context = getApplicationContext();
                                CharSequence text = "Reyndu aftur";
                                int duration = Toast.LENGTH_SHORT;

                                Toast toast = Toast.makeText(context, text, duration);
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


            // Create an Intent to launch ExampleActivity
            /*Intent intent = new Intent(context, MyActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);




            // Get the layout for the App Widget and attach an on-click listener
            // to the button
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.button_appwidget);
            views.setOnClickPendingIntent(R.id.emergencyButton, pendingIntent);
            */

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.button_appwidget);

            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, views);


        }
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

}