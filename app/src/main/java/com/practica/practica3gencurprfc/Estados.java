package com.practica.practica3gencurprfc;

import android.provider.Settings;

import java.util.ArrayList;

public class Estados {

    String nombre;
    String codigo;

    public Estados(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public Estados() {
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

    @Override
    public String toString() {
        return "Estados{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo +
                '}';
    }


    public String devuelveCodigo (String nombre){
        System.out.println("El estado a buscar es " + nombre);

        String codigoEstado="No se encontro el codigo del estado";
        ArrayList<Estados> ListaDeEstados = new ArrayList<Estados>();
        ListaDeEstados.add(new Estados("AGUASCALIENTES","AS"));
        ListaDeEstados.add(new Estados("BAJA CALIFORNIA NTE.","BC"));
        ListaDeEstados.add(new Estados("BAJA CALIFORNIA SUR","BS"));
        ListaDeEstados.add(new Estados("CAMPECHE","CC"));
        ListaDeEstados.add(new Estados("COAHUILA","CL"));
        ListaDeEstados.add(new Estados("COLIMA","CM"));
        ListaDeEstados.add(new Estados("CHIAPAS","CS"));
        ListaDeEstados.add(new Estados("CHIHUAHUA","CH"));
        ListaDeEstados.add(new Estados("DISTRITO FEDERAL","DF"));
        ListaDeEstados.add(new Estados("DURANGO","DG"));
        ListaDeEstados.add(new Estados("GUANAJUATO","GT"));
        ListaDeEstados.add(new Estados("GUERRERO","GR"));
        ListaDeEstados.add(new Estados("HIDALGO","HG"));
        ListaDeEstados.add(new Estados("JALISCO","JC"));
        ListaDeEstados.add(new Estados("MEXICO","MC"));
        ListaDeEstados.add(new Estados("MICHOACAN","MN"));
        ListaDeEstados.add(new Estados("MORELOS","MS"));
        ListaDeEstados.add(new Estados("NAYARIT","NT"));
        ListaDeEstados.add(new Estados("NUEVO LEON","NL"));
        ListaDeEstados.add(new Estados("OAXACA","OC"));
        ListaDeEstados.add(new Estados("PUEBLA","PL"));
        ListaDeEstados.add(new Estados("QUERETARO","QT"));
        ListaDeEstados.add(new Estados("QUINTANA ROO","QR"));
        ListaDeEstados.add(new Estados("SAN LUIS POTOSI","SP"));
        ListaDeEstados.add(new Estados("SINALOA","SL"));
        ListaDeEstados.add(new Estados("SONORA","SR"));
        ListaDeEstados.add(new Estados("TABASCO","TC"));
        ListaDeEstados.add(new Estados("TAMAULIPAS","TS"));
        ListaDeEstados.add(new Estados("TLAXCALA","TL"));
        ListaDeEstados.add(new Estados("VERACRUZ","VZ"));
        ListaDeEstados.add(new Estados("YUCATAN","YN"));
        ListaDeEstados.add(new Estados("ZACATECAS","ZS"));
        ListaDeEstados.add(new Estados("SERV. EXTERIOR MEXICANO","SM"));
        ListaDeEstados.add(new Estados("NACIDO EN EL EXTRANJERO","NE"));

        for (Estados objEst : ListaDeEstados) {
            System.out.println("Entro al ciclo " + nombre );
            if (nombre==objEst.nombre) codigoEstado = objEst.getCodigo();
        }
        System.out.println("Codigo de estado seleccionado " + codigoEstado);
        return codigoEstado;
    }

    public ArrayList<String> getAllEstados(){
        ArrayList<String> listaDeEstados = new ArrayList<String>();
        listaDeEstados.add("AGUASCALIENTES");
        listaDeEstados.add("BAJA CALIFORNIA NTE.");
        listaDeEstados.add("BAJA CALIFORNIA SUR");
        listaDeEstados.add("CAMPECHE");
        listaDeEstados.add("COAHUILA");
        listaDeEstados.add("COLIMA");
        listaDeEstados.add("CHIAPAS");
        listaDeEstados.add("CHIHUAHUA");
        listaDeEstados.add("DISTRITO FEDERAL");
        listaDeEstados.add("DURANGO");
        listaDeEstados.add("GUANAJUATO");
        listaDeEstados.add("GUERRERO");
        listaDeEstados.add("HIDALGO");
        listaDeEstados.add("JALISCO");
        listaDeEstados.add("MEXICO");
        listaDeEstados.add("MICHOACAN");
        listaDeEstados.add("MORELOS");
        listaDeEstados.add("NAYARIT");
        listaDeEstados.add("NUEVO LEON");
        listaDeEstados.add("OAXACA");
        listaDeEstados.add("PUEBLA");
        listaDeEstados.add("QUERETARO");
        listaDeEstados.add("QUINTANA ROO");
        listaDeEstados.add("SAN LUIS POTOSI");
        listaDeEstados.add("SINALOA");
        listaDeEstados.add("SONORA");
        listaDeEstados.add("TABASCO");
        listaDeEstados.add("TAMAULIPAS");
        listaDeEstados.add("TLAXCALA");
        listaDeEstados.add("VERACRUZ");
        listaDeEstados.add("YUCATAN");
        listaDeEstados.add("ZACATECAS");
        listaDeEstados.add("SERV. EXTERIOR MEXICANO");
        listaDeEstados.add("NACIDO EN EL EXTRANJERO");
        return listaDeEstados;

    }

}
