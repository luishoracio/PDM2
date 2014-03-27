package com.tec2.pdm2.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class SettingsActivity extends ActionBarActivity {
    ToggleButton toggleButton;
    ToggleButton toggleButton2;
    String FILENAME = "hello_file";
    String string = "hello world!";
    EditText editText ;

    public void guardarPreferencias(View v){

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putBoolean("Opcion1", toggleButton.isChecked() );
        editor.putBoolean("Opcion2", toggleButton2.isChecked() );
        editor.commit();

        try {
            FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write(string.getBytes());
            fos.close();
        }
        catch (FileNotFoundException e){}
        catch (IOException e){}

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        toggleButton = (ToggleButton)findViewById(R.id.toggleButton);
        toggleButton2 = (ToggleButton)findViewById(R.id.toggleButton2);
        editText = (EditText)findViewById(R.id.txtOtro);

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);

        boolean estado = sharedPref.getBoolean("Opcion1", false);
        boolean estado2 = sharedPref.getBoolean("Opcion2", false);

        toggleButton.setChecked(estado);
        toggleButton2.setChecked(estado2);

        try{
            FileInputStream fos = openFileInput(FILENAME);
            //String string = fos.read();
            fos.close();
        }
        catch(IOException e){}
        //catch ()

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.settings, menu);
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
