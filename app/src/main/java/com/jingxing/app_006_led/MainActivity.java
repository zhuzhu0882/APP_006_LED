package com.jingxing.app_006_led;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import com.jingxing.hardlibrary.HardControl;

import java.util.zip.CheckedInputStream;

public class MainActivity extends Activity {

    private Button button = null;
    boolean ledon =false ;
    private CheckBox checkboxLed1 = null;
    private CheckBox checkboxLed2 = null;
    private CheckBox checkboxLed3 = null;
    private CheckBox checkboxLed4 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button =(Button) findViewById(R.id.BUTTON);
        checkboxLed1 = (CheckBox) findViewById(R.id.LED1);
        checkboxLed2 = (CheckBox) findViewById(R.id.LED2);
        checkboxLed3 = (CheckBox) findViewById(R.id.LED3);
        checkboxLed4 = (CheckBox) findViewById(R.id.LED4);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                HardControl hardControl =new HardControl();
                ledon =!ledon;
                if(ledon) {
                    button.setText("ALL ON");
                    checkboxLed1.setChecked(true);
                    checkboxLed2.setChecked(true);
                    checkboxLed3.setChecked(true);
                    checkboxLed4.setChecked(true);
                }
                else {
                    button.setText("ALL OFF");
                    checkboxLed1.setChecked(false);
                    checkboxLed2.setChecked(false);
                    checkboxLed3.setChecked(false);
                    checkboxLed4.setChecked(false);
                }
            }
        });
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.LED1 :
                if (checked) {
                    Toast.makeText(getApplicationContext() ,"LED1 ON",Toast.LENGTH_SHORT ).show() ;
                    // Put some meat on the sandwich
                }
                else
                    Toast.makeText(getApplicationContext() ,"LED1 OFF",Toast.LENGTH_SHORT ).show() ;
                // Remove the meat
                break;
            case R.id.LED2:
                if (checked)
                    Toast.makeText(getApplicationContext() ,"LED2 ON",Toast.LENGTH_SHORT ).show() ;
                    // Cheese me
                else
                    Toast.makeText(getApplicationContext() ,"LED1 OFF",Toast.LENGTH_SHORT ).show() ;
                // I'm lactose intolerant
                break;
            // TODO: Veggie sandwich
        }
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

