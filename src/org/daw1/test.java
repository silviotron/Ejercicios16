/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1;

import java.time.DayOfWeek;
import java.time.LocalTime;
import org.daw1.clasess.Sesion;
/**
 *
 * @author alumno
 */
public class test {

    private static java.util.Scanner sc;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        sc = new java.util.Scanner(System.in);
        int sesiones = -1;
        do {
            System.out.print("Numero de sesiones: ");
            if (sc.hasNextInt()) {
                sesiones = sc.nextInt();

            }
            if (sesiones <= 0 || sesiones > 256) {
                System.out.println("Error.");
            }
        } while (sesiones <= 0 || sesiones > 256);

        Sesion[] horario = new Sesion[sesiones];

        for (int i = 0; i < horario.length; i++) {
            System.out.println("Creacion sesion " + i+1);
            horario[i] = crearSesion();
        }
        for (int i = 0; i < horario.length; i++) {
            for (int j = i; j < horario.length; j++) {
                if(horario[i].compareTo(horario[j]) > 0){
                    Sesion aux = horario[i];
                    horario[i] = horario[j];
                    horario[j] = aux;
                }
            }
            
        }
        for (Sesion sesion : horario) {
            System.out.println(sesion);
        }
    }
    
    public static Sesion crearSesion() {
        DayOfWeek dia = null;
        do {
            System.out.println("Día de la semana(del 1 al 7): ");
            if (sc.hasNextInt()) {
                int diaInt = sc.nextInt();
                if (diaInt >= 1 && diaInt <= 7) {
                    dia = DayOfWeek.of(diaInt);

                }
                sc.nextLine();
            }
        } while (dia == null);
        Sesion resultado = null;
        do {
            int horaEntrada = -1;
            do {
                System.out.println("Hora de entrada(de 0 a 23): ");
                if (sc.hasNextInt()) {
                    horaEntrada = sc.nextInt();
                    sc.nextLine();
                }
            } while (horaEntrada < 0 || horaEntrada > 23);

            int minutoEntrada = -1;
            do {
                System.out.println("Minuto de entrada(de 0 a 59): ");
                if (sc.hasNextInt()) {
                    minutoEntrada = sc.nextInt();
                    sc.nextLine();
                }
            } while (minutoEntrada < 0 || minutoEntrada > 59);

            int horaSalida = -1;
            do {
                System.out.println("Hora de salida(de 0 a 23): ");
                if (sc.hasNextInt()) {
                    horaSalida = sc.nextInt();
                    sc.nextLine();
                }
            } while (horaSalida < 0 || horaSalida > 23);

            int minutoSalida = -1;
            do {
                System.out.println("Minuto de salida(de 0 a 59): ");
                if (sc.hasNextInt()) {
                    minutoSalida = sc.nextInt();
                    sc.nextLine();
                }
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

}
