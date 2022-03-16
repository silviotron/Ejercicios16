/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1;

import java.util.TreeMap;
import org.daw1.clases.Coche;

/**
 *
 * @author alumno
 */
public class Parte3 {

    private static java.util.Scanner sc;
    private static java.util.Map<String, Coche> coches;
    
    public static void main(String[] args) {
        coches = new TreeMap<>();
        Coche c1 = new Coche("Seat","panda","1234ABC","QWERTY1QWER123456",Coche.TipoCombustible.GASOLINA,false);
        coches.put(c1.getMatricula(), c1);
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
            String matricula;
            switch(input){
                case "1":
                    Coche c = newCoche();
                    if (c !=null) {
                        coches.put(c.getMatricula(), c);
                        
                    }
                    
                    break;
                case "2":
                    for (String m : coches.keySet()) {
                        System.out.println(m);
                    }
                    break;
                case "3":
                    do {
                        System.out.print("Introduce la matricula: ");
                        matricula = sc.nextLine();
                        if(!Coche.PATRON_MATRICULA.matcher(matricula).matches()){
                            System.out.println("Error.");
                        }
                    } while (!Coche.PATRON_MATRICULA.matcher(matricula).matches());
                    if (coches.containsKey(matricula)) {
                        Coche aux = coches.get(matricula);
                        System.out.printf("Matrícula: %s\nMarca: %s\nModelo: %s\nNumero Bastidor: %s\nCombustible: %s\nEléctrico: %s\n",aux.getMatricula(),aux.getMarca(),aux.getModelo(),aux.getNumBastidor(),aux.getCombustible(), aux.isElectrico()?"Si":"No" );
                    }else{
                        System.out.println("La matrícula no existe.");
                    }
                    break;
                case "4":
                    do {
                        System.out.print("Introduce la matricula: ");
                        matricula = sc.nextLine();
                        if(!Coche.PATRON_MATRICULA.matcher(matricula).matches()){
                            System.out.println("Error.");
                        }
                    } while (!Coche.PATRON_MATRICULA.matcher(matricula).matches());
                    if (coches.containsKey(matricula)) {
                        coches.remove(matricula);
                        System.out.println("Borrada con exito.");
                    }else{
                        System.out.println("La matricula no existe.");
                    }
                    
                case "0":
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
        while(!input.equals("0"));
    }
    public static Coche newCoche(){
        String marca;
        String modelo;
        String matricula;
        String numBastidor;
        Coche.TipoCombustible combustible = null;
        Boolean electrico = null;
        do {
            System.out.print("Introduce la matricula: ");
            matricula = sc.nextLine();
            if(!Coche.PATRON_MATRICULA.matcher(matricula).matches()){
                System.out.println("Error.");
            }
        } while (!Coche.PATRON_MATRICULA.matcher(matricula).matches());
        if(coches.containsKey(matricula)){
            System.out.println("Error. La matricula ya existe.");
            return null;
        }
        do {
            System.out.print("Introduce la marca: ");
            marca = sc.nextLine();
            if(!Coche.PATRON_MARACA_MODELO.matcher(marca).matches()){
                System.out.println("Error.");
            }
        } while (!Coche.PATRON_MARACA_MODELO.matcher(marca).matches());
        do {
            System.out.print("Introduce el modelo: ");
            modelo = sc.nextLine();
            if(!Coche.PATRON_MARACA_MODELO.matcher(modelo).matches()){
                System.out.println("Error.");
            }
        } while (!Coche.PATRON_MARACA_MODELO.matcher(modelo).matches());
        do {
            System.out.print("Introduce el número de bastidor: ");
            numBastidor = sc.nextLine();
            if(!Coche.PATRON_BASTIDOR.matcher(numBastidor).matches()){
                System.out.println("Error.");
            }
        } while (!Coche.PATRON_MARACA_MODELO.matcher(modelo).matches());
        String seleccion = "";
        do{
            do{
                System.out.println("*****************");
                System.out.println("*  COMBUSTIBLE  *");
                System.out.println("*****************");
                System.out.println("* 0. Ninguno    *");
                System.out.println("* 1. Diesel     *");
                System.out.println("* 2. Gasolina   *");
                System.out.println("*****************");
                seleccion = sc.nextLine();
                switch (seleccion) {
                    case "0":
                        combustible = Coche.TipoCombustible.NINGUNO;
                        break;
                    case "1":
                        combustible = Coche.TipoCombustible.DIESEL;
                        break;
                    case "2":
                        combustible = Coche.TipoCombustible.GASOLINA;
                        break;
                    default:
                }
            }while(combustible ==  null);
            seleccion = "";
            do{
                System.out.println("*****************");
                System.out.println("*   ELECTRICO   *");
                System.out.println("*****************");
                System.out.println("* 0. No         *");
                System.out.println("* 1. Si         *");
                System.out.println("*****************");
                seleccion = sc.nextLine();
                switch (seleccion) {
                    case "0":
                        electrico = false;
                        break;
                    case "1":
                        combustible = Coche.TipoCombustible.DIESEL;
                        break;
                    default:
                }
            }while(electrico == null);    
        }while(!electrico && combustible == Coche.TipoCombustible.NINGUNO);
                
        return new Coche(marca,modelo,matricula,numBastidor,combustible,electrico);
    }
}
