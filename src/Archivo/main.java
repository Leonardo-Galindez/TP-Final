/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivo;

import Clase.Estadio;
import java.util.Scanner;

/**
 *
 * @author galin
 */
public class main {

    static final String direccion = "C:\\Users\\galin\\Documents\\NetBeansProjects\\TP-Final\\TP-Final\\src\\txt\\estadiosMundiales.txt";//variable estica porque??

    public static void main(String[] args) {
        int rta;
        boolean valor = false;
        Scanner sc = new Scanner(System.in);
        Estadio Estadios[] = new Estadio[100];
        LeerArchivo.leerTxt(direccion, Estadios);//metodo para leer el archivo
        //LeerArchivo.MostrarEstadios(Estadios);

        do {
            System.out.println("");
            System.out.println("Ingrese Orden de ordenamineto");
            System.out.println("Ascendentemente------------1");
            System.out.println("Descendentemente-----------2");
            System.out.println("Finalizar------------------0");
            rta = sc.nextInt();
            switch (rta) {

                case 1://Descendentemente
                    Ordenamiento.insercionA(Estadios);
                    LeerArchivo.MostrarEstadios(Estadios);
                    break;
                case 2://Ascendentemente
                    Ordenamiento.insercionD(Estadios);
                    LeerArchivo.MostrarEstadios(Estadios);
                    break;
                case 0://Finalizar
                    valor = true;
                    break;
                default:
                    System.out.println("Error");
                    break;
            }

        } while (!valor);
        
        //LeerArchivo.MostrarEstadios(Estadios);
    }
}
