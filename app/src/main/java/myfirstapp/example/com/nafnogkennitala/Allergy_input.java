package myfirstapp.example.com.nafnogkennitala;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Allergy_input extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergy_input);
    }

    public void onButtonClick(View v){

        EditText AllergyInput = (EditText)findViewById(R.id.write_allergy);
        TextView AllergyText = (TextView)findViewById(R.id.txt_allergy);
        String text = (AllergyInput.getText().toString());
        AllergyText.setText(text);

        startActivity(new Intent(getApplicationContext(), Medicine_input.class));
    }

    public void onNextButtonClick(View v) {

        EditText AllergyInput = (EditText)findViewById(R.id.write_allergy);
        TextView AllergyText = (TextView)findViewById(R.id.txt_allergy);
        String text = (AllergyInput.getText().toString());
        AllergyText.setText(text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.allergy_input, menu);
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
