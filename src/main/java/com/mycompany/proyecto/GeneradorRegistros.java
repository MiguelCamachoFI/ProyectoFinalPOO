/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase para generar los registros académicos
 * Extiende de la clase GeneradorDatos
 * @author CeciliaTorres, CeciliaZurita, JacielHernández, MarioTerán, MiguelCamacho
 */
public class GeneradorRegistros extends GeneradorDatos{
    List<Asignaturas> asignaturas;
    int numeroCuenta, numeroInscripcion, asignaturasAprobadas, creditosTotales;
    float escolaridad, velocidad, promedio, indicadorEscolar;

    /**
     * Constructor vacío
     */
    public GeneradorRegistros() {
    }

    /**
     * Sobrecarga del constructor con atributos del generador de datos
     * @param datosAlumnos lista con todos los datos de los alumnos
     */
    public GeneradorRegistros(List<GeneradorDatos> datosAlumnos) {
        super(datosAlumnos);
    }

    /**
     * Setter para definir las asignaturas 
     * @param asignaturas asignaturas que el alumno a cursado
     */
    public void setAsignaturas(List<Asignaturas> asignaturas) {
        this.asignaturas = asignaturas;
    }

    /**
     * Setter para definir el promedio
     * @param promedio promedio actual del alumno
     */
    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    /**
     * Setter para definir la escolaridad
     * @param escolaridad escolaridad actual del alumno
     */
    public void setEscolaridad(float escolaridad) {
        this.escolaridad = escolaridad;
    }

    /**
     * Setter para definir la velocidad
     * @param velocidad velocidad actual del alumno
     */
    public void setVelocidad(float velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * Setter para definir el número de cuenta
     * @param numeroCuenta número de cuenta del alumno
     */
    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setIndicadorEscolar(float indicadorEscolar) {
        this.indicadorEscolar = indicadorEscolar;
    }
    

    /**
     * Setter para definir el número de inscripción
     * @param numeroInscripcion número de inscripción del alumno
     */
    public void setNumeroInscripcion(int numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }

    public void setAsignaturasAprobadas(int asignaturasAprobadas) {
        this.asignaturasAprobadas = asignaturasAprobadas;
    }
    
    

    public List<Asignaturas> getAsignaturas() {
        return asignaturas;
    }

    public float getPromedio() {
        return promedio;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public int getAsignaturasAprobadas() {
        return asignaturasAprobadas;
    }

    public float getIndicadorEscolar() {
        return indicadorEscolar;
    }
    
    /**
     * Override que permite imprimir todas las variables del objeto GeneradorDatos y GeneradoRegistros
     * @return datos del generador de datos y el generador de registros
     */
    
    @Override    
    public String toString() {
        String cadena = asignaturas.toString().replaceAll(", ", "");
        cadena = cadena.substring(1, cadena.length() - 1);
        return super.toString() + "\nNúmero de Cuenta: " + numeroCuenta  + "\n\nAsignaturas cursadas hasta el momento: "+ cadena + 
                "\n\nPromedio global: " + promedio + "\nEscolaridad: " + escolaridad + "\nVelocidad: " + velocidad+  "\nNúmero de Inscipción: " + numeroInscripcion ;
    }
    

    /* + + + + + + + + + + + + + + + */
    /**
     * Método para juntar todos los datos correspondientes al registro académico
     * @param datosAlumnos lista con todos los datos personales de los alumnos 
     * @param registrosAlumnos lista con todos los registros académicos de los alumnos
     * @param cant cantidad de registros generados
     * @throws java.io.IOException
     */
    public void registrosAcademicos(List<GeneradorDatos> datosAlumnos, List<GeneradorRegistros> registrosAlumnos, int cant) throws IOException {
        for (int i = 0; i < cant; i++) {
            registrosAlumnos.add(null);
        }
        
        List<Asignaturas> lAsignatura = new ArrayList();
        
        for (int i = 0; i < cant; i++) {
            GeneradorRegistros l = new GeneradorRegistros(datosAlumnos);
           
            l.datosPersonales(datosAlumnos, cant);
            semestre = l.getSemestre();
            
            asignaturas = asignaturas();
            escolaridad = escolaridad(semestre);
            promedio = promedio();
            velocidad = velocidad();
            numeroCuenta = numeroCuenta();
            indicadorEscolar = indicadorEscolar();
            
            l.setDatosAlumnos(datosAlumnos);
            l.setAsignaturas(asignaturas);
            l.setEscolaridad(escolaridad);
            l.setPromedio(promedio);
            l.setVelocidad(velocidad);
            l.setNumeroCuenta(numeroCuenta);
            l.setIndicadorEscolar(indicadorEscolar);
            l.setAsignaturasAprobadas(asignaturasAprobadas);
            
            registrosAlumnos.set(i, l);
        }
        
        imprimirRegistros(registrosAlumnos);
        
        
    }
    public void numerosDeInscripción(List<GeneradorRegistros> registrosAlumnos){
        NumeroDeInscripcion Ordenador = new NumeroDeInscripcion();
        Ordenador.QuickSort(registrosAlumnos, 0, registrosAlumnos.size() - 1);
        for (int i = 0; i < registrosAlumnos.size(); i++) {
            registrosAlumnos.get(i).setNumeroInscripcion(i+1);
            
        }
        imprimirRegistros(registrosAlumnos);
    }
    
    public void imprimirRegistros(List<GeneradorRegistros> registrosAlumnos){
        for(GeneradorRegistros n : registrosAlumnos){
            System.out.println(n);
        }
    }
    
    private List<Asignaturas> asignaturas() throws IOException{
        Random rnd = new Random();
        
        int inscritas = semestre*5;
        asignaturasAprobadas = rnd.nextInt((inscritas+1) - (semestre*3)) + (semestre*3);
        int reprobadas = inscritas - asignaturasAprobadas;
        
        Asignaturas a = new Asignaturas();
        List<Asignaturas> posibles = new ArrayList<>();
        posibles = a.estructuraAsignaturas(posibles, inscritas);
        
        creditosTotales = 0;
        for (int i = 0; i < posibles.size(); i++) {
            creditosTotales += posibles.get(i).creditos;
        }

        int n;
        for(int i = 0; i < reprobadas; i++) {
            n = rnd.nextInt(posibles.size()-1);
            posibles.remove(n);
        }
        
        return posibles;
    }
    
    private float escolaridad(int semestre){
        int asignaturasInscritas = semestre*5;
        
        float n = ((float)asignaturasAprobadas/(float)asignaturasInscritas)*100;
        String dosDecim = String.format("%.2f", n);
        
        escolaridad = Float.parseFloat(dosDecim);

        return escolaridad;
    }
    
    private float promedio(){
        float calif = 0;
        for (int i = 0; i < asignaturas.size(); i++) {
            calif += asignaturas.get(i).calificacion;
        }
        
        int inscritas = semestre*5;
        int reprobadas = inscritas - asignaturasAprobadas;
        int califReprobadas = reprobadas*5;
        calif = calif + califReprobadas;
        
        float n = calif/inscritas;
        
        String dosDecim = String.format("%.2f", n);
        
        promedio = Float.parseFloat(dosDecim);
        
        return promedio;
    }
    
    private float velocidad(){
        int creditosAlumno = 0;
        
        for (int i = 0; i < asignaturas.size(); i++) {
            creditosAlumno += asignaturas.get(i).creditos;
        }

        float n = ((float)creditosAlumno/(float)creditosTotales)*100;
        String dosDecim = String.format("%.2f", n);
        
        velocidad = Float.parseFloat(dosDecim);
        
        return velocidad;
        
    }
    
    /**
     * Genera aleatoriamente un número de cuenta de seis dígitos
     * @return número de cuenta del alumno
     */
    private int numeroCuenta(){
        Random rnd = new Random();
        int n = rnd.nextInt(999999);
        String seisDig = String.format("%06d", n);
        
        numeroCuenta = Integer.parseInt(seisDig);
        
        return numeroCuenta;
    }
    
    
    private float indicadorEscolar(){
        return indicadorEscolar=velocidad*escolaridad*promedio;
    }
    
    public void buscar(List<GeneradorRegistros> registrosAlumnos){
        Scanner sc = new Scanner(System.in);
        Scanner dos = new Scanner(System.in);
        int opcion;
        boolean encontrado = false;
        
        do{
            System.out.println("Ingrese por qué parámetro desea buscar al alumno");
            System.out.println("1. Nombre completo\n2. Edad\n3. Semestre\n4. Dirección\n5. Asignaturas\n6. Promedio global"
                    + "\n7. Número de inscripción\n8. Número de cuenta\n9. Salir de buscar");
            System.out.println(" -> Selecciona una opción:");
            opcion = sc.nextInt();
            
            
            switch(opcion){
                case 1:
                    System.out.println("Ingrese el nombre completo del alumno a buscar: ");
                    String nom = dos.nextLine();
                    for(GeneradorRegistros n : registrosAlumnos){
                        if(n.getNombreCompleto().equals(nom)){
                            System.out.println("Se encontró al alumno: " + n.toString());
                            encontrado = true;
                        }
                    }
                    if(encontrado == false)
                        System.out.println("Alumno no encontrado");
                    break;
                    
                case 2:
                    System.out.println("Ingrese la edad del alumno a buscar: ");
                    int ed = sc.nextInt();
                    for(GeneradorRegistros n : registrosAlumnos){
                        if(n.getEdad() == ed){
                            System.out.println("Se encontró al alumno: " + n.toString());
                            encontrado = true;
                        }
                    }
                    if(encontrado == false)
                        System.out.println("Alumno no encontrado");
                    break;
                    
                case 3:
                    System.out.println("Ingrese el semestre del alumno a buscar: ");
                    int sem = sc.nextInt();
                    for(GeneradorRegistros n : registrosAlumnos){
                        if(n.getSemestre() == sem){
                            System.out.println("Se encontró al alumno: " + n.toString());
                            encontrado = true;
                        }
                    }
                    if(encontrado == false)
                        System.out.println("Alumno no encontrado");
                    break;
                    
                case 4:
                    System.out.println("Ingrese la dirección del alumno a buscar: ");
                    Scanner d = new Scanner(System.in);
                    String dir = d.nextLine();
                    for(GeneradorRegistros n : registrosAlumnos){
                        if(n.getDireccion().equals(dir)){
                            System.out.println("Se encontró al alumno: " + n.toString());
                            encontrado = true;
                        }
                    }
                    if(encontrado == false)
                        System.out.println("Alumno no encontrado");
                    break;
                    
                case 5:
                    
                    break;
                    
                case 6:
                    System.out.println("Ingrese el promedio global del alumno a buscar: ");
                    int prom = sc.nextInt();
                    for(GeneradorRegistros n : registrosAlumnos){
                        if(n.getPromedio() == prom){
                            System.out.println("Se encontró al alumno: " + n.toString());
                            encontrado = true;
                        }
                    }
                    if(encontrado == false)
                        System.out.println("Alumno no encontrado");
                    break;
                    
                case 7:
                    System.out.println("Ingrese el número de inscripción del alumno a buscar: ");
                    int numInsc = sc.nextInt();
                    for(GeneradorRegistros n : registrosAlumnos){
                        if(n.getNumeroInscripcion() == numInsc){
                            System.out.println("Se encontró al alumno: " + n.toString());
                            encontrado = true;
                        }
                    }
                    if(encontrado == false)
                        System.out.println("Alumno no encontrado");
                    break;
                    
                case 8:
                    System.out.println("Ingrese el número de cuenta del alumno a buscar: ");
                    int numC = sc.nextInt();
                    for(GeneradorRegistros n : registrosAlumnos){
                        if(n.getNumeroCuenta() == numC){
                            System.out.println("Se encontró al alumno: " + n.toString());
                            encontrado = true;
                        }
                    }
                    if(encontrado == false)
                        System.out.println("Alumno no encontrado");
                    break;
                    
                case 9:
                    System.out.println("Se eligió salir de la búsqueda");
                    break;
                    
                default:
                    System.out.println("Opción inválida");
            }
            
            System.out.println("\n");
            
        }while(opcion != 9);
    }
    
    public void CRUD(int numeroCuenta, List<GeneradorRegistros> registrosAlumnos, GeneradorRegistros alumno) throws IOException{
        Scanner sc = new Scanner(System.in);
        String opcion;
        int index = 0;
        
        for(int i = 0; i < registrosAlumnos.size(); i++){
            if(registrosAlumnos.get(i).numeroCuenta == numeroCuenta){
                System.out.println("\nEl registro del alumno es: ");
                alumno = registrosAlumnos.get(i);
                System.out.println(alumno);
                index = i;
            }
        }
        
        do{
            System.out.println("\n¿Qué apartado desea modificar?");
            System.out.println("1. Nombre completo\n2. Edad\n3. Semestre\n4. Dirección\n5. Asignaturas\n6. Promedio global"
                    + "\n7. Escolaridad\n8. Velocidad\n9. Número de cuenta\n10. Salir del CRUD");
            System.out.println(" -> Selecciona una opción:");
            opcion = sc.nextLine();
            
            switch(opcion){
                case "1":
                    System.out.println("\nIngrese el nuevo nombre completo: ");
                    String nom = sc.nextLine();
                    alumno.setNombreCompleto(nom);
                    registrosAlumnos.set(index, alumno);
                    System.out.println("El registro actualizado es:\n " + alumno.toString());
                    break;
                    
                case "2":
                    System.out.println("\nIngrese la nueva edad: ");
                    int edad = sc.nextInt();
                    alumno.setEdad(edad);
                    registrosAlumnos.set(index, alumno);
                    System.out.println("El registro actualizado es: " + alumno.toString());
                    break;
                    
                case "3":
                    System.out.println("Ingrese el nuevo semestre: ");
                    int sem = sc.nextInt();
                    alumno.setSemestre(sem);
                    semestre=alumno.getSemestre();
                    asignaturas = asignaturas();
                    escolaridad = escolaridad(sem);
                    promedio = promedio();
                    velocidad = velocidad();
                    indicadorEscolar = indicadorEscolar();
                    alumno.setAsignaturas(asignaturas);
                    alumno.setEscolaridad(escolaridad);
                    alumno.setPromedio(promedio);
                    alumno.setVelocidad(velocidad);
                    alumno.setIndicadorEscolar(indicadorEscolar);
                    registrosAlumnos.set(index, alumno);
                    System.out.println("El registro actualizado es: " + alumno.toString());
                    break;
                    
                case "4":
                    System.out.println("\nIngrese la nueva dirección: ");
                    String dir = sc.nextLine();
                    alumno.setDireccion(dir);
                    registrosAlumnos.set(index, alumno);
                    System.out.println("El registro actualizado es: " + alumno.toString());
                    break;
                    
                case "5":
                    Asignaturas as = new Asignaturas();
                    System.out.println("\nIngrese el nombre de la asignatura a agregar: ");
                    String name = sc.nextLine();
                    as.setNombre(name);
                    System.out.println("\nIngrese los créditos de la asignatura a agregar: ");
                    int cred = sc.nextInt();
                    as.setCreditos(cred);
                    System.out.println("\nIngrese el semestre de la asignatura a agregar: ");
                    int s = sc.nextInt();
                    as.setSemestre(s);
                    System.out.println("\nIngrese la calificación de la asignatura a agregar: ");
                    float cal = sc.nextFloat();
                    as.setCalificacion(cal);
                    alumno.asignaturas.add(as);
                    registrosAlumnos.set(index, alumno);
                    System.out.println("El registro actualizado es: " + alumno.toString());
                    break;
                    
                case "6":
                    System.out.println("\nIngrese el nuevo promedio: ");
                    int prom = sc.nextInt();
                    alumno.setPromedio(prom);
                    registrosAlumnos.set(index, alumno);
                    System.out.println("El registro actualizado es: " + alumno.toString());
                    break;
                    
                case "7":
                    System.out.println("\nIngrese la nueva escolaridad: ");
                    float escolar = sc.nextFloat();
                    alumno.setEscolaridad(escolar);
                    registrosAlumnos.set(index, alumno);
                    System.out.println("El registro actualizado es: " + alumno.toString());
                    break;
                    
                case "8":
                    System.out.println("\nIngrese la nueva velocidad: ");
                    float vel = sc.nextFloat();
                    alumno.setVelocidad(vel);
                    registrosAlumnos.set(index, alumno);
                    System.out.println("El registro actualizado es: " + alumno.toString());
                    break;
                    
                case "9":
                    System.out.println("\nIngrese el nuevo número de cuenta: ");
                    int num = sc.nextInt();
                    alumno.setNumeroCuenta(num);
                    registrosAlumnos.set(index, alumno);
                    System.out.println("El registro actualizado es: " + alumno.toString());
                    break;
                    
                case "10":
                    System.out.println("\nSe eligió salir del CRUD");
                    break;
                default:
                    System.out.println("\nOpción no válida");
            }
            
        }while(!"10".equals(opcion));
        
    }
    
}

