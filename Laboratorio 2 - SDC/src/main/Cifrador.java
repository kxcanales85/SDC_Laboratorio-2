/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
/**
 *
 * @author Fernando
 */
public class Cifrador {
    
    
    
    public Cifrador(){}
    
    public void encriptar(String clave, String mensaje){
        
        ArrayList texto_cifrado = new ArrayList<>();
        char[] clave_;
        char[] mensaje_;
        int tamano_bloque;
        ArrayList vector_inicial = new ArrayList<>();
        
        clave_ = clave.toCharArray();
        mensaje_ = mensaje.toCharArray();
        tamano_bloque = clave_[0];
        
        for(int i = 1;i<clave_.length;i++){
            vector_inicial.add(clave_[i]);
        }
    }
}
