package com.practica.practica3gencurprfc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.text.ParseException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,  AdapterView.OnItemSelectedListener {

    public static final String EXTRA_RFC = "com.practica.practica3gencurprfc.MESSAGE";
    public static final String EXTRA_CURP = "com.practica.practica3gencurprfc.MESSAGE01";
    public static final String EXTRA_EDAD = "com.practica.practica3gencurprfc.MESSAGE02";

    SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");

    Estados estados = new Estados();
    Sexo sexo = new Sexo();

    Button botonCalendario;
    EditText getTxtFecNac;
    Button btnFecNac;
    TextView tFecNac;
    Spinner spnSexo ;
    Spinner spnObjetoVista;
    TextView txtFecNac;

    private int dia, mes, anio;
    String cadenaSelecionada;
    String codigoEntidad;
    String codigoSexo;
    String fechaNacimiento;
    int anioNac, anioActual, edad ;
    int diaNacimiento, mesNacimiento, anioNacimiento;
    String fec_nac;
    String CURP, RFC;
    String añoNac, mesNac, diaNac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFecNac =  (Button) findViewById(R.id.btnCalendario);
        btnFecNac.setOnClickListener(this);
        tFecNac = (TextView) findViewById(R.id.txtFecNac);
        spnSexo = (Spinner) findViewById(R.id.spnSexoVistaXML);
        spnObjetoVista = (Spinner) findViewById(R.id.spnVistaXML);
        cargaEntidades();
        cargaSexo();
    }

    public void generarInformacion(View view){

        Intent intent = new Intent(this, DespliegaIdentificadores.class);

        EditText editText = (EditText) findViewById(R.id.editTextNombre);
        String nombre =editText.getText().toString().toUpperCase();

        EditText editText1 = (EditText) findViewById(R.id.editTextAP);
        String aPaterno = editText1.getText().toString().toUpperCase();

        EditText editText2 = (EditText) findViewById((R.id.editTextAM));
        String aMaterno = editText2.getText().toString().toUpperCase();

        txtFecNac = (TextView) findViewById(R.id.txtFecNac);
        calcularEdad();

        fechaNacimiento = txtFecNac.getText().toString();
        fCadFN(fechaNacimiento);

        generaCurp(aPaterno, aMaterno, nombre, codigoSexo, fec_nac, codigoEntidad);
        generaRFC(aPaterno, aMaterno, nombre, codigoSexo, fec_nac, codigoEntidad);

        intent.putExtra(EXTRA_RFC, RFC);
        startActivity(intent);
        intent.putExtra(EXTRA_CURP, CURP);
        startActivity(intent);
        intent.putExtra(EXTRA_EDAD, String.valueOf(edad));
        startActivity(intent);
    }


    public void generaRFC(String primerApellido, String segundoApellido, String nombres, String sexo,
                          String fechaDeNacimiento, String entidadDeNacimiento ){

        String c1c2 = primerApellido.substring(0,2);
        char c3 = segundoApellido.charAt(0);
        char c4 = nombres.charAt(0);

        añoNac = fec_nac.substring(8,10);
        mesNac = fec_nac.substring(3,5);
        diaNac = fec_nac.substring(0,2);

        int numero = (int) (Math.random()*9+1);
        String n = String.valueOf(numero);
        char c11 = n.charAt(0);

        numero = (int) (Math.random()*9+1);
        String b = String.valueOf(numero);
        char c13 = b.charAt(0);

        RFC = (c1c2+""+c3+""+c4+""+añoNac+mesNac+diaNac+c11+sexo+c13);
        System.out.println("RFC " + RFC);

    }
    public void generaCurp(String primerApellido, String segundoApellido, String nombres, String sexo,
                           String fechaDeNacimiento, String entidadDeNacimiento ){

        char c1 = primerApellido.charAt(0);
        System.out.println("c1" + c1);
        char c2 = 0;

        for (int i = 1; i < primerApellido.length(); i++) {
            char l = primerApellido.charAt(i);
            if(l == 'A' || l == 'E' || l == 'I' || l == 'O' || l == 'U'){
                c2 = l;
                break;
            }
        }
        System.out.println("C2 " + c2);
        char c3 = segundoApellido.charAt(0);
        System.out.println("c3" + c3);

        char c4 = nombres.charAt(0);
        System.out.println("c4" + c4);

        System.out.println("Cadena Fec_Nac " + fec_nac);
        añoNac = fec_nac.substring(8,10);
        System.out.println(" Año nac "+añoNac);

        mesNac = fec_nac.substring(3,5);
        System.out.println("Mes Nac "+ mesNac);
        diaNac = fec_nac.substring(0,2);
        System.out.println("diaNac "+ diaNac);

        System.out.println("Sexo" +sexo);
        System.out.println("Entidad " + entidadDeNacimiento);

        char c14 = 0;

        for (int i = 1; i < primerApellido.length(); i++) {
            char l = primerApellido.charAt(i);
            if(l != 'A' && l != 'E' && l != 'I' && l != 'O' && l != 'U'){ // excluimos a las vocales
                c14 = l;
                break;
            }
        }
        System.out.println("Caracter 14 " +c14);
        char c15 = 0;

        for (int i = 1; i < segundoApellido.length(); i++) {
            char l = segundoApellido.charAt(i);
            if(l != 'A' && l != 'E' && l != 'I' && l != 'O' && l != 'U'){ // excluimos a las vocales
                c15 = l;
                break;
            }
        }
        System.out.println("Caracter 15 " +c15);

        char c16 = 0;

        for (int i = 1; i < nombres.length(); i++) {
            char l = nombres.charAt(i);
            if(l != 'A' && l != 'E' && l != 'I' && l != 'O' && l != 'U'){ // excluimos a las vocales
                c16 = l;
                break;
            }
        }
        System.out.println("Caracter 16 " +c16);

        int numero = (int) (Math.random()*9+1);
        String n = String.valueOf(numero);
        char c17 = n.charAt(0);
        System.out.println("Caracter 17 " +c17);

        numero = (int) (Math.random()*9+1);
        String b = String.valueOf(numero);
        char c18 = b.charAt(0);
        System.out.println("Caracter 18 " +c18);
        CURP = (c1+""+c2+""+c3+""+c4+""+añoNac+mesNac+diaNac+sexo+entidadDeNacimiento+c14+""+c15+""+c16+""+c17+""+c18);
        System.out.println("CURP "+CURP);
    }

    public void fCadFN(String cadena){
        Date feche;
        Date nFecha = null;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        GregorianCalendar gc = new GregorianCalendar();
        try {
            nFecha = formato.parse(cadena);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        feche = new Date(nFecha.getTime());
        gc.setTime(feche);
        formato.applyPattern("dd/MM/yyyy");
        System.out.println("Formateo de fecha " + formato.format(feche));
        fec_nac = formato.format(feche);
}

    public void calcularEdad(){
        //14/3/2019
        fechaNacimiento = txtFecNac.getText().toString();
        Calendar fecActual = Calendar.getInstance();
        anioActual = fecActual.get(Calendar.YEAR);
        System.out.println("anioActual "+ anioActual);
        System.out.println("anioNacimiento "+ anioNacimiento);
        edad =  anioActual-anioNacimiento;
}
    public void cargaEntidades(){
        ArrayList<String> lista = estados.getAllEstados();
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this, R.layout.spinner_layout, R.id.txt, lista );
        spnObjetoVista.setAdapter(adapter);
        spnObjetoVista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cadenaSelecionada = adapterView.getItemAtPosition(i).toString();
                codigoEntidad = estados.devuelveCodigo(cadenaSelecionada);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void cargaSexo(){

        ArrayList<String> lstSexo = sexo.getAllSexo();
        ArrayAdapter<String> adapter01 = new ArrayAdapter<>(this, R.layout.spinner_sexo, R.id.txt, lstSexo);
        spnSexo.setAdapter(adapter01);
        spnSexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cadenaSelecionada = adapterView.getItemAtPosition(i).toString();
                codigoSexo = sexo.devuelveCodigoSexo(cadenaSelecionada);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view==btnFecNac){
            final Calendar c = Calendar.getInstance();
            dia=c.get(Calendar.DAY_OF_MONTH);
            mes=c.get(Calendar.MONTH);
            anio=c.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                    tFecNac.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                    anioNacimiento = year;
                }
            }
            ,dia, mes, anio);
            datePickerDialog.show();
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {

    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}