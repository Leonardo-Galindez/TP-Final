/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;

import Clase.Estadio;

/**
 *
 * @author galin
 */
public class Abreviatura {

    public static int posEstadio(Estadio Estadios[], int numEstadio, int i) {
        int pos = 0;
        if (i < Estadios.length) {
            if (numEstadio == Estadios[i].getNumero()) {
                pos = i;
            } else {
                pos = posEstadio(Estadios, numEstadio, i + 1);
            }
        }

        return pos;
    }

    public static String abreviatura(Estadio Estadios[], int numEstadio, int pos) {
        String nomOficial, nomModificado = "";
        nomOficial = Estadios[numEstadio].getNombre().toLowerCase();
        nomOficial = nomOficial.trim();
        if (pos < nomOficial.length()) {
            if (nomOficial.charAt(pos) == 'a' || nomOficial.charAt(pos) == 'e' || nomOficial.charAt(pos) == 'i' || nomOficial.charAt(pos) == 'o' || nomOficial.charAt(pos) == 'u') {
                nomModificado = abreviatura(Estadios, numEstadio, pos + 1);
            } else {
                nomModificado = nomModificado + nomOficial.charAt(pos) + abreviatura(Estadios, numEstadio, pos + 1);
            }
        }
        return nomModificado;
    }

}
