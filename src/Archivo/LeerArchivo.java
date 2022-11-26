/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivo;

/**
 *
 * @author galin
 */
//import java.io.*
import Clase.Estadio;
import java.io.BufferedReader;//tomar cada linea y asignarla a una variable
import java.io.FileNotFoundException;// avisa si el archivo ni existe
import java.io.FileReader;//clase para leer el archivo
import java.io.IOException;// avisa si el archivo no tiene los permisos o esta abierto

public class LeerArchivo {
    //cantidad de lineas del texto
    //arreglo sobre sobredimensionado
    //restar dividir

    public static int leerTxt(String direccion, Estadio Estadios[], int cantEstadios) {//direccion del archivo txt
        try {
            int j = 0, cantAtributos = 5;//implementar split
            String Atributos[] = new String[cantAtributos];
            BufferedReader bf = new BufferedReader(new FileReader(direccion));//buffer lee linea por linea
            String linea;
            while ((linea = bf.readLine()) != null) {//repite mientras bf tiene datos
                ObtenerAtributos(linea, Atributos);//obtenemos los atributos separados en un arreglo
                CargarEstadio(Estadios, Atributos, j);//mandamos el arreglo atributos para cargarlo en el arreglo de los estadios
                j++;//j es la variable iteradora que la usamos en la cargar del estadio
                cantEstadios++;//tenemos un control de la cantidad de estadios que se cargaron
            }
            bf.close();//cerramos el archivo

        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }

        return cantEstadios - 1;

    }//split

    public static void ObtenerAtributos(String linea, String Atributos[]) {//separao la linea en atributos y lo guardo en un arreglo
        String atributo;
        int i = 0, posIni = 0, posEnd;
        //int numero,capacidad;
        while (i < Atributos.length) {
            posEnd = linea.indexOf("|", posIni);
            atributo = linea.substring(posIni, posEnd);
            Atributos[i] = atributo;
            posIni = posEnd + 1;
            i++;
        }
    }

    public static void CargarEstadio(Estadio Estadios[], String Atributos[], int j) {//le asigno los atributos al estadio
        String nombre, ciudad, mundial;
        int numero, capacidad;
        numero = Integer.parseInt(Atributos[0]);//convertimos string a int
        nombre = Atributos[1].trim();
        ciudad = Atributos[2].trim();
        capacidad = Integer.parseInt(Atributos[3]);//convertimos string a int
        mundial = Atributos[4].trim();

        Estadio nuevoEstadio = new Estadio(numero, nombre, ciudad, capacidad, mundial);
        Estadios[j] = nuevoEstadio;
    }

    //mostrar los estadios
    public static void MostrarEstadios(Estadio Estadios[], int cantEstadios) {
        for (int i = 0; i < cantEstadios; i++) {//hasta 25 porque con 100 sale error
            System.out.println(Estadios[i].toString());
            System.out.println("");
        }
    }
}
