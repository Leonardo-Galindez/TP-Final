/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pruebas;

import java.util.Scanner;

/**
 *
 * @author galin
 */
public class PruebasTrycatch {

    public static void main(String[] args) {
        String Atributos[] = new String[5];
        String atributo,linea;
        linea="K";
        int i = 0, posIni=0,posEnd;
        //int numero,capacidad;
        while (i < Atributos.length) {
            posEnd = linea.indexOf("|", posIni);
            atributo = linea.substring(posIni, posEnd);
            Atributos[i] = atributo;
            posIni = posEnd+1;
            i++;
        }
        for(i=0;i<5;i++){
            System.out.println(Atributos[i]);
        }
        
    }

}
