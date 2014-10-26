package myfirstapp.example.com.nafnogkennitala;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import myfirstapp.example.com.nafnogkennitala.models.User;


public class ExamineUser extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examine_user);

        Realm realm = Realm.getInstance(this);
        RealmQuery<User> query = realm.where(User.class);
        RealmResults<User> result1 = query.findAll();
    }

    public void onButtonClick(View v){
        startActivity(new Intent(getApplicationContext(), ExamineAllergy.class));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.examine_user, menu);
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
