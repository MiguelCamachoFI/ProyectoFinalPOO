/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase para generar los datos personales
 * Extiende de la clase Listas
 * @author CeciliaTorres, CeciliaZurita, JacielHernández, MarioTerán, MiguelCamacho
 */
public class GeneradorDatos extends Listas{
    int semestre;
    int edad;
    String direccion;
    String nombreCompleto;
    String calle, asentamiento, municipio, estado;
    int cp, numeroInterior;
    List<GeneradorDatos> datosAlumnos;
    
    public GeneradorDatos() {
    }

    public GeneradorDatos(List<String> nombres, List<String> apellidos) {
        super(nombres, apellidos);
    }

    public GeneradorDatos(List<GeneradorDatos> datosAlumnos) {
        this.datosAlumnos = datosAlumnos;
    }

    public GeneradorDatos(int semestre, int edad, String direccion, String nombres) {
        this.semestre = semestre;
        this.edad = edad;
        this.direccion = direccion;
        this.nombreCompleto = nombreCompleto;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public List<GeneradorDatos> getDatosAlumnos() {
        return datosAlumnos;
    }

    public void setDatosAlumnos(List<GeneradorDatos> datosAlumnos) {
        this.datosAlumnos = datosAlumnos;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombreCompleto + "\nEdad: " + edad + "\nSemestre: " + semestre +  "\nDirección: " + direccion;
    }
    
    /* + + + + + + + + + + + + + + + */
    
    public void datosPersonales(List<GeneradorDatos> datosAlumnos, int cantAlumnos){
        for (int i = 0; i < cantAlumnos; i++) {
            datosAlumnos.add(null);
        }
        GeneradorDatos datos = new GeneradorDatos();
        
        for (int i = 0; i < cantAlumnos; i++) {
            GeneradorDatos l = new GeneradorDatos();
            
            nombreCompleto = nombres();
            semestre = semestre();
            edad = edad();
            direccion = direccion();

            l.setNombreCompleto(nombreCompleto);
            l.setSemestre(semestre);
            l.setEdad(edad);
            l.setDireccion(direccion);
            
            
            datosAlumnos.set(i, l);
       
        }
        
        datos.setDatosAlumnos(datosAlumnos);
    }
    
    private String nombres(){
        Random rnd = new Random();
        String N1,A1;
        int n = rnd.nextInt(49);
        int a = rnd.nextInt(49);
        
        List<String> nom = new ArrayList(50);
        List<String> ap = new ArrayList(50);
        
        GeneradorDatos l = new GeneradorDatos(nom, ap);
        nom = l.estructuraNombres(nom);
        ap = l.estructuraApellidos(ap);
        
        N1 = nom.get(n);
        A1 = ap.get(a);
        
        nombreCompleto = N1 + " " + A1;
        
        return nombreCompleto;
    } 
    
    private int semestre(){
        Random rnd = new Random();
        int n = rnd.nextInt(11 - 1) + 1;
        
        semestre = n;

        return semestre;
    }
    
    private int edad(){
        Random rnd = new Random();
        int n;
        
        if(semestre == 1 || semestre == 2){
            n = rnd.nextInt(21 - 18) + 18;
            edad = n;
        }
        if(semestre == 3 || semestre == 4){
            n = rnd.nextInt(23 - 19) + 19;
            edad = n;  
        }
        if(semestre == 5 || semestre == 6){
            n = rnd.nextInt(25 - 21) + 21;
            edad = n;
        }
        if(semestre == 7 || semestre == 8){
            n = rnd.nextInt(27 - 23) + 23;
            edad = n;
        }
        if(semestre == 9 || semestre == 10){
            n = rnd.nextInt(28 - 24) + 24;
            edad = n;
        }

        return edad;
    }
    
    private String direccion(){
        Random rnd = new Random();
        int n = rnd.nextInt(499);
        int n2 = rnd.nextInt(15);
        int n3 = rnd.nextInt(99999 - 01000) + 01000;
        int n4 = rnd.nextInt(99);
        
        GeneradorDatos l = new GeneradorDatos();
        List<String> asen = new ArrayList(500);
        asen = l.estructuraAsentamientos(asen);
        asentamiento = asen.get(n);
        
        estado = "Ciudad de Mexico";
        
        List<String> deleg = new ArrayList(16);
        deleg = l.estrucutraDelegaciones(deleg);
        municipio = deleg.get(n2);
        
        cp = n3;
        
        numeroInterior = n4;
        
        List<String> av = new ArrayList(500);
        av = l.estructuraCalles(av);
        calle = av.get(n);
        
        direccion = calle + "|" + numeroInterior + "|" + asentamiento + "|" + municipio + "|" + estado + "|" + cp;
        
        return direccion;
    }
}