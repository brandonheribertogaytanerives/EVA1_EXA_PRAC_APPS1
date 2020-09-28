package com.example.areacirculo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtRadio;
    TextView txtAng;
    SeekBar  SeekBarAng;
    Button btnCal;
    int Ang = 0;
    int Rad = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtRadio = findViewById(R.id.txtint);
        txtAng = findViewById(R.id.txtviewAng);
        SeekBarAng = findViewById(R.id.seekBar);
        btnCal = findViewById(R.id.btncalculador);




        SeekBarAng.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                txtAng.setText(Integer.toString(i));
                Ang = i;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }


        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        btnCal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Rad = Integer.parseInt(txtRadio.getText().toString());
                CalcVol(Ang, Rad);
            }
        });
    }

    public void CalcVol(int A, int R){
        double Vol = ((float)2/3)*(A*(Math.pow(R, 3)));
        Toast.makeText(this,"El volumen es: " + Vol, Toast.LENGTH_SHORT).show();
    }


}