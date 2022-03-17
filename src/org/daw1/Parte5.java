/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.daw1.clases.Fabricante;
import org.daw1.clases.Videoconsola;

/**
 *
 * @author alumno
 */
public class Parte5 {
    private static java.util.Scanner sc;
    private static  Map<Fabricante, Set<Videoconsola>> almacen = new TreeMap<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String seleccion = "";
        sc = new java.util.Scanner(System.in);
        do {
            
            seleccion = "";
            System.out.println("*************************");
            System.out.println("*1. Crear fabricante    *");
            System.out.println("*2. Alta consola        *");
            System.out.println("*3. consolas fabricante *");
            System.out.println("*4. consolas            *");
            System.out.println("*0. salir               *");
            System.out.println("*************************");
            seleccion = sc.nextLine();
            switch(seleccion){
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "0":
                    break;
                default:
                    System.out.println("opcion incorrecta");
                    
            }
            
        } while(!seleccion.equals("0"));
    }
    
    public static void newFabricante(){
        
    }
    
}
