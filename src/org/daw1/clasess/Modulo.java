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
import java.util.HashSet;
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
    private int sesionesSemanales;
    private String titular;
    private Set<Sesion> horario = new TreeSet<>();
    

    public Modulo(String nombre, String codigo, String titular) {
        checkNombre(nombre);
        checkcodigo(codigo);
        checkTitular(titular);
        this.nombre = nombre;
        this.codigo = codigo;       
        this.titular = titular;
        this.horario = new TreeSet<>();
        this.sesionesSemanales = 0;
        
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

    public Set<Sesion> getHorario() {
        return horario;
    }

    public static int getMINUTOS_SESION() {
        return MINUTOS_SESION;
    }
    

    public void setTitular(String titular) {
        this.titular = titular;
    }
    
    /**
     * Añade una sesion al modulo actualizando el número de sesiones
     * @param s sesion
     * @return si se añadio la sesión
     */
    public boolean addSesion(Sesion s){
        if(this.horario.add(s)){
            this.sesionesSemanales =+ s.getCuantasSesiones();
            return true;
        }else{
            return false;
        }
    }
    /**
     * Elimina una sesion al modulo actualizando el número de sesiones
     * @param s sesion
     * @return si se eliminóla sesión
     */
    public boolean removeSesion(Sesion s){
        if(this.horario.remove(s)){
            this.sesionesSemanales =- s.getCuantasSesiones();
            return true;
        }else{
            return false;
        }        
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

    @Override
    public int hashCode() {
        return (this.codigo + this.nombre).hashCode();
    }
    
    
    
}
