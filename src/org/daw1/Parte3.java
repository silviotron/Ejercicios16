/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1;

import org.daw1.clases.Coche;

/**
 *
 * @author alumno
 */
public class Parte3 {

    private static java.util.Scanner sc;
    private static java.util.Map<String, Coche> coches;
    
    public static void main(String[] args) {
        sc = new java.util.Scanner(System.in);
        String input = "";
        do{
            System.out.println("******************************************");
            System.out.println("* 1. Crear coche                         *");
            System.out.println("* 2. Mostrar matrículas coches existentes*");
            System.out.println("* 3. Mostrar información coche           *");           
            System.out.println("* 4. Eliminar coche                      *");
            System.out.println("*                                        *");
            System.out.println("* 0. Salir                               *");
            System.out.println("******************************************");
            input = sc.nextLine();
            switch(input){
                case "1":
                    //Creamos un coche y si no existe la matrícula, lo añadimos
                    break;
                case "2":
                    //Recorremos el map mostrando sólo las matrículas de los coches
                    break;
                case "3":
                    //Pedimos la matrícula y si existe mostramos los datos del coche (todos los datos en una string)                    
                    break;
                case "4":
                    //Pedimos matrícula y borramos el coche si existe                
                case "0":
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
        while(!input.equals("0"));
    }
}
