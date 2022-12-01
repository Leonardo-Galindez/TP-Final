/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;
import Clase.Estadio;
public class Abreviatura {
    //metodo retorna la posicion del numero del estadio ingresado por teclado
    public static int posEstadio(Estadio Estadios[], int numEstadio, int i, int cantEstadios) {//consulta sobre modulo de busca de numero
        int pos = 0;
        if (i < cantEstadios) {
            if (numEstadio == Estadios[i].getNumero()) {
                pos = i;
            } else {
                pos = posEstadio(Estadios, numEstadio, i + 1, cantEstadios);
            }
        }
        System.out.println(pos);
        return pos;
    }
    //metodo que retorna una cadena sin vocales y sin espacios
    public static String abreviatura(Estadio Estadios[], int numEstadio, int pos) {
        String nomOficial, nomModificado = "";
        nomOficial = Estadios[numEstadio].getNombre().toLowerCase();
        nomOficial = nomOficial.trim();
        if (pos < nomOficial.length()) {
            if (nomOficial.charAt(pos) == 'a' || nomOficial.charAt(pos) == 'e' || nomOficial.charAt(pos) == 'i' || 
                    nomOficial.charAt(pos) == 'o' || nomOficial.charAt(pos) == 'u' || nomOficial.charAt(pos)==' ') {
                nomModificado = abreviatura(Estadios, numEstadio, pos + 1);
            } else {
                nomModificado = nomModificado + nomOficial.charAt(pos) + abreviatura(Estadios, numEstadio, pos + 1);
            }
        }
        return nomModificado;
    }
    //metodo vuelve la primer letra de la cadena  mayuscula
    public static String Mayuscula(String cadena) {
        String nuevaCadena = "";
        char letra;
        for (int i = 0; i < cadena.length(); i++) {//concatenamos una nueva cadena con la primerletra mayuscula
            if (i == 0) {                               //separamos la primer letra 
                letra = cadena.charAt(i);
                nuevaCadena = "" + letra;
                nuevaCadena = nuevaCadena.toUpperCase();//con el metodo toUpperCase la volvemos mayuscula
            } else {
                nuevaCadena = nuevaCadena + cadena.charAt(i);
            }
        }
        return nuevaCadena;
    }
}
