
import myfirstapp.example.com.nafnogkennitala.ExampleActivity;
import myfirstapp.example.com.nafnogkennitala.R;

import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.app.PendingIntent;
import android.widget.RemoteViews;
import android.appwidget.AppWidgetProvider;
import android.os.Bundle;


/**
 * Created by katrineliasdottir on 09/11/14.
 *
 * Klasi sem sækir stillingar fyrir hnappinn á Home Screen og á Lock Screen.
 */


public class EmergencyButtonAppWidgetProvider extends AppWidgetProvider {

    /* private static final String ACTION_CLICK = "ACTION_CLICK";
    */
    AppWidgetManager appWidgetManager;
    int widgetId;
    Bundle myOptions = appWidgetManager.getAppWidgetOptions (widgetId);

    // Get the value of OPTION_APPWIDGET_HOST_CATEGORY
    int category = myOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_HOST_CATEGORY, -1);

    // If the value is WIDGET_CATEGORY_KEYGUARD, it's a lockscreen widget
    boolean isKeyguard = category == AppWidgetProviderInfo.WIDGET_CATEGORY_KEYGUARD;

    int baseLayout = isKeyguard ? R.layout.button_keyguard : R.layout.button_appwidget;


    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int N = appWidgetIds.length;

        // Perform this loop procedure for each App Widget that belongs to this provider
        for (int i=0; i<N; i++) {
            int appWidgetId = appWidgetIds[i];

            // Create an Intent to launch ExampleActivity
            Intent intent = new Intent(context, ExampleActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

            // Get the layout for the App Widget and attach an on-click listener
            // to the button
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.button_appwidget);
            views.setOnClickPendingIntent(R.id.emergencyButton, pendingIntent);

            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }


}