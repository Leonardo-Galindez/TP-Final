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

    //jueves 23:59
    //defensa martes  8:30 a 10:30 y jueves 10:30 a 12:30
    //definimos una variable constante para todas las clases    
    static final String direccion = "C:\\Users\\galin\\OneDrive\\Documentos\\NetBeansProjects\\TP-Final\\src\\Archivo\\estadiosMundiales.txt";

    public static void main(String[] args) {
        int rta, cantEstadios;
        boolean valor = false;
        int numEstadio, pos = 0, posEstadio, rtaSub;
        double tiempoI, tiempoF, tiempoTotal;
        String nomModificado;
        Scanner sc = new Scanner(System.in);
        Estadio Estadios[] = new Estadio[1000000];//definimos un arreglo sobredimensionado
        cantEstadios = LeerArchivo.leerTxt(direccion, Estadios, 1);//metodo para leer el archivo
        Estadio copiaEstadios[] = new Estadio[cantEstadios];//

        //crar copia arreglo
        do {
            //Menu
            rta = MostrarMenu();//consultar sobre si esta bien la copia arreglo
            switch (rta) {
                //meter los sub menus en el menu principal o agregar condiciones de corte
                case 1:
                    //Mostramos el estadio original
                    LeerArchivo.MostrarEstadios(Estadios, cantEstadios);
                    break;
                case 2://quicksort
                    rtaSub = MostrarSubMenu();

                    switch (rtaSub) {
                        case 1:
                            copiarArreglo(Estadios, copiaEstadios);
                            tiempoI=0;
                            tiempoI = System.nanoTime();//iniciamos el tiempo
                            Ordenamiento.quicksortA(copiaEstadios, 0, cantEstadios - 1);
                            LeerArchivo.MostrarEstadios(copiaEstadios, cantEstadios);
                            tiempoF = System.nanoTime();//finalizamos el tiempo
                            tiempoTotal = tiempoF - tiempoI;//tiempo total
                            tiempoTotal = tiempoTotal * 0.000000001;//pasamos a segundos 
                            System.out.println("tiempo quicksort Ascendiente:" + tiempoTotal);
                            break;
                        case 2:
                            copiarArreglo(Estadios, copiaEstadios);
                            tiempoI=0;
                            tiempoI = System.nanoTime();//modularizar
                            Ordenamiento.quicksortD(copiaEstadios, 0, cantEstadios - 1);
                            LeerArchivo.MostrarEstadios(copiaEstadios, cantEstadios);
                            tiempoF = System.nanoTime();
                            tiempoTotal = tiempoF - tiempoI;
                            tiempoTotal = tiempoTotal * 0.000000001;
                            System.out.println("tiempo quicksort descendiente:" + tiempoTotal);
                            break;
                        case 0:
                            System.out.println("Finalizado");
                            break;
                        default:
                            System.out.println("Error");
                            break;
                    }
                    break;
                case 3://insercion

                    rtaSub = MostrarSubMenu();

                    switch (rtaSub) {
                        case 1:
                            copiarArreglo(Estadios, copiaEstadios);
                            tiempoI=0;
                            tiempoI = System.nanoTime();//tiempo inicial  cambiar a long
                            Ordenamiento.insercionA(copiaEstadios, cantEstadios);
                            LeerArchivo.MostrarEstadios(copiaEstadios, cantEstadios);
                            tiempoF = System.nanoTime();//tiempo final
                            tiempoTotal = tiempoF - tiempoI;//tiempo total
                            tiempoTotal = tiempoTotal * 0.000000001;
                            System.out.println("tiempo insercion Ascendiente:" + tiempoTotal);
                            break;
                        case 2:
                            copiarArreglo(Estadios, copiaEstadios);
                            tiempoI=0;
                            tiempoI = System.nanoTime();
                            Ordenamiento.insercionD(copiaEstadios, cantEstadios);
                            LeerArchivo.MostrarEstadios(copiaEstadios, cantEstadios);
                            tiempoF = System.nanoTime();
                            tiempoTotal = tiempoF - tiempoI;
                            tiempoTotal = tiempoTotal * 0.000000001;
                            System.out.println("tiempo insercion descendiente:" + tiempoTotal);
                            break;
                        case 0:
                            System.out.println("Finalizado");
                            break;
                        default:
                            System.out.println("Error");
                            break;

                    }

                    break;

                case 4://Abreviatura

                    do {
                        System.out.println("Ingrese numero Estadio");
                        numEstadio = sc.nextInt();
                    } while (numEstadio > cantEstadios || numEstadio <= 0);//solo puede ingresar un numero valido

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
        } while (!valor);

    }

    public static void copiarArreglo(Estadio[] arr, Estadio[] copia) {
        for (int i = 0; i < copia.length; i++) {
            copia[i] = arr[i];
        }

    }

    public static int MostrarSubMenu() {
        int rtaSub;
        Scanner sc = new Scanner(System.in);
        //SubMenu
        System.out.println("Ingrese orden ");
        System.out.println("Ascendente--------1");
        System.out.println("Descendiente------2");
        System.out.println("Finalizar---------0");
        rtaSub = sc.nextInt();
        return rtaSub;
    }

    public static int MostrarMenu() {
        int rta;
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        //menu
        System.out.println("Ordenado por numero de Estadio-----------------1");
        System.out.println("Ordenamiento quicksort por Ciudad--------------2");
        System.out.println("Ordenamiento insercion por Ciudad--------------3");
        System.out.println("Abreviatura------------------------------------4");
        System.out.println("Finalizar--------------------------------------0");

        rta = sc.nextInt();
        return rta;
    }
}
