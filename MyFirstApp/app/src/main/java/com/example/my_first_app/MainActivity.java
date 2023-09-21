package com.example.my_first_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spnGenero = (Spinner) findViewById(R.id.spnGenero);

        String[] opciones = {"Seleccione","Masculino", "Femenino", "Otro"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spnGenero.setAdapter(adapter);
    }

    public void sendData(View view) {

        EditText nombre = (EditText)findViewById(R.id.txtNombre);
        EditText apellido = (EditText)findViewById(R.id.txtApellido);
        EditText fecha = (EditText)findViewById(R.id.editTextDate);

        Button btnCaledario = (Button)findViewById(R.id.btnCalendario);


        ArrayList<String> lenguajesSeleccionados = new ArrayList<>();

        CheckBox[] checkboxes = {
                (CheckBox)findViewById(R.id.cbxJava),
                (CheckBox)findViewById(R.id.cbxPython),
                (CheckBox)findViewById(R.id.cbxJs),
                (CheckBox)findViewById(R.id.cbxGo),
                (CheckBox)findViewById(R.id.cbxC),
                (CheckBox)findViewById(R.id.cbxCsharp)
        };

        for (CheckBox checkBox : checkboxes) {
            if (checkBox.isChecked()) {
                lenguajesSeleccionados.add(checkBox.getText().toString());
            }
        }


        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radGroup);
        String gusto = "";

        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();

        if (selectedRadioButtonId != -1) {
            RadioButton selectedRadioButton = (RadioButton)findViewById(selectedRadioButtonId);

            gusto = selectedRadioButton.getText().toString();

        } else {
            gusto = "Sin gusto seleccionado";
        }

        Spinner spnGenero = (Spinner)findViewById(R.id.spnGenero);

        String genero = String.valueOf(spnGenero.getSelectedItem());


        if (nombre.getText().toString().isEmpty()
                || apellido.getText().toString().equalsIgnoreCase("")
                || genero.equalsIgnoreCase("Seleccione") || lenguajesSeleccionados.size() == 0)
        {
            Toast.makeText(this, "Faltan campos por rellenar", Toast.LENGTH_LONG).show();
            System.out.println("IF WORKING");
            return;
        }

        if (gusto.equalsIgnoreCase("No")) {
            for (CheckBox checkBox : checkboxes) {
                checkBox.setEnabled(false);
            }
        }


        Bundle datosEnviados = new Bundle();

        datosEnviados.putString("nombre",nombre.getText().toString());
        datosEnviados.putString("apellido", apellido.getText().toString());
        datosEnviados.putString("fecha", fecha.getText().toString());
        datosEnviados.putString("genero",genero);
        datosEnviados.putString("gusto", gusto);
        datosEnviados.putStringArrayList("seleccionados", lenguajesSeleccionados);

        Intent intent = new Intent(MainActivity.this, resultActivity.class);
        intent.putExtras(datosEnviados);
        startActivity(intent);

    }

    public void handleCalendario (View v) {
        final Calendar calendario = Calendar.getInstance();
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH);
        int anio = calendario.get(Calendar.YEAR);

        DatePickerDialog datepicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                EditText fecha = (EditText)findViewById(R.id.editTextDate);
                fecha.setText(day+"/"+(month+1)+"/"+year);
            }
        }
        , dia, mes, anio);
        datepicker.show();
    }

    public void enableLenguages (View v) {

        CheckBox[] checkboxes = {
                (CheckBox)findViewById(R.id.cbxJava),
                (CheckBox)findViewById(R.id.cbxPython),
                (CheckBox)findViewById(R.id.cbxJs),
                (CheckBox)findViewById(R.id.cbxGo),
                (CheckBox)findViewById(R.id.cbxC),
                (CheckBox)findViewById(R.id.cbxCsharp)
        };


        if (v==(RadioButton)findViewById(R.id.rbtnNo)) {
            for (CheckBox checkBox : checkboxes) {
                checkBox.setEnabled(false);
            }
        } else {
            for (CheckBox checkBox : checkboxes) {
                checkBox.setEnabled(true);
            }
        }
    }

}