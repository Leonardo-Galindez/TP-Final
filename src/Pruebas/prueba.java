package Pruebas;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author galin
 */
import java.util.Scanner;
//cambios

public class prueba {

    public static void main(String[] args) {

        
        
        /*double Itiempo = System.nanoTime();
        System.out.println(Itiempo);
        double Ftiempo = System.nanoTime();
        System.out.println(Ftiempo);
        double T = Ftiempo - Itiempo;
        System.out.println(T);
        int A[] = {4, 8, 1,3,0};
        int izq = 0, der = A.length - 1;
        MostrarArray(A);
        quicksort(A, izq, der);
        System.out.println("");
        MostrarArray(A);*/
    }

    public static void quicksort(int A[], int izq, int der) {

        int pivote = A[izq];                    // tomamos primer elemento como pivote
        int i = izq;                            // i realiza la búsqueda de izquierda a derecha
        int j = der;                            // j realiza la búsqueda de derecha a izquierda
        int aux;

        while (i < j) {                         // mientras no se crucen las búsquedas                                   
            while (A[i] <= pivote && i < j) {   //evalua de izquierda a derecha cuales son menores que el pivote
                i++;                            // busca elemento mayor que pivote
            }
            while (A[j]>= pivote) {             
                j--;                            // repite hasta encontrar el elemento menor que el pivote
            }
            if (i < j) {                        // si no se han cruzado                      
                aux = A[i];                     // los intercambia el elemento mayor y el menor encontrado anteriormente
                A[i] = A[j];
                A[j] = aux;
            }
        }
                                                //al terminar el ciclo while quire decir que se han cruzado 
        A[izq] = A[j];                         // se coloca el pivote en su lugar de forma que tendremos                                    
        A[j] = pivote;                         // los menores a su izquierda y los mayores a su derecha

        if (izq < j - 1) {
            quicksort(A, izq, j - 1);          // ordenamos subarray izquierdo
        }
        if (j + 1 < der) {
            quicksort(A, j + 1, der);          // ordenamos subarray derecho
        }
    }

    public static void MostrarArray(int A[]) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + "-");
        }
    }

}
