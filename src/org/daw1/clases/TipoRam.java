/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.clases;

/**
 *
 * @author alumno
 */
public enum TipoRam {
    DDR4, DDR5, DDR5x;

    public static TipoRam of(int ram) {
        if (ram < 0 || ram > TipoRam.values().length) {
            throw new IllegalArgumentException("Inserte un número entre 1 y " + TipoRam.values().length);
        } else {
            return TipoRam.values()[ram - 1];
        }
    }
}
