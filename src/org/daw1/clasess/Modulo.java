/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.clasess;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.time.DayOfWeek;
import java.util.TreeSet;

/**
 *
 * @author alumno
 */
public class Modulo implements Comparable<Modulo>{
    private static int MAX_SESIONES = 30;
    private static int MINUTOS_SESION = 50;
    private final String nombre;
    private final String codigo;
    private final int sesionesSemanales;
    private String titular;
    private Map<DayOfWeek, Set<Sesion>> horario;

    public Modulo(String nombre, String codigo, int sesionesSemanales, String titular) {
        checkNombre(nombre);
        checkcodigo(codigo);
        checkSesiones(sesionesSemanales);
        checkTitular(titular);
        this.nombre = nombre;
        this.codigo = codigo;
        this.sesionesSemanales = sesionesSemanales;        
        this.titular = titular;
        this.horario = new TreeMap<>();
        
    }
    
    private static void checkNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Error. nombre no valido");
        }

    }
    private static void checkTitular(String titular) {
        if (titular == null || titular.isBlank()) {
            throw new IllegalArgumentException("Error. titular no valido");
        }

    }
    private static void checkcodigo(String codigo) {
        if (codigo == null || !codigo.matches("[A-Z]{1,4}")) {
            throw new IllegalArgumentException("Error. codigo no valido");
        }

    }
    private static void checkSesiones(int sesiones) {
        if (sesiones > MAX_SESIONES || sesiones < 0) {
            throw new IllegalArgumentException("Error. sesiones no validas");
        }

    }   

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getSesionesSemanales() {
        return sesionesSemanales;
    }

    public String getTitular() {
        return titular;
    }

    public Map<DayOfWeek, Set<Sesion>> getHorario() {
        return horario;
    }

    public static int getMINUTOS_SESION() {
        return MINUTOS_SESION;
    }
    

    public void setTitular(String titular) {
        this.titular = titular;
    }
    
    public void addHorario(Sesion t){ //TODO: terminar
        horario.get(t.getDiaClase()).add(t);
        horario.put(t.getDiaClase(), new TreeSet<>());
    }

    @Override
    public String toString() {
        return this.codigo + " - " + this.nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        else if(this == obj){
            return true;
        }
        else if(!(obj instanceof Modulo)){
            return false;
        }
        else{
            Modulo otro = (Modulo)obj;
            return this.codigo.equals(otro.getCodigo()) && this.nombre.equals(otro.getNombre());
        }
    }

    @Override
    public int compareTo(Modulo arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
