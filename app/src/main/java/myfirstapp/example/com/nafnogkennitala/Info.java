package myfirstapp.example.com.nafnogkennitala;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Quima on 25/10/2014.
 */
public class Info {

    private static final String PREFS_NAME = "MyPrefsFile";

    public static void setInfoIsSaved(Context context){

        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("infoSave", true);
        editor.commit();
    }

    public static boolean isInfoSaved(Context context){

        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
        return settings.getBoolean("infoSave", false);
    }
}
