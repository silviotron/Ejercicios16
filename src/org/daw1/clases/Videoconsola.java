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
public class Videoconsola implements Comparable<Videoconsola> {

    private Fabricante fabricante;
    private final String marca;
    private final String modelo;
    private int maxUsuariosSimultaneos;
    private final int vRam;
    private final int ram;
    private final TipoRam tipoRam;
    private Res maxRes;


    public Videoconsola(String marca, String modelo, int maxUsuariosSimultaneos, int vRam, int ram, TipoRam tipoRam, Res maxRes) {
        checkNull(tipoRam);
        checkNull(maxRes);
        checkNombre(marca);
        checkNombre(modelo);
        checkTamano(vRam);
        checkTamano(ram);
        checkTamano(maxUsuariosSimultaneos);
        this.marca = marca;
        this.modelo = modelo;
        this.maxUsuariosSimultaneos = maxUsuariosSimultaneos;
        this.vRam = vRam;
        this.ram = ram;
        this.tipoRam = tipoRam;
        this.maxRes = maxRes;
    }

    private static void checkNombre(String s) {
        if (s == null || s.isBlank()) {
            throw new IllegalArgumentException("no se permiten valores nulos ni vacios");
        }
    }

    private static void checkTamano(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("el tamaño no puede ser menor o igual a cero");
        }
    }

    private static void checkNull(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("no se permiten valores nulos");
        }
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getMaxUsuariosSimultaneos() {
        return maxUsuariosSimultaneos;
    }

    public int getVram() {
        return vRam;
    }

    public int getRam() {
        return ram;
    }

    public TipoRam getTipoRam() {
        return tipoRam;
    }

    public Res getMaxRes() {
        return maxRes;
    }

    public void setMaxUsuariosSimultaneos(int maxUsuariosSimultaneos) {
        this.maxUsuariosSimultaneos = maxUsuariosSimultaneos;
    }

    public void setMaxRes(Res maxRes) {
        checkNull(maxRes);
        this.maxRes = maxRes;
    }
    protected void setFabricante(Fabricante f){
        checkNull(f);
        if (!f.equals(this.fabricante)) {
            if (this.fabricante != null) {
                this.fabricante.removeConsola(this);                
            }
            this.fabricante = f;
            f.addConsola(this);
        }
    }
    

    @Override
    public String toString() {
        return this.fabricante.getNombre() + " " + this.marca + " " + this.modelo; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return (this.fabricante.getNombre() + this.marca + this.modelo).hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Videoconsola t) {
        if (t == null) {
            throw new NullPointerException();
        } else {
            if (this.marca.compareTo(t.marca) != 0) {
                return this.marca.compareTo(t.marca);

            } else {
                return this.modelo.compareTo(t.modelo);
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj == this) {
            return true;
        } else if (obj instanceof Videoconsola) {
            Videoconsola aux = (Videoconsola) obj;
            return this.fabricante.equals(aux.fabricante) && this.marca.equals(aux.marca) & this.modelo.equals(aux.modelo);
        } else {
            return false;
        }
    }

}
