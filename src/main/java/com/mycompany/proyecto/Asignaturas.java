/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

/**
 *
 * @author cecitowers
 */
public class Asignaturas{
    protected String nombre;
    protected int creditos, semestre;
    protected float calificacion;

    public Asignaturas() {
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return  "\n\n\tNombre: " + nombre + "\n\tCreditos: " + creditos + "\n\tSemestre: " + semestre + "\n\tCalificación: " + calificacion;
    }
    

    
    public List<Asignaturas> estructuraAsignaturas(List<Asignaturas> asignaturas, int tamaño) throws IOException{
        
        String line;
        int n = 0;
        
        while(n<tamaño){
            Asignaturas a = new Asignaturas();
            line = Files.readAllLines(Paths.get("asignaturas.txt")).get(n);
            String[] claves = line.split(",", 3);

            String nombre = claves[0];
            a.setNombre(nombre);

            String creditos = claves[1];
            a.setCreditos(Integer.parseInt(creditos));

            String semestre = claves[2];
            a.setSemestre(Integer.parseInt(semestre));

            Random rnd = new Random();
            int calif = rnd.nextInt(11 - 6) + 6;
            a.setCalificacion(calif);
            
            asignaturas.add(n, a);

            n++;
        }
        
        return asignaturas;
    }
    
}
