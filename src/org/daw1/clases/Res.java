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
public enum Res {
    SD, FullHD, _2K, _4K;

    public static Res of(int res) {
        if (res < 0 || res > Res.values().length) {
            throw new IllegalArgumentException("Inserte un número entre 1 y " + Res.values().length);
        } else {
            return Res.values()[res - 1];
        }
    }
}