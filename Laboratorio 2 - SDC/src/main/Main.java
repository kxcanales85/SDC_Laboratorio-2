/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import java.util.Arrays;
import javax.naming.BinaryRefAddr;
import vistas.Vista_Principal;

/**
 *
 * @author Kevin Canales
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Vista_Principal nueva = new Vista_Principal();
        //nueva.show();
        String mensaje = "hola que  tal?";
        String clave = "clave";
        Cifrador C = new Cifrador();
        int[] mensaje_binario;
        int[] clave_binaria;
        clave_binaria = C.text_to_bin(clave);
        mensaje_binario = C.text_to_bin(mensaje);
        System.out.print("Mensaje: ");
        for(int i = 0; i < mensaje.length()*8; i++){
            System.out.print(mensaje_binario[i]);
        }
        System.out.println();
        System.out.print("Clave: ");
        for(int i = 0; i < clave.length()*8; i++){
            System.out.print(clave_binaria[i]);
        }
        System.out.println();
        //System.out.println(mensaje_binario.length);
        //System.out.println(mensaje.length());
        int[] fin = C.encriptar(clave_binaria, mensaje_binario, 5);
        System.out.print("Mensaje encriptado: ");
        for(int i = 0; i < fin.length; i++){
            System.out.print(fin[i]);
        }
        System.out.println();
        int[] fin_nuevo = C.encriptar(clave_binaria, fin, 5);
        System.out.print("Mensaje descencriptado: ");
        for(int i = 0; i < fin_nuevo.length; i++){
            System.out.print(fin_nuevo[i]);
        }
        System.out.println();
        String valor_texto = C.bin_to_text(fin_nuevo);
        System.out.println(valor_texto);
    }
    
}
