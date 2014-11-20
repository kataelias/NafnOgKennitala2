
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


/**
 * Created by katrineliasdottir on 09/11/14.
 *
 * Klasi sem býr til widget hnapp á Home Screen og á Lock Screen,
 * sem virkjar MyActivity klasann þegar smellt er á hann.
 */


public class EmergencyButtonAppWidgetProvider extends AppWidgetProvider {

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        // Perform this loop procedure for each App Widget that belongs to this provider
        for (int i = 0; i < appWidgetIds.length; i++) {
            int appWidgetId = appWidgetIds[i];

            // Create an Intent to launch ExampleActivity
            Intent intent = new Intent(context, MyActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);


            // Get the layout for the App Widget and attach an on-click listener
            // to the button
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.button_appwidget);
            views.setOnClickPendingIntent(R.id.emergencyButton, pendingIntent);

            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, views);


        }
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

}