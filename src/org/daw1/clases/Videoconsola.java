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
public class Videoconsola {
    private final Fabricante fabricante;
    private final String marca;
    private final String modelo;
    private String maxSimultaneos;
    private final int vram;
    private final int ram;
    public enum TipoRam{
        DDR4,DDR5,DDR5x
    }
    private final TipoRam tipoRam;
    public enum Res{
        SD,FullHD,_2K,_4K
    }
    private Res maxRes;

    public Videoconsola(Fabricante fabricante, String marca, String modelo, String maxSimultaneos, int vram, int ram, TipoRam tipoRam, Res maxRes) {
        this.fabricante = fabricante;
        this.marca = marca;
        this.modelo = modelo;
        this.maxSimultaneos = maxSimultaneos;
        this.vram = vram;
        this.ram = ram;
        this.tipoRam = tipoRam;
        this.maxRes = maxRes;
    }

    
    
    
}
