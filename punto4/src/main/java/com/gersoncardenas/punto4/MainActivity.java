package com.gersoncardenas.punto4;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private TextView result;
    private static String strResult = "text value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText side = (EditText)findViewById(R.id.eSide);
        final EditText base = (EditText)findViewById(R.id.eBase);
        final EditText height = (EditText)findViewById(R.id.eHeight);
        final EditText radius = (EditText)findViewById(R.id.eRadius);

        final RadioButton square = (RadioButton)findViewById(R.id.cSquare);
        final RadioButton triangle = (RadioButton)findViewById(R.id.cTriangle);
        final RadioButton rectangle = (RadioButton)findViewById(R.id.cRectangle);
        final RadioButton circle = (RadioButton)findViewById(R.id.cCircle);

        Button button = (Button)findViewById(R.id.button);

        result = (TextView)findViewById(R.id.tResult);

        if(savedInstanceState !=null){
            String savedText = savedInstanceState.getString(strResult);
            result.setText(savedText);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String strSide = side.getText().toString();
                final String strBase = base.getText().toString();
                final String strHeight = height.getText().toString();
                final String strRadius = radius.getText().toString();

                float numSide;
                float numBase;
                float numHeight;
                float numRadius;
                float numResult = 0;
                boolean error = false;

                Context context = getApplicationContext();
                CharSequence text = "Espacios requeridos en blanco";
                int duration = Toast.LENGTH_SHORT;
                Toast msg = Toast.makeText(context,text,duration);

                if (square.isChecked()) {

                    if(!strSide.isEmpty()) {
                        numSide = Float.parseFloat(strSide);
                        numResult = numSide * numSide;

                    }else{
                        result.setEnabled(false);
                        msg.show();
                        error = true;

                    }

                } else if (triangle.isChecked()) {

                    if(!strBase.isEmpty() && !strHeight.isEmpty()){
                        numBase = Float.parseFloat(strBase);
                        numHeight = Float.parseFloat(strHeight);
                        numResult = (numBase * numHeight) / 2;

                    }else{
                        result.setEnabled(false);
                        msg.show();
                        error = true;
                    }


                } else if (rectangle.isChecked()) {

                    if(!strBase.isEmpty() && !strHeight.isEmpty()){
                        numBase = Float.parseFloat(strBase);
                        numHeight = Float.parseFloat(strHeight);
                        numResult = (numBase * numHeight);

                    }else{
                        result.setEnabled(false);
                        msg.show();
                        error = true;
                    }

                } else if (circle.isChecked()) {

                    if(!strRadius.isEmpty()){
                        numRadius = Float.parseFloat(strRadius);
                        numResult = (float) Math.PI * numRadius * numRadius;

                    }else{
                        result.setEnabled(false);
                        msg.show();
                        error = true;
                    }
                }

                if(!error) {
                    strResult = new Float(numResult).toString();
                    result.setText(strResult);
                    error = false;
                }
            }
        });

        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                side.setEnabled(true);
                base.setEnabled(false);
                height.setEnabled(false);
                radius.setEnabled(false);
            }
        });

        triangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                side.setEnabled(false);
                base.setEnabled(true);
                height.setEnabled(true);
                radius.setEnabled(false);
            }
        });

        rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                side.setEnabled(false);
                base.setEnabled(true);
                height.setEnabled(true);
                radius.setEnabled(false);
            }
        });

        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                side.setEnabled(false);
                base.setEnabled(false);
                height.setEnabled(false);
                radius.setEnabled(true);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(strResult,(String)result.getText());
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
