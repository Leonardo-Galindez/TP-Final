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
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Archivo {

    static final String direccion = "C:\\Users\\galin\\Documents\\NetBeansProjects\\TP-Final\\TP-Final\\src\\txt\\estadiosMundiales.txt";//cambio de ruta

    public static void main(String[] args) {

        Estadio Estadios[] = new Estadio[100];
        leerTxt(direccion, Estadios);
        MostrarEstadios(Estadios);
    }

    public static void leerTxt(String direccion, Estadio Estadios[]) {//direccion del archivo txt
        try {
            String Atributos[] = new String[5];
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String linea;
            while ((linea = bf.readLine()) != null) {//repite mientras bfRead tiene datos

                CargarEstadio(Estadios,linea);

            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }

    }

    public static void ObtenerAtributos(String linea,String Atributos[]) {//separao la linea en atributos y lo guardo en un arreglo
        
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
        System.out.println("hola mundo");
    }

    public static void CargarEstadio(Estadio Estadios[], String linea) {//le asigno los atributos al estadio
        String Atributos[] = new String[5];
        for (int j = 0; j < Estadios.length; j++) {
            ObtenerAtributos(linea,Atributos);
            Estadio nuevoEstadio = new Estadio(Atributos[0]);
            Estadios[j] = nuevoEstadio;
            Estadios[j].setNombre(Atributos[1]);
            Estadios[j].setCiudad(Atributos[2]);
            Estadios[j].setCapacidad(Atributos[3]);
            Estadios[j].setMundial(Atributos[4]);
        }

    }
    
    public static void MostrarEstadios(Estadio Estadios[]){
        for(int i=0;i<Estadios.length;i++){
            System.out.println(Estadios[i].toString());
        }
    }
}


