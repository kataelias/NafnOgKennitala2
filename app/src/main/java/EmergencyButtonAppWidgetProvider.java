
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
import android.app.Dialog;


/**
 * Created by katrineliasdottir on 09/11/14.
 *
 * Klasi sem býr til widget hnapp á Home Screen og á Lock Screen,
 * sem virkjar MyActivity klasann þegar smellt er á hann.
 */


public class EmergencyButtonAppWidgetProvider extends AppWidgetProvider {

    /*public static String WIDGET_BUTTON = "MY_PACKAGE_NAME.WIDGET_BUTTON";*/

    public void onUpdate(View view, final Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {


        // Get the layout for the App Widget and attach an on-click listener
        // to the button
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.button_appwidget);
        views.setOnClickPendingIntent(R.id.emergencyButton, buildButtonPendingIntent(context));


        pushWidgetUpdate(context, views);
    }

    public static PendingIntent buildButtonPendingIntent(Context context) {

        // initiate widget update request
        Intent intent = new Intent();
        intent.setAction("android.intent.action.WIDGET_UPDATE_ACTION");
        return PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }
    public static void pushWidgetUpdate(Context context, RemoteViews remoteViews) {
        ComponentName myWidget = new ComponentName(context, EmergencyButtonAppWidgetProvider.class);
        AppWidgetManager manager = AppWidgetManager.getInstance(context);
        manager.updateAppWidget(myWidget, remoteViews);
    }



}