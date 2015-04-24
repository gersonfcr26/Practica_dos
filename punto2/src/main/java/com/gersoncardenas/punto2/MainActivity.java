package com.gersoncardenas.punto2;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText op1 = (EditText)findViewById(R.id.eOp1);
        final EditText op2 = (EditText)findViewById(R.id.eOp2);

        final CheckBox add = (CheckBox)findViewById(R.id.eAdd);
        final CheckBox sub = (CheckBox)findViewById(R.id.eSub);
        final CheckBox mul = (CheckBox)findViewById(R.id.eMult);
        final CheckBox div = (CheckBox)findViewById(R.id.eDiv);

        final Button button = (Button)findViewById(R.id.eButton);

        final TextView result = (TextView)findViewById(R.id.eResult);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strNum1 = op1.getText().toString();
                String strNum2 = op2.getText().toString();

                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                CharSequence text = "Espacios requeridos en blanco!";
                Toast msg = Toast.makeText(context,text,duration);

                if(!strNum1.isEmpty() && !strNum2.isEmpty()) {

                    float num1 = Float.parseFloat(strNum1);
                    float num2 = Float.parseFloat(strNum2);

                    float resultOp = 0;

                    String strResult = "";

                    if (add.isChecked()) {
                        resultOp = num1 + num2;

                    } else if (sub.isChecked()) {
                        resultOp = num1 - num2;

                    } else if (mul.isChecked()) {
                        resultOp = num1 * num2;

                    } else if (div.isChecked()) {
                        resultOp = num1 / num2;
                    }

                    if (div.isChecked() && num2 == 0) {
                        result.setEnabled(false);
                        msg = Toast.makeText(context,"Error, división por cero!",duration);
                        msg.show();

                    } else {
                        result.setEnabled(true);
                        strResult = new Float(resultOp).toString();
                    }

                    result.setText(strResult);

                }else{
                    result.setEnabled(false);
                    msg.show();
                }
            }
        });

        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                sub.setChecked(false);
                mul.setChecked(false);
                div.setChecked(false);
            }
        });

        sub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                add.setChecked(false);
                mul.setChecked(false);
                div.setChecked(false);
            }
        });

        mul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                sub.setChecked(false);
                add.setChecked(false);
                div.setChecked(false);
            }
        });

        div.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                sub.setChecked(false);
                mul.setChecked(false);
                add.setChecked(false);
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
