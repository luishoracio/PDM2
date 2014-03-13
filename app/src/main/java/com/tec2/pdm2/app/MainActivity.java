package com.tec2.pdm2.app;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
    private TextView respuesta;
    private ImageView animacion;
    private Button button;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Intent intent= new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);*/

        //respuesta = (TextView)findViewById(R.id.textview1);
        animarTexto();

        animacion = (ImageView)findViewById(R.id.imageView);
        button = (Button)findViewById(R.id.boton);
        button2 = (Button)findViewById(R.id.boton2);
        button3 = (Button)findViewById(R.id.boton3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animarImagen();
                reproducirSonido();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarActivity();
            }
        }
        );


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarWebAppActivity();
            }
        }
        );
    }

    private void cambiarActivity(){
        Intent intent = new Intent(this, InternetActivity.class);
        startActivityForResult(intent, 0);
    }

    private void cambiarWebAppActivity(){
        Intent intent = new Intent(this, WebActivity.class);
        startActivityForResult(intent,0);
    }

    private void reproducirSonido() {
        MediaPlayer reproductor = MediaPlayer.create(this, R.raw.explosion);
        reproductor.start();
        reproductor.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }

    private void animarImagen() {
        animacion.setImageResource(R.drawable.animation);
        AnimationDrawable animationDrawable  = (AnimationDrawable) animacion.getDrawable();
        if(animationDrawable.isRunning()){
            animationDrawable.stop();
        }
        animationDrawable.start();
    }

    private void animarTexto() {
        /*AlphaAnimation fadeIn = new AlphaAnimation(0,1);
        fadeIn.setDuration(3000);
        fadeIn.setFillAfter(true);
        respuesta.setAnimation(fadeIn);*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
