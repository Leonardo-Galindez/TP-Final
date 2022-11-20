/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;

/**
 *
 * @author galin
 */
public class LetraMayuscula {
    
    public static String Mayuscula(String cadena){
        String nuevaCadena="";
        char letra;
        for(int i=0;i<cadena.length();i++){
            if(i==0){
                letra=cadena.charAt(i);
                nuevaCadena=""+letra;
                nuevaCadena=nuevaCadena.toUpperCase();
            }else{
                nuevaCadena=nuevaCadena+cadena.charAt(i);
            }

        }
        return nuevaCadena;
    }
}
