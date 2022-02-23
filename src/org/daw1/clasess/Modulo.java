/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.clasess;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author alumno
 */
public class Modulo {
    private static int MAX_SESIONES = 30;
    private static int MINUTOS_SESION = 50;
    private final String nombre;
    private final String codigo;
    private final int sesionesSemanales;
    private String titular;
    private Map<String, LocalDateTime[]> horario;

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
        horario.put("lunes", null);
        horario.put("martes", null);
        horario.put("miercoles", null);
        horario.put("jueves", null);
        horario.put("viernes", null);
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
    private void checkDia(String dia){
        if (!horario.containsKey(dia)) {
            throw new IllegalArgumentException("Error. dia no valido");
        }
    }
    private static void checkFecha(LocalDateTime inicio,LocalDateTime fin){
        if (inicio == null || fin == null || inicio.isBefore(fin)) {
            throw new IllegalArgumentException("Error. horas no validas");
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

    public Map<String, LocalDateTime[]> getHorario() {
        return horario;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
    
    
    
    public void addHorario(String dia, LocalDateTime inicio, LocalDateTime fin){
        checkFecha(inicio, fin);
        checkDia(dia);
        horario.put(dia, new LocalDateTime[]{inicio, fin});
    }
    
}
