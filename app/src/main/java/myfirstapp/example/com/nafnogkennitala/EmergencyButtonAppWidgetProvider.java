package myfirstapp.example.com.nafnogkennitala;

import android.content.Context;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.app.PendingIntent;
import android.widget.RemoteViews;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;


/**
 * Created by katrineliasdottir on 09/11/14.
 *
 * Klasi sem býr til widget hnapp á Home Screen og á Lock Screen,
 * sem virkjar EmergencyButtonConfirmationActivity klasann þegar smellt er á hann.
 */


public class EmergencyButtonAppWidgetProvider extends AppWidgetProvider {

    private static final String WIDGET_BUTTON = "EMERGENCY_BUTTON.PRESSED";

    // Update-ar Homescreen Widgetið.

    @Override
    public void onUpdate(final Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {


        ComponentName w = new ComponentName(context, EmergencyButtonAppWidgetProvider.class);

        int[] appWidgetInstanceIds = appWidgetManager.getAppWidgetIds(w);
        for(int widgetID: appWidgetInstanceIds){
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.button_appwidget);
            Intent intent = new Intent(context, EmergencyButtonAppWidgetProvider.class);
            intent.setAction(WIDGET_BUTTON);
            PendingIntent pendingIntent =
                    PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            views.setOnClickPendingIntent(R.id.emergencyButton, pendingIntent);
            appWidgetManager.updateAppWidget(widgetID, views);
        }

        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    @Override
    public void onReceive(final Context context, Intent intent){
        if(intent.getAction().equals(WIDGET_BUTTON)){
            Intent activity = new Intent(context, myfirstapp.example.com.nafnogkennitala.EmergencyButtonConfirmationActivity.class);
            activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(activity);
        }
        super.onReceive(context, intent);
    }
}