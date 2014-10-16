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

    public void onButtonClick(View v){

        int IntKennitala,NyttIntKennitala;
        EditText EditTextKennitala = (EditText)findViewById(R.id.kenniTala);
        EditText EditTextNafn = (EditText)findViewById(R.id.nameText);
        TextView TextViewKennitala = (TextView)findViewById(R.id.kenniUttak);
        TextView TextViewNafn = (TextView)findViewById(R.id.nafnUttak);
        IntKennitala = Integer.parseInt(EditTextKennitala.getText().toString());
        String text = (EditTextNafn.getText().toString());
        NyttIntKennitala = IntKennitala;
        TextViewKennitala.setText(Integer.toString(NyttIntKennitala));
        TextViewNafn.setText(text);


        String kennitala  = EditTextKennitala.getText().toString();
        try{
            if(!kennitala.matches("^(\\d){6}-(\\d){4}$|^(\\d){10}$"))
                throw new java.io.IOException();
        } catch(java.io.IOException e){
            Toast.makeText(getApplicationContext(),"Kennitala vitlaus!",Toast.LENGTH_LONG).show();
            return;
        }

        String nafn = EditTextNafn.getText().toString();
        try{
            if(!nafn.matches("^(\\w){1}(\\w){30}-(\\w){1}(\\w){50}$"))
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
