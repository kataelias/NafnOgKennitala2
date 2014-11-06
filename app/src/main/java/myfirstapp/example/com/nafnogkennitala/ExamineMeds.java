package myfirstapp.example.com.nafnogkennitala;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import myfirstapp.example.com.nafnogkennitala.models.Meds;


public class ExamineMeds extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examine_meds);

        Realm realm = Realm.getInstance(this);
        RealmQuery<Meds> query = realm.where(Meds.class);
        RealmResults<Meds> result = query.findAll();

        String medication = "";

        for(Meds m : result){
            medication = medication + m.getName() + ", ";
        }

        TextView userMeds = (TextView)findViewById(R.id.Medication);

        userMeds.setText(medication);
    }


    public void onButtonClick(View v){
        startActivity(new Intent(getApplicationContext(), ExamineDisease.class));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.examine_meds, menu);
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
}
