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

    static final String direccion = "C:\\Users\\galin\\Documents\\NetBeansProjects\\TP-Final\\TP-Final\\src\\txt\\estadiosMundiales.txt";//variable estica porque??

    public static void main(String[] args) {
        int rta, numEstadio, pos = 0;
        boolean valor = false;
        String nomOficial, nomModificado,letra="";
        Scanner sc = new Scanner(System.in);
        Estadio Estadios[] = new Estadio[100];
        LeerArchivo.leerTxt(direccion, Estadios);//metodo para leer el archivo
        //LeerArchivo.MostrarEstadios(Estadios);

        do {
            System.out.println("");
            //menu
            System.out.println("Ordenamiento Ascendentemente por Ciudad--------1");
            System.out.println("Ordenamiento Descendentemente por Ciudad-------2");
            System.out.println("Ordenamineto Numero----------------------------3");
            //System.out.println("Abreviatura------------------------------------4");
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
                case 3:
                    LeerArchivo.MostrarEstadios(Estadios);
                    break;
                case 4:
                    System.out.println("Ingrese numero Estadio");
                    numEstadio = sc.nextInt();
                    nomModificado = Abreviatura.abreviatura(Estadios, numEstadio, pos);
                    nomModificado=LetraMayuscula.Mayuscula(nomModificado);
                    
                    System.out.println(Estadios[numEstadio].getNombre());
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

        //LeerArchivo.MostrarEstadios(Estadios);
    }
}
