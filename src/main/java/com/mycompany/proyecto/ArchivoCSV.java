/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author cecitowers
 */
public class ArchivoCSV{
    
    public void crear(List<GeneradorRegistros> registrosAlumnos){
        
        try{
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileWriter fw = new FileWriter("registrosAcademicos.csv"); 
            BufferedWriter bw = new BufferedWriter(fw);
            try (PrintWriter salida = new PrintWriter(fw)) {
                salida.println("Nombre completo,Edad,Semestre,Dirección,Número de cuenta,Asignaturas Aprobadas,Promedio,Escolaridad,Velocidad,Número de Inscripción");
                
                for(GeneradorRegistros reg : registrosAlumnos)
                    salida.println(reg.nombreCompleto+","+reg.edad+","+reg.semestre+","+reg.direccion+","+reg.numeroCuenta+","+reg.asignaturasAprobadas+" de "+((reg.semestre)*5)+","+
                            reg.promedio+","+reg.escolaridad+","+reg.velocidad+","+reg.numeroInscripcion);
            }
        } 
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }

}
