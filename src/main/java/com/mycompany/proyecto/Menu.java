/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal
 * @author CeciliaTorres, CeciliaZurita, JacielHernández, MarioTerán, MiguelCamacho
 */
public class Menu {
    /**
     * Método principal
     * @param args array de strings
     * @throws IOException en caso de que no se ingrese una opción válida
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        int opcion, cantidad = 0;
        
        List<GeneradorDatos> datosAlumnos = new ArrayList();
        List<GeneradorRegistros> registrosAlumnos = new ArrayList();
        GeneradorRegistros registros = new GeneradorRegistros();
        
        do {
            System.out.println("\n\n\tS i s t e m a  d e  g e s t i ó n  e s c o l a r\n");
            System.out.println(" 1. Generar registros de alumnos");
            System.out.println(" 2. Generar números de inscripción");
            System.out.println(" 3. Buscar alumno");
            System.out.println(" 4. Modificar registro");
            System.out.println(" 5. Generar archivo *.csv");
            System.out.println(" 6. Salir");
            System.out.println(" -> Selecciona una opción:");
            opcion = sc.nextInt();
            
            switch(opcion){
                case 1:
                    System.out.println("\n- - - Generar registro - - -");
                    
                    System.out.println("a. ¿Cuántos registros desea generar?");
                    cantidad = sc.nextInt();
                    
                    System.out.println("\nSe generaron los siguientes registros académicos:");
                    registros.registrosAcademicos(datosAlumnos, registrosAlumnos, cantidad);
                    
                    break;
                    
                case 2:
                    System.out.println("\n- - - Generar número de inscripción - - -");
                    registros.numerosDeInscripción(registrosAlumnos);
                    break;
                    
                case 3:
                    System.out.println("\n- - - Buscar alumno - - -");
                    registros.buscar(registrosAlumnos);
                    break;
                    
                case 4:   
                    System.out.println("\n- - - Modificar registro - - -");
                    System.out.println("Ingresa el número de cuenta del alumno: ");
                    int cuenta = sc.nextInt();
                    registros.CRUD(cuenta, registrosAlumnos, registros);
                    break;
                    
                case 5:
                    System.out.println("\n- - - Generar archivo *.csv - - -");
                    ArchivoCSV archivo = new ArchivoCSV();
                    archivo.crear(registrosAlumnos);
                    System.out.println("Se ha generado el archivo");
                    break;
                    
                    
                case 6:
                    System.out.println("\n- - - Salir - - -");
                    salir = true;
                    break;
                    
                default:
                    throw new AssertionError();
            }
        } while(!salir);
        
    }
}
