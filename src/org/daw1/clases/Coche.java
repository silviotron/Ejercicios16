/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.clases;

import java.util.regex.Pattern;

/**
 *
 * @author alumno
 */
public class Coche implements Comparable<Coche>{
    private final String marca;
    private final String modelo;
    private String matricula;
    private final String numBastidor;
    private enum TipoCombustible{NINGUNO,DIESEL,GASOLINA}
    private final TipoCombustible combustible;
    private final boolean electrico;
    
    final private static Pattern PATRON_MATRICULA = Pattern.compile("[0-9]{4}[A-Z]{3}");
    final private static Pattern PATRON_MARAC_MODELO = Pattern.compile("[A-Za-z0-9 ]+");
    final private static Pattern PATRON_BASTIDOR = Pattern.compile("[A-Z]{6}[0-9][A-Z]{4}[0-9]{6}");
         

    public Coche(String marca, String modelo, String matricula, String numBastidor,TipoCombustible combustible, boolean electrico) {
        checkMarcaModelo(marca);
        checkMatricula(matricula);
        checkNumBastidor(numBastidor);
        checkTipoCombustible(combustible, electrico);
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.numBastidor = numBastidor;
        this.combustible = combustible;
        this.electrico = electrico;
    }
    
    private static void checkMarcaModelo(String s){
        if(s == null || !PATRON_MARAC_MODELO.matcher(s).matches()){
            throw new IllegalArgumentException("Solo se permiten letras, números y espacios");
        }
    }
    private static void checkMatricula(String s){
        if(s == null || !PATRON_MATRICULA.matcher(s).matches()){
            throw new IllegalArgumentException("La matricula no cumple el formato");
        }
    }
    private static void checkNumBastidor(String s){
        if(s == null || !PATRON_BASTIDOR.matcher(s).matches()){
            throw new IllegalArgumentException("El número de bastidor no cumple el formato");
        }
    }
    private static void checkTipoCombustible(TipoCombustible combustible, boolean electrico){
        if(combustible == null || (!electrico && combustible == TipoCombustible.NINGUNO)){
            throw new IllegalArgumentException("El vehículo debe consumir algun tipo de energía");
        }
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNumBastidor() {
        return numBastidor;
    }

    public TipoCombustible getCombustible() {
        return combustible;
    }

    public boolean isElectrico() {
        return electrico;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public String getMarcaModelo(){
        return this.marca + " " + this.matricula;
    }

    @Override
    public String toString() {
        return this.getMarcaModelo() + " " + this.matricula;
    }

    @Override
    public int compareTo(Coche t) {
        if (t == null) {
            throw new NullPointerException();
        }else{
            return matricula.compareTo(t.matricula);
        }
    }
    
    
    
    
    
    
    
    
}
