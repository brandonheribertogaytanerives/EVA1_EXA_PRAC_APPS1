package com.example.acredita_noacredita;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtNomb, txtNumCont;
    TextView txtPuntosAcre, txtCalifi, txtResultado;
    SeekBar skBPuntos, skBCalifi;
    ImageView imgVwTec1, imgVwTec2, imgVwTec3;

    String punto = "Puntos para acreditar: ";
    String califi = "Calificación: ";
    String ACRE = "ACREDITADO";
    String NOACRE = "NO ACREDITADO";

    int cero = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgVwTec1 = findViewById(R.id.imgVwTec1);
        imgVwTec1.setImageResource(R.drawable.tec1);

        imgVwTec2 = findViewById(R.id.imgVwTec2);
        imgVwTec2.setImageResource(R.drawable.tec2);

        imgVwTec3 = findViewById(R.id.imgVwTec3);
        imgVwTec3.setImageResource(R.drawable.tec3);

        txtNomb = findViewById(R.id.txtNomb);
        txtNumCont = findViewById(R.id.txtNumCont);
        txtPuntosAcre = findViewById(R.id.txtPuntosAcre);
        txtCalifi = findViewById(R.id.txtCalifi);
        txtResultado = findViewById(R.id.txtResultado);
        skBPuntos = findViewById(R.id.skBPuntos);
        skBCalifi = findViewById(R.id.skBCalifi);
        skBPuntos.setMax(100);
        skBCalifi.setMax(100);
        txtPuntosAcre.setText(punto + 0);
        txtCalifi.setText(califi + 0);
        txtResultado.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        skBPuntos.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                txtPuntosAcre.setText(punto + skBPuntos.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        skBCalifi.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            txtCalifi.setText(califi + skBCalifi.getProgress());
                if(IsApproved(skBPuntos.getProgress(), skBCalifi.getProgress())){
                    txtResultado.setVisibility(View.VISIBLE);
                    txtResultado.setText(ACRE);
                }
                else{
                    txtResultado.setVisibility(View.VISIBLE);
                    txtResultado.setText(NOACRE);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        }
    private Boolean IsApproved(int miCalifi, int califi){
        return califi >= miCalifi;
    }
    }

