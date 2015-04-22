package com.gersoncardenas.punto3;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText quiz = (EditText)findViewById(R.id.eQuiz);
        final EditText expo = (EditText)findViewById(R.id.eExpo);
        final EditText lab = (EditText)findViewById(R.id.eLab);
        final EditText pFinal = (EditText)findViewById(R.id.eFinal);

        final Button button = (Button)findViewById(R.id.button);

        final TextView result = (TextView)findViewById(R.id.eScore);
        final TextView text = (TextView)findViewById(R.id.eText);

        text.setEnabled(false);

        //final float scoreQuiz, scoreExpo, scoreLab, scoreFinal, totalScore;
        //final String strQuiz, strExpo, strLab, strFinal, strTotal;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String strQuiz = quiz.getText().toString();
                final String strExpo = expo.getText().toString();
                final String strLab = lab.getText().toString();
                final String strFinal = pFinal.getText().toString();

                if(!strQuiz.isEmpty() && !strExpo.isEmpty() && !strLab.isEmpty() && !strFinal.isEmpty()) {

                    final float scoreQuiz = Float.parseFloat(strQuiz);
                    final float scoreExpo = Float.parseFloat(strExpo);
                    final float scoreLab = Float.parseFloat(strLab);
                    final float scoreFinal = Float.parseFloat(strFinal);

                    if(scoreQuiz >= 0 && scoreQuiz <= 5 && scoreExpo >= 0 && scoreExpo <= 5 && scoreLab >= 0 && scoreLab <= 5 && scoreFinal >= 0 && scoreFinal <= 5) {
                        final float totalScore = 0.15f * scoreQuiz + 0.1f * scoreExpo + 0.4f * scoreLab + 0.35f * scoreFinal;
                        final String strTotal = new Float(totalScore).toString();
                        text.setEnabled(true);
                        result.setText(strTotal);

                    }else{
                        result.setText("Valores invalidos!");
                        text.setEnabled(false);
                    }

                }else{
                    result.setText("Hay espacios en blanco!");
                    text.setEnabled(false);
                }
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
