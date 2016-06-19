/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Fernando
 */
public class Control_Cifrador {
    
    Cifrador encriptador = new Cifrador();
    
    public int[] textoABinario(String mensaje){
        return encriptador.text_to_bin(mensaje);
    }
    
    public String binarioATexto(int[] mensaje){
        return encriptador.bin_to_text(mensaje);
    }
    
    public String verMensajeCifrado(int[] mensaje_cifrado){
        return encriptador.mensajeCifrado(mensaje_cifrado);
    }
    
    public int[] convertirStringAInt(String mensaje){
        return encriptador.string_to_int(mensaje);
    }
    
    public int[] realizarEncriptacion(int[] clave, int[] mensaje, int tamano){
        return encriptador.encriptar(clave, mensaje, tamano);
    }
     
    public int[] realizarDesencriptacion(int[] clave, int[] mensaje_cifrado, int tamano){
        return encriptador.encriptar(clave, mensaje_cifrado, tamano);
    }
}
