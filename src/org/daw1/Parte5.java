/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import org.daw1.clases.Fabricante;
import static org.daw1.clases.Fabricante.PATRON_NOMBRE;
import static org.daw1.clases.Fabricante.PATRON_PAIS;
import org.daw1.clases.TipoRam;
import org.daw1.clases.Res;
import org.daw1.clases.Videoconsola;

/**
 *
 * @author alumno
 */
public class Parte5 {
    private static java.util.Scanner sc;
    private static  Set<Fabricante> almacen = new HashSet<>();

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
                    newFabricante();
                    break;
                case "2":
                    newConsola();
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
    
    public static boolean newFabricante(){
        String nombre = null;
        do {
            System.out.print("introduce el nombre: ");
            nombre = sc.nextLine();
            if(nombre == null || !PATRON_NOMBRE.matcher(nombre).matches()){
                System.out.println("Error.");
            }
        } while (nombre == null || !PATRON_NOMBRE.matcher(nombre).matches());
        String pais = null;
        do {
            System.out.print("introduce el pais: ");
            pais = sc.nextLine();
            if(pais == null || !PATRON_PAIS.matcher(pais).matches()){
                System.out.println("Error.");
            }
        } while (pais == null || !PATRON_PAIS.matcher(pais).matches()); 
        int ano = LocalDate.now().getYear() +1;
        do{
            System.out.print("Introduce el año de fundación: ");
            if(sc.hasNextInt()){
                ano = sc.nextInt();
            }
            if(LocalDate.now().getYear() - ano < 0){
                System.out.println("Error al introducir el número");
            }
            sc.nextLine();
        }while(LocalDate.now().getYear() - ano < 0);
        return almacen.add(new Fabricante(nombre, pais, ano));
        
    }
    public static void newConsola(){
        Fabricante[] fabricantes = almacen.toArray(new Fabricante[almacen.size()]);
        System.out.println("Selecciona el fabricante: ");
        for (int i = 0; i < fabricantes.length; i++) {
            System.out.printf(" %2s. %s\n",i+1,fabricantes[i].getNombre());
            
        }
        int numero = -2;
        do{
            System.out.print("Introduce un número: ");
            if(sc.hasNextInt()){
                numero = sc.nextInt()-1;
            }
            if(!(numero > -1)){
                System.out.println("Error al introducir el número");
            }
            sc.nextLine();
        }while(!(numero > -1));
        fabricantes[numero].addConsola(createConsola());
        
    }
    public static Videoconsola createConsola(){
        String marca;
        do {
            System.out.print("introduce la marca: ");
            marca = sc.nextLine();
            if(marca.isBlank()){
                System.out.println("Error.");
            }
        } while (marca.isBlank());
        String modelo;
        do {
            System.out.print("introduce el modelo: ");
            modelo = sc.nextLine();
            if(modelo.isBlank()){
                System.out.println("Error.");
            }
        } while (modelo.isBlank()); 
        int maxUsuarios = -1;
        do{
            System.out.print("Introduce el número máximo de usuarios simultaneos: ");
            if(sc.hasNextInt()){
                maxUsuarios = sc.nextInt();
            }
            if(!(maxUsuarios >= 0)){
                System.out.println("Error al introducir el número");
            }
            sc.nextLine();
        }while(!(maxUsuarios >= 0));
        int vRam = -1;
        do{
            System.out.print("Introduce el tamaño de vRAM(GB): ");
            if(sc.hasNextInt()){
                vRam = sc.nextInt();
            }
            if(!(vRam >= 0)){
                System.out.println("Error al introducir el número");
            }
            sc.nextLine();
        }while(!(vRam >= 0));
        int ram = -1;
        do{
            System.out.print("Introduce el tamaño de RAM(GB): ");
            if(sc.hasNextInt()){
                ram = sc.nextInt();
            }
            if(!(ram >= 0)){
                System.out.println("Error al introducir el número");
            }
            sc.nextLine();
        }while(!(ram >= 0));
        System.out.println("Selecciona el tipo de ram");
        for (int i = 1; i <= TipoRam.values().length; i++) {
            System.out.printf("%2s. %s\n",i,TipoRam.of(i));
        }
        int nRam = -2;
        do{
            System.out.print("Introduce un número: ");
            if(sc.hasNextInt()){
                nRam = sc.nextInt()-1;
            }
            if(!(nRam > -1)){
                System.out.println("Error al introducir el número");
            }
            sc.nextLine();
        }while(!(nRam > -1));
        int nRes = -2;
        System.out.println("Selecciona la resolución máxima");
        for (int i = 1; i <= Res.values().length; i++) {
            System.out.printf("%2s. %s\n",i,Res.of(i).toString().replaceAll("_", ""));
        }
        do{
            System.out.print("Introduce un número: ");
            if(sc.hasNextInt()){
                nRes = sc.nextInt()-1;
            }
            if(!(nRes > -1)){
                System.out.println("Error al introducir el número");
            }
            sc.nextLine();
        }while(!(nRes > -1));
        return new Videoconsola(marca, modelo, maxUsuarios, vRam, ram,TipoRam.of(nRam), Res.of(nRes));
    }
    
}
