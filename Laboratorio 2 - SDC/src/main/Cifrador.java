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
