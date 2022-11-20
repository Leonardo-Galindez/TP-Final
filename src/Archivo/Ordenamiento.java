/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivo;

/**
 *
 * @author galin
 */
import Clase.Estadio;

public class Ordenamiento {
//Ascendentemente

    public static void insercionA(Estadio Estadios[]) {
        for (int i = 1; i < Estadios.length; i++) {
            reubicarA(Estadios, i);
        }
    }

    public static void reubicarA(Estadio Estadios[], int i) {
        int j;
        Estadio auxEstadio = new Estadio(0);
        auxEstadio = Estadios[i];
        j = i - 1;
        if(Estadios[j].CompareTo(auxEstadio) == 0){
            
        }
        while (j > 0 && Estadios[j].CompareTo(auxEstadio) > 1) {
            Estadios[j + 1] = Estadios[j];
            j--;
        }
        Estadios[j + 1] = auxEstadio;
    }

//Descendentemente
    public static void insercionD(Estadio Estadios[]) {
        for (int i = 1; i < Estadios.length; i++) {
            reubicarD(Estadios, i);
        }
    }

    public static void reubicarD(Estadio Estadios[], int i) {
        int j;
        Estadio auxEstadio = new Estadio(0);
        auxEstadio = Estadios[i];
        j = i - 1;
        while (j > 0 && Estadios[j].CompareTo(auxEstadio) < 1) {
            Estadios[j + 1] = Estadios[j];
            j--;
        }
        Estadios[j + 1] = auxEstadio;
    }
}
