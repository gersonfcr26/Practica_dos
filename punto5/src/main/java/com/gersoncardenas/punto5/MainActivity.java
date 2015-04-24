package com.gersoncardenas.punto5;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity{

    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText name = (EditText)findViewById(R.id.eNombre);
        final EditText email = (EditText)findViewById(R.id.eCorreo);
        final EditText phone = (EditText)findViewById(R.id.eTel);

        final RadioButton female = (RadioButton)findViewById(R.id.cFemale);
        final RadioButton male = (RadioButton)findViewById(R.id.cMale);

        final Spinner spinner = (Spinner)findViewById(R.id.spinner);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.cities,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        final CheckBox hobby1 = (CheckBox)findViewById(R.id.cHobby1);
        final CheckBox hobby2 = (CheckBox)findViewById(R.id.cHobby2);
        final CheckBox hobby3 = (CheckBox)findViewById(R.id.cHobby3);
        final CheckBox hobby4 = (CheckBox)findViewById(R.id.cHobby4);

        final DatePicker birthday = (DatePicker)findViewById(R.id.dBirthday);

        Button button = (Button)findViewById(R.id.button);

        final TextView tName = (TextView)findViewById(R.id.tNombre);
        final TextView tEmail = (TextView)findViewById(R.id.tCorreo);
        final TextView tPhone = (TextView)findViewById(R.id.tTel);
        final TextView tGender = (TextView)findViewById(R.id.tGender);
        final TextView tCity = (TextView)findViewById(R.id.tCity);
        final TextView tHobbies = (TextView)findViewById(R.id.tHobbies);
        final TextView tBirthday = (TextView)findViewById(R.id.tBirthday);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strName = name.getText().toString();
                String strEmail = email.getText().toString();
                String strPhone = phone.getText().toString();

                if(!strName.isEmpty() && !strEmail.isEmpty() && !strPhone.isEmpty()) {

                    tName.setText(name.getText());
                    tEmail.setText(email.getText());
                    tPhone.setText(phone.getText());

                    if (female.isChecked()) {
                        tGender.setText(female.getText());

                    } else if (male.isChecked()) {
                        tGender.setText(male.getText());
                    }

                    tCity.setText(adapter.getItem(pos));
                    tBirthday.setText(birthday.getDayOfMonth() + "/" + birthday.getMonth() + "/" + birthday.getYear());

                    String strHobby1 = hobby1.getText().toString();
                    String strHobby2 = hobby2.getText().toString();
                    String strHobby3 = hobby3.getText().toString();
                    String strHobby4 = hobby4.getText().toString();
                    String strHobbies = "";

                    if (hobby1.isChecked()) {
                        strHobbies = strHobby1;

                    }
                    if (hobby2.isChecked()) {
                        strHobbies = strHobbies + " " + strHobby2;

                    }
                    if (hobby3.isChecked()) {
                        strHobbies = strHobbies + " " + strHobby3;

                    }
                    if (hobby4.isChecked()) {
                        strHobbies = strHobbies + " " + strHobby4;
                    }

                    if (strHobbies == "") {
                        strHobbies = "No tiene hobbies";
                    }

                    tHobbies.setText(strHobbies);

                }else{
                    Context context = getApplicationContext();
                    CharSequence text = "Espacios requeridos en blanco";
                    int duration = Toast.LENGTH_SHORT;
                    Toast msg = Toast.makeText(context,text,duration);
                    msg.show();
                }
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+" selected",Toast.LENGTH_SHORT).show();
                pos = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
