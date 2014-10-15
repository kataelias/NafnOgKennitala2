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

import io.realm.Realm;
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

        int n1,sum1;
        EditText e1 = (EditText)findViewById(R.id.kenniTala);
        EditText e2 = (EditText)findViewById(R.id.nameText);
        TextView t1 = (TextView)findViewById(R.id.kenniUttak);
        TextView t2 = (TextView)findViewById(R.id.nafnUttak);
        n1 = Integer.parseInt(e1.getText().toString());
        String text = (e2.getText().toString());
        sum1 = n1;
        t1.setText(Integer.toString(sum1));
        t2.setText(text);


        Realm realm = Realm.getInstance(this);

        realm.beginTransaction();
        User user = realm.createObject(User.class);
        user.setName(e2.getText().toString());
        user.setSsn(Integer.valueOf(e1.getText().toString()));

        realm.commitTransaction();

        startActivity(new Intent(getApplicationContext(), Allergy_input.class));
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
