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

    private final Fabricante fabricante;
    private final String marca;
    private final String modelo;
    private int maxUsuariosSimultaneos;
    private final int vram;
    private final int ram;

    public enum TipoRam {
        DDR4, DDR5, DDR5x
    }
    private final TipoRam tipoRam;

    public enum Res {
        SD, FullHD, _2K, _4K
    }
    private Res maxRes;

    final public static Pattern PATRON_NOMBRE = Pattern.compile("[a-zA-Z0-9 ]+");

    public Videoconsola(Fabricante fabricante, String marca, String modelo, int maxUsuariosSimultaneos, int vram, int ram, TipoRam tipoRam, Res maxRes) {
        checkNull(fabricante);
        checkNull(tipoRam);
        checkNull(maxRes);
        checkNombre(marca);
        checkNombre(modelo);
        checkTamano(vram);
        checkTamano(ram);
        checkTamano(maxUsuariosSimultaneos);
        this.fabricante = fabricante;
        this.marca = marca;
        this.modelo = modelo;
        this.maxUsuariosSimultaneos = maxUsuariosSimultaneos;
        this.vram = vram;
        this.ram = ram;
        this.tipoRam = tipoRam;
        this.maxRes = maxRes;
    }

    private static void checkNombre(String s) {
        if (s == null || !PATRON_NOMBRE.matcher(s).matches()) {
            throw new IllegalArgumentException("Solo se permiten letras, números y espacios");
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
        return vram;
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
            if (this.fabricante.compareTo(t.fabricante) != 0) {
                return this.fabricante.compareTo(t.fabricante);
            } else if (this.marca.compareTo(t.marca) != 0) {
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
        } else if (!(obj instanceof Sesion)) {
            return false;
        } else {
            Sesion aux = (Sesion) obj;
            return this.fabricante.equals(aux.fabricante) && this.marca.equals(aux.marca) & this.modelo.equals(aux.modelo);
        }
    }

}
