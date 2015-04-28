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

    private TextView tName, tEmail, tPhone, tGender, tCity, tHobbies, tBirthday;

    private static String strName = "text value";
    private static String strEmail = "text value";
    private static String strPhone = "text value";
    private static String strGender = "text value";
    private static String strCity = "text value";
    private static String strHobbies = "No tiene hobbies";
    private static String strBirthday = "text value";

    private int pos;

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

        tName = (TextView)findViewById(R.id.tNombre);
        tEmail = (TextView)findViewById(R.id.tCorreo);
        tPhone = (TextView)findViewById(R.id.tTel);
        tGender = (TextView)findViewById(R.id.tGender);
        tCity = (TextView)findViewById(R.id.tCity);
        tHobbies = (TextView)findViewById(R.id.tHobbies);
        tBirthday = (TextView)findViewById(R.id.tBirthday);

        if(savedInstanceState != null){
            String savedName = savedInstanceState.getString(strName);
            tName.setText(savedName);
            String savedEmail = savedInstanceState.getString(strEmail);
            tEmail.setText(savedEmail);
            String savedPhone = savedInstanceState.getString(strPhone);
            tPhone.setText(savedPhone);
            String savedGender = savedInstanceState.getString(strGender);
            tGender.setText(savedGender);
            String savedCity = savedInstanceState.getString(strCity);
            tCity.setText(savedCity);
            String savedHobbies = savedInstanceState.getString(strHobbies);
            tHobbies.setText(savedHobbies);
            String savedBirthday = savedInstanceState.getString(strBirthday);
            tBirthday.setText(savedBirthday);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                strName = name.getText().toString();
                strEmail = email.getText().toString();
                strPhone = phone.getText().toString();

                if(!strName.isEmpty() && !strEmail.isEmpty() && !strPhone.isEmpty()) {

                    tName.setText(strName);
                    tEmail.setText(strEmail);
                    tPhone.setText(strPhone);

                    if (female.isChecked()) {
                        strGender = (String)female.getText();
                        tGender.setText(strGender);

                    } else if (male.isChecked()) {
                        strGender = (String)male.getText();
                        tGender.setText(male.getText());
                    }

                    strCity = (String)adapter.getItem(pos);
                    tCity.setText(strCity);

                    strBirthday = birthday.getDayOfMonth() + "/" + (birthday.getMonth()+1) + "/" + birthday.getYear();
                    tBirthday.setText(strBirthday);

                    String strHobby1 = hobby1.getText().toString();
                    String strHobby2 = hobby2.getText().toString();
                    String strHobby3 = hobby3.getText().toString();
                    String strHobby4 = hobby4.getText().toString();

                    if (hobby1.isChecked()) {
                        strHobbies = strHobby1;

                    }if (hobby2.isChecked()) {
                        strHobbies = strHobbies + " " + strHobby2;

                    }if (hobby3.isChecked()) {
                        strHobbies = strHobbies + " " + strHobby3;

                    }if (hobby4.isChecked()) {
                        strHobbies = strHobbies + " " + strHobby4;
                    }if (strHobbies == "") {
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
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(strName, (String) tName.getText());
        outState.putString(strEmail,(String) tEmail.getText());
        outState.putString(strPhone,(String) tPhone.getText());
        outState.putString(strGender,(String) tGender.getText());
        outState.putString(strCity,(String) tCity.getText());
        outState.putString(strHobbies,(String) tHobbies.getText());
        outState.putString(strBirthday,(String) tBirthday.getText());
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
