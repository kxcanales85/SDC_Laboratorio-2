/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Arrays;

/**
 *
 * @author Fernando
 */
public class Cifrador {
    
    
    
    public Cifrador(){}
    
    public int[] text_to_bin(String mensaje){
        int[] mensaje_binario = new int[mensaje.length()*8];
        int x, indice = 0, auxiliar;
        String n;
        for(int i = 0; i < mensaje.length(); i++){
            x = mensaje.charAt(i);
            n = Integer.toBinaryString(x);
            int diferencia = 8 - n.length();
                while(diferencia != 0){
                    mensaje_binario[indice] = 0;
                    indice++;
                    diferencia--;
                }
            for(int j = 0; j < n.length(); j++){
                auxiliar = (int) n.charAt(j) - 48;
                mensaje_binario[indice] = auxiliar;
                indice++;
            }
        }
        return mensaje_binario;
    }
    
    public String bin_to_text(int[] mensaje){
        int n,k=0,p=0;
        String msj_aux;
        char[] aux = new char[8];
        char[] mensaje_final = new char[(mensaje.length)/8];
        int[] auxiliar = new int[8];
        for(int i = 0; i < (mensaje.length)/8; i++){
            for(int j = 0;j < 8; j++){
                auxiliar[j] = mensaje[k];
                k++;
            }
            msj_aux = Arrays.toString(auxiliar);
            for(int l = 1; l <=msj_aux.length()-2; l = l+3){
                aux[p] = msj_aux.charAt(l);
                p++;
                if(l==msj_aux.length()-2){p=0;}
                
            }
            n = Integer.parseInt(String.valueOf(aux),2);
            mensaje_final[i] = (char)n;
        }
        return String.valueOf(mensaje_final);
    }
   
    
    public String mensajeCifrado(int[] msj_cifrado){
        
        String msj_aux = Arrays.toString(msj_cifrado);
        char[] mensaje = new char[msj_cifrado.length];
        int k = 0;
        
        for(int i = 1; i<=msj_aux.length()-2; i=i+3){
            mensaje[k] = msj_aux.charAt(i);
            k++;
        }
        
        return String.valueOf(mensaje);
    }
    
    public int[] string_to_int(String mensaje){
        
        int[] msj = new int[mensaje.length()];
        
        for(int i = 0; i<mensaje.length(); i++){
            msj[i] = Integer.parseInt(String.valueOf(mensaje.charAt(i)));
        }
        
        return msj;
        
    }
    
    public int[] encriptar(int[] clave, int[] mensaje, int tamano){
        int resto = mensaje.length % tamano*8;
        int[] mensaje_codificado = new int[mensaje.length];
        int indice = 0;
        if(resto != 0){
            System.out.println("Hay que rellenar con 0's");
            int bits_faltantes = (tamano*8) - resto;
            int[] mensaje_final;
            mensaje_final = new int[mensaje.length+bits_faltantes];
            System.arraycopy(mensaje, 0, mensaje_final, 0, mensaje.length);
            for(int i = mensaje.length; i < mensaje.length+bits_faltantes; i++){
                mensaje_final[i] = 0;
            }
            int k = 0; /*Indice para la clave*/
            for(int i = 0; i < mensaje_codificado.length; i++){
                mensaje_codificado[indice] = mensaje_final[i] ^ clave[k];
                indice++;
                k = k + 1;
                if(k == clave.length){
                    k = 0; /*Se reinicia el indice para la clave*/
                }
            }
        }
        else{
            System.out.println("No debemos hacer nada");
            int k = 0; /*Indice para la clave*/
            for(int i = 0; i < mensaje_codificado.length; i++){
                mensaje_codificado[indice] = mensaje[i] ^ clave[k];
                indice++;
                k = k + 1;
                if(k == clave.length){
                    k = 0; /*Se reinicia el indice para la clave*/
                }
            }
        }
        return mensaje_codificado;
    }
}
