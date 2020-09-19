package com.practica.practica3gencurprfc;

import java.util.ArrayList;

public class Sexo {
    String nombre;
    String codigo;

    public Sexo(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public Sexo() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public ArrayList<String> getAllSexo(){
        ArrayList<String> lstSexo = new ArrayList<String>();
        lstSexo.add("MUJER");
        lstSexo.add("HOMBRE");
        return lstSexo;

    }


    public String devuelveCodigoSexo (String nombre){

        String codigoSexo="No se encontro el codigo del sexo";
        ArrayList<Sexo> lstSexo = new ArrayList<Sexo>();

        lstSexo.add(new Sexo("MUJER","M"));
        lstSexo.add(new Sexo("HOMBRE","H"));

        for (Sexo objSex : lstSexo) {
            if (nombre==objSex.nombre) codigoSexo = objSex.getCodigo();
        }
        System.out.println("Codigo seleccionado " + codigoSexo);
        return codigoSexo;
    }

}
