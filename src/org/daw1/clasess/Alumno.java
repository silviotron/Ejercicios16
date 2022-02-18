/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.clasess;

import java.time.LocalDate;

/**
 *
 * @author alumno
 */
public class Alumno {
    private String nombre;
    private String apellidos;
    private final String dni;
    private final LocalDate fechaNacimiento;
    private Integer notaPrimero = null;
    private Integer notaSegundo = null;
    
    public Alumno(String nombre, String apellidos, String dni, LocalDate fechaNacimiento){
        checkNotNull(nombre);
        checkNotNull(apellidos);
        checkDni(dni);
        checkFechaNacimiento(fechaNacimiento);
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        
    }
    
    private static <E> void checkNotNull(E cadena){
        if(cadena == null){
            throw new IllegalArgumentException("no se permiten valores nulos");
        }
        
    }
    
    /**
     * Suponemos que un DNI debe tener siempre 8 números seguidos de una letra mayúscula
     * @param dni 
     */
    private static void checkDni(String dni){
        if(dni == null || !dni.matches("[0-9]{8}[A-Z]")){
            throw new IllegalArgumentException("El DNI debe estar formado por 8 números seguidos de una letra");
        }
        
    }
    
    /**
     * Comprueba que la fecha de nacimiento es anterior a la fecha actual
     * @param fechaNacimiento 
     */
    private static void checkFechaNacimiento(LocalDate fechaNacimiento){
        if(fechaNacimiento == null || fechaNacimiento.compareTo(LocalDate.now()) >= 0){
            throw new IllegalArgumentException("La fecha de nacimiento debe ser anterior a hoy");
            
        }
        
    }
    private static void checkNota(Integer nota){
        if(nota != null && (nota < 0 || nota > 10)){
            throw new IllegalArgumentException("la nota debe tener un valor entre 0 y 10");
        }
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getApellidos(){
        return this.apellidos;
    }
    
    public String getDni(){
        return this.dni;
    }
    
    public LocalDate getFechaNacimiento(){
        return this.fechaNacimiento;
    }
    
    public Integer getNotaPrimero(){
        return this.notaPrimero;
    }
    
    public Integer getNotaSegundo(){
        return this.notaSegundo;
    }
    
    public void setNombre(String nombre){
        checkNotNull(nombre);        
        this.nombre = nombre;
    }
    
    public void setApellidos(String apellidos){
        checkNotNull(apellidos);
        this.apellidos = apellidos;
    }
    
    public void setNotaPrimero(Integer nota){
        checkNota(nota);
        this.notaPrimero = nota;
    }
    
    /**
     * Establece la nota de segundo para el alumno
     * @param nota nota de segundo para el alumno 
     * @throws 
     */
    public void setNotaSegundo(Integer nota){
        checkNota(nota);
        this.notaSegundo = nota;
    }
    
    /**
     * Devuelve el nombre completo, resultado de concatenar el nombre y los apellidos
     * @return nombre completo, resultado de concatenar el nombre y los apellidos 
     */
    public String getNomnbreCompleto(){
        return this.nombre + " " + this.apellidos;
    }
}
