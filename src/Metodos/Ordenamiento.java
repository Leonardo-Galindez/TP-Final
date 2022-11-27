/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;

/**
 *
 * @author galin
 */
import Clase.Estadio;

public class Ordenamiento {

//Insercion--------------------------------------------------
//Ascendentemente
    public static void insercionA(Estadio Estadios[], int cantEstadios) {

        for (int i = 1; i < cantEstadios; i++) {
            reubicarA(Estadios, i);
        }

    }

    public static void reubicarA(Estadio Estadios[], int i) {
        int j;
        Estadio auxEstadio = new Estadio(0);
        auxEstadio = Estadios[i];
        j = i - 1;
        while (j >= 0 && Estadios[j].CompareTo(auxEstadio) > 0) {
            Estadios[j + 1] = Estadios[j];
            j--;
        }
        Estadios[j + 1] = auxEstadio;
    }
//Descendentemente
//hacer pruebas y decir veces mas rapido

    public static void insercionD(Estadio Estadios[], int cantEstadios) {
        for (int i = 1; i < cantEstadios; i++) {
            reubicarD(Estadios, i);
        }
    }

    public static void reubicarD(Estadio Estadios[], int i) {
        int j;
        Estadio auxEstadio = new Estadio(0);
        auxEstadio = Estadios[i];
        j = i - 1;
        while (j >= 0 && Estadios[j].CompareTo(auxEstadio) < 0) {
            Estadios[j + 1] = Estadios[j];
            j--;
        }
        Estadios[j + 1] = auxEstadio;
    }

//quicksort--------------------------------------------------Hacer traza del quicksort°°°°°°°°°°°°!!!!!!
    // Ascendentemente
    public static void quicksortA(Estadio Estadios[], int izq, int der) {
        Estadio pivoteEstadio = new Estadio(0);
        Estadio auxEstadio = new Estadio(0);
        pivoteEstadio = Estadios[izq];          // tomamos primer elemento como pivote
        int i = izq;                            // i realiza la búsqueda de izquierda a derecha
        int j = der;                            // j realiza la búsqueda de derecha a izquierda

        while (i < j) {                         // mientras no se crucen las búsquedas                                   
            while (Estadios[i].CompareTo(pivoteEstadio) <= 0 && i < j) {
                i++;                            // busca elemento mayor que pivote
            }
            while (Estadios[j].CompareTo(pivoteEstadio) > 0) {
                j--;                            // busca elemento menor que pivote
            }
            if (i < j) {                        // si no se han cruzado                      
                auxEstadio = Estadios[i];                     // los intercambia
                Estadios[i] = Estadios[j];
                Estadios[j] = auxEstadio;
            }
        }

        Estadios[izq] = Estadios[j];                         // se coloca el pivote en su lugar de forma que tendremos                                    
        Estadios[j] = pivoteEstadio;                         // los menores a su izquierda y los mayores a su derecha

        if (izq < j - 1) {
            quicksortA(Estadios, izq, j - 1);          // ordenamos subarray izquierdo
        }
        if (j + 1 < der) {
            quicksortA(Estadios, j + 1, der);          // ordenamos subarray derecho
        }
    }

    //Descendentemente
    public static void quicksortD(Estadio Estadios[], int izq, int der) {
        Estadio pivoteEstadio = new Estadio(0);
        Estadio auxEstadio = new Estadio(0);
        pivoteEstadio = Estadios[izq];          // tomamos primer elemento como pivote
        int i = izq;                            // i realiza la búsqueda de izquierda a derecha
        int j = der;                            // j realiza la búsqueda de derecha a izquierda

        while (i < j) {                         // mientras no se crucen las búsquedas                                   
            while (Estadios[i].CompareTo(pivoteEstadio) >= 0 && i < j) {
                i++;                            // busca elemento mayor que pivote
            }
            while (Estadios[j].CompareTo(pivoteEstadio) < 0) {
                j--;                            // busca elemento menor que pivote
            }
            if (i < j) {                        // si no se han cruzado                      
                auxEstadio = Estadios[i];                     // los intercambia
                Estadios[i] = Estadios[j];
                Estadios[j] = auxEstadio;
            }
        }

        Estadios[izq] = Estadios[j];                         // se coloca el pivote en su lugar de forma que tendremos                                    
        Estadios[j] = pivoteEstadio;                         // los menores a su izquierda y los mayores a su derecha

        if (izq < j - 1) {
            quicksortD(Estadios, izq, j - 1);          // ordenamos subarray izquierdo
        }
        if (j + 1 < der) {
            quicksortD(Estadios, j + 1, der);          // ordenamos subarray derecho
        }
    }
}
