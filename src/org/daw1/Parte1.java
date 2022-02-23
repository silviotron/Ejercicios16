/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import org.daw1.clasess.Alumno;
/**
 *
 * @author alumno
 */
public class Parte1 {
    private static Map<String, Alumno> almacen = new TreeMap<>();
    private static Set<Alumno> set = new HashSet<>();
    private static java.util.Scanner sc;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String seleccion = "";
        sc = new java.util.Scanner(System.in);
        almacen.put("12345677X", new Alumno("pepe", "perez", "12345677X", LocalDate.of(2020, 12, 25)));
        almacen.put("12345678X", new Alumno("silvio", "novas", "12345678X", LocalDate.of(2002, 3, 1)));
        almacen.put("12345679X", new Alumno("juan.", "gomez", "12345679X", LocalDate.of(1964, 5, 24)));
        do {
            
            seleccion = "";
            System.out.println("*************************");
            System.out.println("*1. Crear alumno        *");
            System.out.println("*2. Modificar alumno    *");
            System.out.println("*3. Mostrar alumnos     *");
            System.out.println("*0. Salir               *");
            System.out.println("*************************");
            seleccion = sc.nextLine();
            switch(seleccion){
                case "1":
                    crear();
                    break;
                case "2":
                    modificar();
                    break;
                case "3":
                    mostrar();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("opcion incorrecta");
                    
            }
            
        } while(!seleccion.equals("0"));
    }
    
    public static void crear(){
        String dni = "";
        String nombre = "";
        String apellidos = "";
        do {            
            System.out.print("Introduce el dni del alumno: ");
            dni = sc.nextLine().toUpperCase();
            if(almacen.containsKey(dni)){
                System.out.printf("Error.el alumno con dni: %s ya existe\n",dni);
                dni = "";
            }
        } while (!dni.matches("[1-9]{8}[A-Z]"));
        do {    
        System.out.print("Introduce nombre: ");
        nombre = sc.nextLine();
        } while (nombre.isBlank());
        do {    
        System.out.print("Introduce Apellido: ");        
        apellidos = sc.nextLine();
        } while (apellidos.isBlank());
        LocalDate fecha = pedirFecha();
        almacen.put(dni, new Alumno(nombre, apellidos, dni, fecha));
        
        

    }
    public static LocalDate pedirFecha(){
        LocalDate fecha = null;
        do{            
            int dia = -1;
            do{
                System.out.print("Introduce dia de nacimiento: ");
                if(sc.hasNextInt()){
                    dia = sc.nextInt();                
                }
                if(!(dia >= 1 && dia <= 31)){
                    System.out.println("Error al introducir el dia");
                }
                sc.nextLine();
            }while(!(dia >= 1 && dia <= 31));
            
            int mes = -1;
            do{
                System.out.print("Introduce mes de nacimiento: ");
                if(sc.hasNextInt()){
                    mes = sc.nextInt();                
                }
                if(!(mes >= 1 && mes <= 12)){
                    System.out.println("Error al introducir el mes");
                }
                sc.nextLine();
            }while(!(mes >= 1 && mes <= 12));
            
            int ano = -1;
            do{
                System.out.print("Introduce año de nacimiento: ");
                if(sc.hasNextInt()){
                    ano = sc.nextInt();                
                }
                if(!(ano >= 1 && ano <= LocalDate.now().getYear())){
                    System.out.println("Error al introducir el año");
                }
                sc.nextLine();
            }while(!(ano >= 1 && ano <= LocalDate.now().getYear()));
            
            try{
                fecha = LocalDate.of(ano,mes,dia);
                if(fecha.isAfter(LocalDate.now())){
                    System.out.println("Error. la fecha de nacimiento no es posible");
                    fecha = null;
                }
                
            } catch (DateTimeException e){
                System.out.println("Error.fecha no valida");
            }
        }while(fecha == null);
        return fecha;
    }
    public static void modificar(){
        String dni = "";
        do{
        System.out.print("Introduce el dni del alumno a modificar: ");
        dni = sc.nextLine().toUpperCase();
        if(!dni.matches("[0-9]{8}[A-Z]")){
            System.out.println("El dni introducido no cumple con el formato del dni español");
        }else if(!almacen.containsKey(dni)){
            System.out.println("El alumno con dni " + dni +" no existe");
        }
                
        }while(!almacen.containsKey(dni));
        Alumno modificando = almacen.get(dni);
        String seleccion = "";
        do {
            
            seleccion = "";
            System.out.println("Alumno a modificar: " + modificando.getNomnbreCompleto());
            System.out.println("*******************************");
            System.out.printf("*1. modificar nota primero %2s *\n", (modificando.getNotaPrimero() == null)?"":modificando.getNotaPrimero());
            System.out.printf("*2. Modificar nota segundo %2s *\n", (modificando.getNotaSegundo()== null)?"":modificando.getNotaSegundo());
            System.out.println("*0. Salir                     *");
            System.out.println("*******************************");
            seleccion = sc.nextLine();
            switch(seleccion){
                case "1":
                    modificarPrimero(modificando);
                    break;
                case "2":
                    modificarSegundo(modificando);
                    break;
                case "0":
                    break;
                default:
                    System.out.println("opcion incorrecta");
                    
            }
            
        } while(!seleccion.equals("0"));
        
    }
    public static void modificarPrimero(Alumno modificando){
        if (modificando.getNotaPrimero() != null) {
            System.out.println("nota primero: " + modificando.getNotaPrimero());

        }
        int notaNueva = -1;
        do{
        System.out.print("Nota nueva: ");
        if(sc.hasNextInt()){
            notaNueva = sc.nextInt();
                       
        }
        sc.nextLine();
        }while(!(notaNueva >= 0 && notaNueva <= 10));
        modificando.setNotaPrimero(notaNueva); 
        
    }
    public static void modificarSegundo(Alumno modificando){
        if (modificando.getNotaSegundo() != null) {
            System.out.println("nota segundo: " + modificando.getNotaSegundo());

        }
        int notaNueva = -1;
        do{
        System.out.print("Nota nueva: ");
        if(sc.hasNextInt()){
            notaNueva = sc.nextInt();
            if(!(notaNueva >= 0 && notaNueva <= 10)){
                
            }
                       
        }else{
            System.out.println("Error. introduce un numero entero");
        }
        sc.nextLine();
        }while(!(notaNueva >= 0 && notaNueva <= 10));
        modificando.setNotaSegundo(notaNueva); 
        
    }
    public static void mostrar(){
        for (String clave : almacen.keySet()) {
            System.out.println(almacen.get(clave).toString());
        }

    }
}
