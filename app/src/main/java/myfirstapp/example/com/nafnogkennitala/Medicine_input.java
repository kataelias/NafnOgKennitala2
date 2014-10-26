package myfirstapp.example.com.nafnogkennitala;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/*
Höfundur: Kristrún Harpa Gunnarsdóttir
Dagsetning 14.10.2014

Þessi klasi fylgir skjánum sem biður notanda um að slá inn lyf sín, eitt í einu. Notandi getur
ýtt á takka til að slá inn annað, eða annan til að ljúka innslætti lyfja.
 */

public class Medicine_input extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_input);
    }

    public void onButtonClick(View v){

        EditText MedicineInput = (EditText)findViewById(R.id.write_medicine);
        TextView MedicineText = (TextView)findViewById(R.id.txt_medicine);
        String text = (MedicineInput.getText().toString());
        MedicineText.setText(text);

        startActivity(new Intent(getApplicationContext(), Disease_input.class));
    }

    public void onNextButtonClick(View v) {

        EditText MedicineInput = (EditText)findViewById(R.id.write_medicine);
        TextView MedicineText = (TextView)findViewById(R.id.txt_medicine);
        String text = (MedicineInput.getText().toString());
        MedicineText.setText(text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.medicine_input, menu);
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
