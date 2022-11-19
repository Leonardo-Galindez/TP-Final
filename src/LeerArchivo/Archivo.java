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

    static final String direccion = "C:\\Users\\galin\\Documents\\NetBeansProjects\\TP-Final\\TP-Final\\src\\txt\\estadiosMundiales.txt";

    public static void main(String[] args) {

        Estadio Estadios[] = new Estadio[100];
        leerTxt(direccion,Estadios);
    }

    public static void leerTxt(String direccion,Estadio Estadios[]) {//direccion del archivo txt
        String Atributos[] = new String[5]; 
        try {
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String linea;
            while ((linea = bf.readLine()) != null) {//repite mientras bfRead tiene datos
                Atributos=ObtenerAtributos(linea);
                CargarEstadio(Estadios,Atributos);
            }
        }  catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        }catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }

    }

    public static String[] ObtenerAtributos(String linea) {//separao la linea en atributos y lo guardo en un arreglo
        String Atributos[] = new String[5];
        String atributo;
        int i = 0, posIni=0,posEnd;
        //int numero,capacidad;
        while (i < Atributos.length) {
            posEnd = linea.indexOf("|", posIni);
            atributo = linea.substring(posIni, posEnd);
            Atributos[i] = atributo;
            posIni = posEnd+1;
            i++;
        }
        return Atributos;

    }
    public static void CargarEstadio(Estadio Estadios[],String Atributos[] ){//le asigno los atributos al estadio
        for(int i=0;i<Estadios.length;i++){
            Estadio nuevoEstadio= new Estadio(Atributos[0]);
            Estadios[i]=nuevoEstadio;
            Estadios[i].setNombre(Atributos[1]);
            Estadios[i].setCiudad(Atributos[2]);
            Estadios[i].setCapacidad(Atributos[3]);
            Estadios[i].setMundial(Atributos[4]);
        }
      
        
    }

}
