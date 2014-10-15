package myfirstapp.example.com.nafnogkennitala;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Disease_input extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_input);
    }

    public void onButtonClick(View v){

        EditText e1 = (EditText)findViewById(R.id.write_disease);
        TextView t1 = (TextView)findViewById(R.id.txt_disease);
        String text = (e1.getText().toString());
        t1.setText(text);
    }

    public void onNextButtonClick(View v) {

        EditText e1 = (EditText)findViewById(R.id.write_allergy);
        TextView t1 = (TextView)findViewById(R.id.txt_allergy);
        String text = (e1.getText().toString());
        t1.setText(text);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.disease_input, menu);
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