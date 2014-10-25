package myfirstapp.example.com.nafnogkennitala;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/*
Höfundur: Kristrún Harpa Gunnarsdóttir
Dagsetning 16.10.2014

Þessi klasi fylgir skjánum sem biður notanda um að slá inn kvilla sína, einn í einu. Notandi getur
ýtt á takka til að slá inn annan, eða annan takka til að ljúka innslætti kvilla.
 */

public class Disease_input extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_input);
    }

    public void onButtonClick(View v){

        EditText DiseaseInput = (EditText)findViewById(R.id.write_disease);
        TextView DiseaseText = (TextView)findViewById(R.id.txt_disease);
        String text = (DiseaseInput.getText().toString());
        DiseaseText.setText(text);
        finish();
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
