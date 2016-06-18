/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import main.Cifrador;
/**
 *
 * @author Fernando
 */
public class Control_Cifrador {
    
    Cifrador encriptador = new Cifrador();
    
    public void realizarEncriptacion(String clave, String mensaje){
        encriptador.encriptar(clave, mensaje);
    }
}
