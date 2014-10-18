package myfirstapp.example.com.nafnogkennitala;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.exceptions.RealmException;
import io.realm.exceptions.RealmIOException;
import io.realm.exceptions.RealmMigrationNeededException;
import myfirstapp.example.com.nafnogkennitala.models.User;

/*
Höfundur: Katrín Elíasdóttir
Dagsetning: 10-12.10.2014

Höfundur: Helga Sigríður Ívarsdóttir
Dagsetning: 12.10.2014

Höfundur: Kristrún Harpa Gunnarsdóttir
Dagsetning 11-16.10.2014

Þessi klasi tekur við upplýsingunum sem notandi gefur um þau lyf sem hann tekur og vistar þær í töflu en
inniheldur einnig gettera og settera fyrir hvern entry í töfluna. Að loknum innslætti kallar
klasinn svo á næsta glugga í forritinu.
 */

public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    /* Höfundur: Katrín Elíasdóttir
       Dagsetning : 13.10.14

        Tekur inn innsleginn texta af skjá. Textinn sem inniheldur kennitölu
        varpast í heiltölu og textinn sem inniheldur nafn varpast í streng.
        Þegar ýtt er á hnappinn er athugað hvort kennitalan innihaldi 10 tölustafi
        og leyfilegt er að kennitalan innihaldi bandstrik.  Textinn sem inniheldur
        nafn má innihalda íslenska stafi. Fornafn og eftirnafn verða að byrja á
        stórum staf og leyfilegt er að slá inn tvo fornöfn.
        16.10.14 er enn verið að vinna í villaskilaboðum
    */

    public void onButtonClick(View v){

        EditText EditTextKennitala = (EditText)findViewById(R.id.kenniTala);
        EditText EditTextNafn = (EditText)findViewById(R.id.nameText);
        TextView TextViewKennitala = (TextView)findViewById(R.id.kenniUttak);
        TextView TextViewNafn = (TextView)findViewById(R.id.nafnUttak);


        String kennitala  = EditTextKennitala.getText().toString();
        try{
            if(!kennitala.matches("^(\\d){6}[-](\\d){4}$|^(\\d){10}$"))
                throw new java.io.IOException();
        } catch(java.io.IOException e){
            Toast.makeText(getApplicationContext(),"Kennitala vitlaus!",Toast.LENGTH_LONG).show();
            return;
        }

        String nafn = EditTextNafn.getText().toString();
        try{
            if(!nafn.matches("^(\\w+)(\\s)(\\w+)$|^(\\w+)(\\s)(\\w+)(\\s)(\\w+)$|" +
                   "^(\\w+)(\\s)(\\w+)(\\s)(\\w+)(\\s)(\\w+)$|" +
                    "^(\\w+)(\\s)(\\w+)(\\s)(\\w+)(\\s)(\\w+)(\\s)(\\w+)$"))
                throw new java.io.IOException();
        } catch(java.io.IOException e){
            Toast.makeText(getApplicationContext(),"Ólöglegt nafn",Toast.LENGTH_LONG).show();
            return;
        }


        Realm realm = null;
        try{
            realm = Realm.getInstance(this, "newRealm");
        } catch(RealmMigrationNeededException e){
            Toast.makeText(this, "Migration Needed Exception: " + e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        } catch(RealmIOException e){
            Toast.makeText(this, "IO Exception: " + e.getMessage(), Toast.LENGTH_LONG).show();
        } catch(RealmException e){
            Toast.makeText(this, "General Exception: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        if(realm != null) {
            realm.beginTransaction();
            User user = realm.createObject(User.class);
            user.setName(EditTextNafn.getText().toString());
            user.setSsn(EditTextKennitala.getText().toString());

            realm.commitTransaction();

            startActivity(new Intent(getApplicationContext(), Allergy_input.class));
        }
        //Toast.makeText(getApplicationContext(), "Yay!", Toast.LENGTH_LONG).show();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_my, container, false);
            return rootView;
        }
    }
}
