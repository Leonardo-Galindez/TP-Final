/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;

/**
 *
 * @author galin
 */
//import java.io.*

//consulta sobre si esta bien explicado las clases ---------------------
import Clase.Estadio;
import java.io.BufferedReader;//tomar cada linea y asignarla a una variable
import java.io.FileNotFoundException;// avisa si el archivo ni existe
import java.io.FileReader;//clase para leer el archivo
import java.io.IOException;// avisa si el archivo no tiene los permisos o esta abierto

public class LeerArchivo {

    public static int leerTxt(String direccion, Estadio Estadios[], int cantEstadios) {
        try {
            int j = 0, cantAtributos = 5;//Si agregamos mas atributos le asignamos mas posiciones al array
            String Atributos[] = new String[cantAtributos];
            BufferedReader bf = new BufferedReader(new FileReader(direccion));//buffer lee linea por linea
            String linea;
            while ((linea = bf.readLine()) != null) { //repite mientras bf tiene datos
                ObtenerAtributos(linea, Atributos);   //obtenemos los atributos separados en un arreglo
                CargarEstadio(Estadios, Atributos, j);//mandamos el arreglo atributos para cargarlo a cada estadio
                j++;//j es la variable iteradora que la usamos en la cargar del estadio
                cantEstadios++;//tenemos un control de la cantidad de estadios que se cargaron al arreglo
            }
            bf.close();//cerramos el archivo
        } catch (FileNotFoundException ex) {//error de archivo no encontrado
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        } catch (IOException ex) {//error de permisos
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
        //podemos agregar otro catch Exception y mostrar cualquier error
        return cantEstadios - 1;
    }
    //separa la linea en atributos y lo guardo en un arreglo
    public static void ObtenerAtributos(String linea, String Atributos[]) {
        
        String atributo;
        int i = 0, posIni = 0, posEnd;
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

        Estadio nuevoEstadio = new Estadio(numero, nombre, ciudad, capacidad, mundial);//constructor 
        Estadios[j] = nuevoEstadio;//asignamos el objeto a al arreglo segun la posicion j
    }

    public static void MostrarEstadios(Estadio Estadios[], int cantEstadios) {
        for (int i = 0; i < cantEstadios; i++) {
            System.out.println(Estadios[i].toString());
            System.out.println("");//salto
        }
    }
}
