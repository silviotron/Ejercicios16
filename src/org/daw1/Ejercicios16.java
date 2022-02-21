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
import java.util.InputMismatchException;
import java.util.Set;
import java.util.TreeSet;
import org.daw1.clasess.Alumno;
/**
 *
 * @author alumno
 */
public class Ejercicios16 {
    private static Set<Alumno> almacen = new TreeSet<>();
    private static java.util.Scanner sc;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String seleccion = "";
        sc = new java.util.Scanner(System.in);
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
        do {            
            System.out.print("Introduce el dni del alumno: ");
            dni = sc.nextLine().toUpperCase();
        } while (!dni.matches("[1-9]{8}[A-Z]"));
        System.out.print("Introduce nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Introduce Apellido: ");        
        String apellidos = sc.nextLine();
        LocalDate fecha = pedirFecha();
        almacen.add(alumno(nombre, apellidos, dni, fecha));
        
        

    }
    public static LocalDate pedirFecha(){
        LocalDate fecha = null;
        do{            
            try{            
                System.out.print("Introduce dia de nacimiento: ");
                int dia = sc.nextInt();
                System.out.print("Introduce mes de nacimiento: ");
                int mes = sc.nextInt();
                System.out.print("Introduce año de nacimiento: ");
                int ano = sc.nextInt();
                fecha = LocalDate.of(ano,mes,dia);
                
            } catch (DateTimeException e){
                System.out.println("fecha no valida");
            } catch (InputMismatchException e){
                System.out.println("debe introducir un numero");
            }
            sc.nextLine();
        }while(fecha == null);
        return fecha;
    }
    public static void modificar(){
        
    }
    public static void mostrar(){
        System.out.println(Arrays.toString(almacen.toArray()));
    }
}
