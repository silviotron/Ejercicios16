/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.clases;

import java.util.regex.Pattern;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author alumno
 */
public class Fabricante implements Comparable<Fabricante> {

    private final String nombre;
    private final String pais;
    private final int anoFundacion;

    final public static Pattern PATRON_PAIS = Pattern.compile("[a-zA-Z ]+");
    final public static Pattern PATRON_NOMBRE = Pattern.compile("[a-zA-Z0-9 ]+");

    private static Set<Videoconsola> consolas;

    public Fabricante(String nombre, String pais, int anoFundacion) {
        checkNombre(nombre);
        checkPais(pais);
        checkAnoFundacion(anoFundacion);
        this.nombre = nombre;
        this.pais = pais;
        this.anoFundacion = anoFundacion;
        consolas = new TreeSet<>();
    }

    private static void checkPais(String s) {
        if (s == null || !PATRON_PAIS.matcher(s).matches()) {
            throw new IllegalArgumentException("Solo se permiten letras y espacios");
        }
    }

    private static void checkNombre(String s) {
        if (s == null || !PATRON_NOMBRE.matcher(s).matches()) {
            throw new IllegalArgumentException("Solo se permiten letras, números y espacios");
        }
    }

    private static void checkAnoFundacion(int n) {
        if (LocalDate.now().getYear() - n < 0) {
            throw new IllegalArgumentException("el año de fundacion no puede ser posterior al actual.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public int getAnoFundacion() {
        return anoFundacion;
    }

    public boolean addConsola(Videoconsola v) {
        if (!consolas.contains(v)) {
            consolas.add(v);
            v.setFabricante(this);
            return true;
        }else{
            return false;
        }

    }

    public boolean removeConsola(Videoconsola v) {
        return consolas.remove(v);
    }

    @Override
    public String toString() {
        return this.nombre + " " + this.pais + " " + this.anoFundacion;
    }

    @Override
    public int compareTo(Fabricante t) {
        if (t == null) {
            throw new NullPointerException();
        } else {
            return this.nombre.compareTo(t.nombre);
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
            Fabricante aux = (Fabricante) obj;
            return this.nombre.equals(aux.nombre);
        }
    }

    @Override
    public int hashCode() {
        return (this.nombre + " " + this.pais + " " + this.anoFundacion).hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

}
