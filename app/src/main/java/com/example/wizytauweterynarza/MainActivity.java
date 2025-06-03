package com.example.wizytauweterynarza;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText imieNazwisko, celWizyty;
    Spinner spinner;
    SeekBar mySeekBar;
    TextView ileMaLatProgress, data;
    TimePicker timePicker;
    Button button;
    String wybranyGatunek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imieNazwisko = findViewById(R.id.imieNazwisko);
        celWizyty = findViewById(R.id.celWizyty);
        spinner = findViewById(R.id.spinner);
        mySeekBar = findViewById(R.id.mySeekBar);
        ileMaLatProgress = findViewById(R.id.ileMaLatProgress);
        button = findViewById(R.id.button);
        data = findViewById(R.id.data);

        wybranyGatunek = "";

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.gatunek_spinner_options_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                wybranyGatunek = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                ileMaLatProgress.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        timePicker = findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        timePicker.setHour(16);
        timePicker.setMinute(00);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.setText("Imie i nazwisko: "+imieNazwisko.getText()+ ", gatunek zwirzęta: " + wybranyGatunek + ", wiek: " + ileMaLatProgress.getText()
                        + ", cel wizyty - " + celWizyty.getText() + ", czas wizyty - " + timePicker.getHour() + ":" + timePicker.getMinute());
            }
        });

    }
}