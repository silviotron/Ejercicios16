/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.daw1.clasess.Modulo;
import org.daw1.clasess.Sesion;

/**
 *
 * @author alumno
 */
public class Parte2 {
    
    public static Map<String,Modulo> modulos = new TreeMap<>();
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        modulos.put("PROG", new Modulo("programacion", "PROG", "Rafa"));
        modulos.put("SSRR",new Modulo("sistemas y reses", "SSRR", "Marcos"));
        
        String seleccion = "";
        java.util.Scanner sc = new java.util.Scanner(System.in);
        do {
            
            seleccion = "";
            System.out.println("**********************");
            System.out.println("* 1. Crear módulo    *");
            System.out.println("* 2. Mostrar horario *");
            System.out.println("* 3. Editar horario  *");
            System.out.println("* 4. mostrar modulos *");
            System.out.println("* 0. Salir           *");
            System.out.println("**********************");
            seleccion = sc.nextLine();
            switch(seleccion){
                case "1":
                    ejercicio1();
                    break;
                case "2":
                    ejercicio2();
                    break;
                case "3":
                    ejercicio3();
                    break;
                case "4":
                    ejercicio4();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("opcion incorrecta");
                    
            }
            
        } while(!seleccion.equals("0"));
    }
    
    public static void ejercicio1(){
        java.util.Scanner sc = new java.util.Scanner(System.in); 
        String nombre;
        String codigo;
        String titular;
        do { 
            System.out.print("introduce el nombre del módulo: ");
            nombre = sc.nextLine();
            if(nombre.isBlank()){
                System.out.println("Error.");
            }
        } while (nombre.isBlank()); 
        do { 
            System.out.print("introduce el código del módulo: ");
            codigo = sc.nextLine();
            if(!codigo.matches("[A-Z]{1,4}")){
                System.out.println("Error.");
            }
        } while (!codigo.matches("[A-Z]{1,4}")); 
        do { 
            System.out.print("introduce el nombre del profesor titular: ");
            titular= sc.nextLine();
            if(titular.isBlank()){
                System.out.println("Error.");
            }
        } while (titular.isBlank());
        Modulo m = new Modulo(nombre, codigo, titular);
        if(modulos.containsKey(m.getCodigo())){
            System.out.println("Ya existe");
        }else{
            modulos.put(m.getCodigo(), m);
        }
        
        
    }
    
    public static void ejercicio2(){
        java.util.Scanner sc = new java.util.Scanner(System.in); 
        int n = -1;
        String[] array = modulos.keySet().toArray(new String[modulos.size()]);            
        do {
            System.out.println("-- MODULOS --");
            for (int i = 0; i < array.length; i++) {
                System.out.printf("%2s: %4s\n", i + 1 ,array[i]);
                
            }
            if(sc.hasNextInt()){
                n = sc.nextInt() - 1;
            }
            if(n < 0 || n > array.length){
                System.out.println("Error.");
            }
             sc.nextLine();
        } while (n < 0 || n > array.length);
        System.out.println(array[n]);
        if (modulos.get(array[n]).getHorario().isEmpty()) {
            System.out.println("El horario esta vacio");
        }else{
            System.out.println(modulos.get(array[n]).getHorario());
        }
        
        
    }
    
    public static void ejercicio3(){
        java.util.Scanner sc = new java.util.Scanner(System.in); 
        int n = -1;
        String[] array = modulos.keySet().toArray(new String[modulos.size()]);            
        do {
            System.out.println("-- MODULOS --");
            for (int i = 0; i < array.length; i++) {
                System.out.printf("%2s: %4s\n", i + 1 ,array[i]);
                
            }
            if(sc.hasNextInt()){
                n = sc.nextInt() - 1;
            }
            if(n < 0 || n > array.length){
                System.out.println("Error.");
            }
             sc.nextLine();
        } while (n < 0 || n > array.length);
        String clave = array[n];
        String seleccion = "";
        do {
            
            seleccion = "";
            System.out.println("****************");
            System.out.println("* 1. Agregar   *");
            System.out.println("* 2. Quitar    *");
            System.out.println("* 0. Salir     *");
            System.out.println("****************");
            seleccion = sc.nextLine();
            switch(seleccion){
                case "1":
                    if (!modulos.get(clave).addSesion(crearSesion())) {
                        System.out.println("Error al añadir sesión.");
                    }
                    break;
                case "2":
                    if (!borrarSesion(clave)) {
                        System.out.println("Error al borrar sesión.");
                    }
                    break;
                case "0":
                    break;
                default:
                    System.out.println("opcion incorrecta");
                    
            }
            
        } while(!seleccion.equals("0"));
        
    }
    
    public static boolean borrarSesion(String s){
        java.util.Scanner sc = new java.util.Scanner(System.in); 
        if(modulos.get(s).getHorario().isEmpty()){
            return false;
        }
        Sesion[] array = modulos.get(s).getHorario().toArray(new Sesion[modulos.size()]);
        int n = -2;
        do {
            System.out.println("-- SESIONES --");
            for (int i = 0; i < array.length ; i++) {
                if(array[i] != null){
                System.out.printf("%2s: %4s\n", i + 1 ,array[i]);
                    
                }
                
            }
            System.out.println(" 0. salir");
            if(sc.hasNextInt()){
                n = sc.nextInt() - 1;
            }
            if(n <= -1 || n > array.length){
                System.out.println("Error.");
            }
             sc.nextLine();
        } while (n <= -1 || n > array.length);
        if (n != 0) {
        return modulos.get(s).removeSesion(array[n]);
            
        }else{
            return false;
        }
        
    }
    
    public static Sesion crearSesion() {
        java.util.Scanner sc = new java.util.Scanner(System.in); 
        Sesion resultado = null;
        do {
            DayOfWeek dia = null;
            do {
                System.out.println("Día de la semana de lunes a viernes(del 1 al 5): ");
                if (sc.hasNextInt()) {
                    int diaInt = sc.nextInt();
                    if (diaInt >= 1 && diaInt <= 5) {
                        dia = DayOfWeek.of(diaInt);

                    }
                    sc.nextLine();
                }
            } while (dia == null);
            
            int horaEntrada = -1;
            do {
                System.out.println("Hora de entrada(de 0 a 23): ");
                if (sc.hasNextInt()) {
                    horaEntrada = sc.nextInt();
                }
                sc.nextLine();
            } while (horaEntrada < 0 || horaEntrada > 23);

            int minutoEntrada = -1;
            do {
                System.out.println("Minuto de entrada(de 0 a 59): ");
                if (sc.hasNextInt()) {
                    minutoEntrada = sc.nextInt();
                }
                sc.nextLine();
            } while (minutoEntrada < 0 || minutoEntrada > 59);

            int horaSalida = -1;
            do {
                System.out.println("Hora de salida(de 0 a 23): ");
                if (sc.hasNextInt()) {
                    horaSalida = sc.nextInt();
                }
                sc.nextLine();
            } while (horaSalida < 0 || horaSalida > 23);

            int minutoSalida = -1;
            do {
                System.out.println("Minuto de salida(de 0 a 59): ");
                if (sc.hasNextInt()) {
                    minutoSalida = sc.nextInt();
                }
                sc.nextLine();
            } while (minutoSalida < 0 || minutoSalida > 59);

            LocalTime timeEntrada = LocalTime.of(horaEntrada, minutoEntrada);
            LocalTime timeSalida = LocalTime.of(horaSalida, minutoSalida);
            if(timeSalida.compareTo(timeEntrada) < 0){
                System.out.println("La hora de salida debe ser posterior a la hora de entrada.");
            }else{
                try{
                    resultado = new Sesion(timeEntrada, timeSalida, dia);
                }catch(IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }
                
            }
        } while (resultado == null);
        return resultado;

    }
    
    public static void ejercicio4(){
        String[] array = modulos.keySet().toArray(new String[modulos.size()]);            
        System.out.println("-- MODULOS --");
            for (int i = 0; i < array.length; i++) {
                System.out.printf("%2s: %4s\n", i + 1 ,array[i]);
                
            }
    }
    
}
