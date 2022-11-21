/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivo;

import Clase.Estadio;
import Metodos.Abreviatura;
import Metodos.LetraMayuscula;
import java.util.Scanner;

/**
 *
 * @author galin
 */
public class main {

    static final String direccion = "C:\\Users\\galin\\OneDrive\\Documentos\\NetBeansProjects\\TP-Final\\src\\txt\\estadiosMundiales.txt";//variable estica porque??

    public static void main(String[] args) {
        int rta, numEstadio, pos = 0, posEstadio;
        boolean valor = false;
        String nomOficial, nomModificado, letra = "";
        Scanner sc = new Scanner(System.in);
        Estadio Estadios[] = new Estadio[100];
        LeerArchivo.leerTxt(direccion, Estadios);//metodo para leer el archivo
        //LeerArchivo.MostrarEstadios(Estadios);

        do {
            System.out.println("");
            //menu
            System.out.println("Ordenamiento Ascendentemente por Ciudad--------1");
            System.out.println("Ordenamiento Descendentemente por Ciudad-------2");
            System.out.println("Abreviatura------------------------------------3");
            System.out.println("Finalizar--------------------------------------0");

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

                case 3://Abreviatura
                    System.out.println("Ingrese numero Estadio");
                    numEstadio = sc.nextInt();

                    posEstadio = Abreviatura.posEstadio(Estadios, numEstadio, pos);
                    nomModificado = Abreviatura.abreviatura(Estadios, posEstadio, pos);
                    nomModificado = LetraMayuscula.Mayuscula(nomModificado);

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
}
