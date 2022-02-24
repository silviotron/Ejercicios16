/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.clasess;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 *
 * @author alumno
 */
public class Sesion implements Comparable<Sesion> {

    private LocalTime horaEntrada;
    private LocalTime horaSalida;
    private DayOfWeek diaClase;

    public Sesion(LocalTime horaEntrada, LocalTime horaSalida, DayOfWeek diaClase) {
        checkHora(horaEntrada, horaSalida);
        checkDiaClase(diaClase);
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.diaClase = diaClase;
    }

    private static void checkHora(LocalTime horaEntrada, LocalTime horaSalida) {
        if (horaEntrada == null || horaSalida == null) {
            throw new IllegalArgumentException("Error. no se permiten null en las horas");
        }
        LocalTime aux = horaSalida.minusSeconds(horaEntrada.toSecondOfDay());
        long minutos = aux.toSecondOfDay();
        if (minutos <= 0 || minutos % Modulo.getMINUTOS_SESION() != 0) {
            throw new IllegalArgumentException("Error. horas no validas");
        }
    }

    private static void checkDiaClase(DayOfWeek dia) {
        if (dia == null) {
            throw new IllegalArgumentException("Error. no se permiten null en el dia");
        } else if (dia.equals(DayOfWeek.SATURDAY) || dia.equals(DayOfWeek.SUNDAY)) {
            throw new IllegalArgumentException("Error. no se permiten ni sabados ni domingo");
        }
    }

    public DayOfWeek getDiaClase() {
        return diaClase;
    }
    

    @Override
    public int compareTo(Sesion t) {
        if (t == null) {
            throw new NullPointerException();
        } else {
            if (this.diaClase.compareTo(t.diaClase) != 0) {
                return this.diaClase.compareTo(t.diaClase);
            } else if (this.horaEntrada.compareTo(t.horaEntrada) != 0) {
                return this.horaEntrada.compareTo(t.horaEntrada);

            } else {
                return this.horaSalida.compareTo(t.horaSalida);
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        else if(!(obj instanceof Sesion)){
            return false;
        }
        else{
            Sesion aux = (Sesion)obj;
            return this.diaClase.equals(aux.diaClase) && this.horaEntrada.equals(aux.horaEntrada) & this.horaSalida.equals(aux.horaSalida);
        }
    }

}
