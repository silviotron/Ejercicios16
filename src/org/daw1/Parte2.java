/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.daw1.clasess.Modulo;

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
    
}
