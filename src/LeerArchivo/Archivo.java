/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LeerArchivo;

/**
 *
 * @author galin
 */
//import java.io.*
import clases.Estadio;
import java.io.BufferedReader;//sierve para leer el archivo
import java.io.FileNotFoundException;// se usa en el primer catch?????
import java.io.FileReader;// se usa en el primer catch????
import java.io.IOException;// se usa en el segundo catch

public class Archivo {

    static final String direccion = "C:\\Users\\galin\\Documents\\NetBeansProjects\\TP-Final\\TP-Final\\src\\txt\\estadiosMundiales.txt";//variable estica porque??
// ruta del archivo

    public static void main(String[] args) {

        Estadio Estadios[] = new Estadio[100];
        leerTxt(direccion, Estadios);//metodo para leer el archivo
        MostrarEstadios(Estadios);
    }

    public static void leerTxt(String direccion, Estadio Estadios[]) {//direccion del archivo txt
        try {
            int j=0;
            String Atributos[] = new String[5];
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String linea;
            while ((linea = bf.readLine()) != null) {//repite mientras bfRead tiene datos
                ObtenerAtributos(linea, Atributos);//obtenemos los atributos separados en un arreglo
                CargarEstadio(Estadios, Atributos,j);//mandamos el arreglo atributos para cargarlo en el arreglo de los estadios
                j++;

            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    //getMessage()para que seria??
                    + "que queriamos leer no existe.");
        } catch (IOException ex) {//este catch para que serviria?
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }

    }

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
        //ERROR
        //Solo muestra hasta el 25

    }

    public static void CargarEstadio(Estadio Estadios[], String Atributos[],int j) {//le asigno los atributos al estadio

        String nombre, ciudad, mundial;
        int numero, capacidad;

        numero = Integer.parseInt(Atributos[0]);//convertimos string a int
        nombre = Atributos[1];
        ciudad = Atributos[2];
        capacidad = Integer.parseInt(Atributos[3]);//convertimos string a int
        mundial = Atributos[4];

        Estadio nuevoEstadio = new Estadio(numero, nombre, ciudad, capacidad, mundial);
        Estadios[j] = nuevoEstadio;

    }

    //mostrar los estadios
    public static void MostrarEstadios(Estadio Estadios[]) {
        for (int i = 0; i < 25; i++) {//hasta 25 porque con 100 sale error
            System.out.println(Estadios[i].toString());
            System.out.println("");
        }
    }
}
