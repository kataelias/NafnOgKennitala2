import myfirstapp.example.com.nafnogkennitala.EmergencyButtonAppWidgetProvider;
import myfirstapp.example.com.nafnogkennitala.R;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;



/**
 * Created by katrineliasdottir on 26/11/14.
 */

public class EmergencyButtonWidgetIntentReceiver extends BroadcastReceiver {

    private static int clickCount = 0;

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("android.intent.action.SEND_FOR_HELP")){
            updateWidgetButtonListener(context);
        }
    }

    private void updateWidgetButtonListener(Context context) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.button_appwidget);


        //REMEMBER TO ALWAYS REFRESH YOUR BUTTON CLICK LISTENERS!!!
        remoteViews.setOnClickPendingIntent(R.id.emergencyButton, EmergencyButtonAppWidgetProvider.buildButtonPendingIntent(context));

        EmergencyButtonAppWidgetProvider.pushWidgetUpdate(context.getApplicationContext(), remoteViews);
    }

}