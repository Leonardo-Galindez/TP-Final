/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivo;

import Metodos.Ordenamiento;//llamada a los metodos de ordenamiento
import Clase.Estadio;
import Metodos.Abreviatura;
import java.util.Scanner;

/**
 *
 * @author galin
 */
public class main {

    //metodos estaticos explicacion
    static final String direccion = "C:\\Users\\galin\\Documents\\NetBeansProjects\\TP-Final\\TP-Final\\src\\Archivo\\txt\\estadiosMundiales.txt";//variable estica porque??

    public static void main(String[] args) {
        int rta, cantEstadios;
        boolean valor = false;
        Scanner sc = new Scanner(System.in);
        Estadio Estadios[] = new Estadio[1000000];
        cantEstadios = LeerArchivo.leerTxt(direccion, Estadios, 1);//metodo para leer el archivo
        //LeerArchivo.MostrarEstadios(Estadios);

        do {
            System.out.println("");
            //menu
            System.out.println("Ordenamiento quicksort por Ciudad--------------1");
            System.out.println("Ordenamiento insercion por Ciudad--------------2");
            System.out.println("Abreviatura------------------------------------3");
            System.out.println("Finalizar--------------------------------------0");

            rta = sc.nextInt();
            valor = Menu(rta, Estadios, cantEstadios);

        } while (!valor);

    }

    public static boolean Menu(int rta, Estadio Estadios[], int cantEstadios) {
        int numEstadio, pos = 0, posEstadio, rtaSub;
        boolean valor = false;
        String nomModificado;

        Scanner sc = new Scanner(System.in);
        switch (rta) {

            case 1://quicksort
                System.out.println("Ingrese orden ");
                System.out.println("Ascendente-------1");
                System.out.println("Descendente------2");

                rtaSub = sc.nextInt();
                if (rtaSub == 1) {
                    Ordenamiento.quicksortA(Estadios, 0, cantEstadios - 1);
                    LeerArchivo.MostrarEstadios(Estadios, cantEstadios);
                } else {
                    if (rtaSub == 2) {
                        Ordenamiento.quicksortD(Estadios, 0, cantEstadios - 1);
                        LeerArchivo.MostrarEstadios(Estadios, cantEstadios);
                    } else {
                        System.out.println("Error");
                    }
                }
                break;
            case 2://insercion
                System.out.println("Ingrese orden ");
                System.out.println("Ascendente-------1");
                System.out.println("Descendente------2");

                rtaSub = sc.nextInt();
                if (rtaSub == 1) {
                    Ordenamiento.insercionA(Estadios, cantEstadios);
                    LeerArchivo.MostrarEstadios(Estadios, cantEstadios);
                } else {
                    if (rtaSub == 2) {
                        Ordenamiento.insercionD(Estadios, cantEstadios);
                        LeerArchivo.MostrarEstadios(Estadios, cantEstadios);
                    } else {
                        System.out.println("Error");
                    }
                }

                break;

            case 3://Abreviatura
                System.out.println("Ingrese numero Estadio");
                numEstadio = sc.nextInt();

                posEstadio = Abreviatura.posEstadio(Estadios, numEstadio, pos);
                nomModificado = Abreviatura.abreviatura(Estadios, posEstadio, pos);
                nomModificado = Abreviatura.Mayuscula(nomModificado);

                System.out.println(Estadios[posEstadio].getNombre());
                System.out.println(nomModificado);

                break;
            case 0://Finalizar
                valor = true;
                break;
            default:
                System.out.println("Error");
                break;
        }

        return valor;
    }
}
