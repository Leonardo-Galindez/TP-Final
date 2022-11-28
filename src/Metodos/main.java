/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;

import Metodos.LeerArchivo;
import Clase.Estadio;
import java.util.Scanner;

/**
 *
 * @author galin
 */
public class main {
        
    static final String direccion = "C:\\Users\\galin\\Documents\\NetBeansProjects\\TP-Final\\TP-Final\\src\\Archivo\\estadiosMundiales.txt";//variable estica porque??

    public static void main(String[] args) {
        int rta, cantEstadios;
        boolean valor = false;
        Scanner sc = new Scanner(System.in);
        Estadio Estadios[] = new Estadio[1000000];//definimos un arreglo sobredimensionado
        cantEstadios = LeerArchivo.leerTxt(direccion, Estadios, 1);//metodo para leer el archivo
        

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
                if (rtaSub == 1) {//Ascendiente
                    //Consultar sobre si esta bien aplicado el nanoTime()---------------------------------------
                    double tiempoI = System.nanoTime();//iniciamos el tiempo
                    Ordenamiento.quicksortA(Estadios, 0, cantEstadios - 1);
                    LeerArchivo.MostrarEstadios(Estadios, cantEstadios);
                    double tiempoF = System.nanoTime();//finalizamos el tiempo
                    double tiempoTotal = tiempoF - tiempoI;//tiempo total
                    tiempoTotal = tiempoTotal * 0.000000001;//pasamos a segundos 
                    System.out.println("tiempo insercion Ascendiente:" + tiempoTotal);

                } else {
                    if (rtaSub == 2) {//Descendiente
                        double tiempoI = System.nanoTime();
                        Ordenamiento.quicksortD(Estadios, 0, cantEstadios - 1);
                        LeerArchivo.MostrarEstadios(Estadios, cantEstadios);
                        double tiempoF = System.nanoTime();
                        double tiempoTotal = tiempoF - tiempoI;
                        tiempoTotal = tiempoTotal * 0.000000001;
                        System.out.println("tiempo insercion Ascendiente:" + tiempoTotal);
                    } else {
                        System.out.println("Error");
                    }
                }
                break;
            case 2://insercion
                System.out.println("Ingrese orden ");
                System.out.println("Ascendente-------1");
                System.out.println("Descendiente------2");

                rtaSub = sc.nextInt();
                if (rtaSub == 1) {//Ascendiente
                    double tiempoI = System.nanoTime();//tiempo inicial
                    Ordenamiento.insercionA(Estadios, cantEstadios);
                    LeerArchivo.MostrarEstadios(Estadios, cantEstadios);
                    double tiempoF = System.nanoTime();//tiempo final
                    double tiempoTotal = tiempoF - tiempoI;//tiempo total
                    tiempoTotal = tiempoTotal * 0.000000001;
                    System.out.println("tiempo insercion Ascendiente:" + tiempoTotal);
                } else {
                    if (rtaSub == 2) {//Descendiente
                        double tiempoI = System.nanoTime();
                        Ordenamiento.insercionD(Estadios, cantEstadios);
                        LeerArchivo.MostrarEstadios(Estadios, cantEstadios);
                        double tiempoF = System.nanoTime();
                        double tiempoTotal = tiempoF - tiempoI;
                        tiempoTotal = tiempoTotal * 0.000000001;
                        System.out.println("tiempo insercion Ascendiente:" + tiempoTotal);
                    } else {
                        System.out.println("Error");
                    }
                }

                break;

            case 3://Abreviatura

                do {
                    System.out.println("Ingrese numero Estadio");
                    numEstadio = sc.nextInt();
                } while (numEstadio >= cantEstadios || numEstadio <=0);//solo puede ingresar un numero valido

                posEstadio = Abreviatura.posEstadio(Estadios, numEstadio, pos, cantEstadios);
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
