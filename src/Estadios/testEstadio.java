/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estadios;

import java.util.Scanner;
import java.io.BufferedReader;//tomar cada linea y asignarla a una variable
import java.io.FileNotFoundException;// avisa si el archivo ni existe
import java.io.FileReader;//clase para leer el archivo
import java.io.IOException;// avisa si el archivo no tiene los permisos o esta abierto

/**
 *
 * @author galin
 */
public class testEstadio {

    //jueves 23:59
    //defensa martes  8:30 a 10:30 y jueves 10:30 a 12:30
    //definimos una variable constante para todas las clases    
    static final String direccion = "C:\\Users\\galin\\OneDrive\\Documentos\\NetBeansProjects\\TP-Final\\src\\Archivo\\estadiosMundiales.txt";

    public static void main(String[] args) {
        int rta, cantEstadios, numEstadio, pos = 0, posEstadio, rtaSub;
        boolean valor = false;
        long tiempoI, tiempoF, tiempoTotal;
        String nomModificado;

        Scanner sc = new Scanner(System.in);
        Estadio Estadios[] = new Estadio[1000000];//definimos un arreglo sobredimensionado
        cantEstadios = leerTxt(direccion, Estadios, 1);//metodo para leer el archivo
        Estadio copiaEstadios[] = new Estadio[cantEstadios];
        do {
            //Menu
            rta = MostrarMenu();
            switch (rta) {

                case 1:
                    //Mostramos al arreglo de estadios original
                    MostrarEstadios(Estadios, cantEstadios);
                    break;
                case 2://quicksort
                    rtaSub = MostrarSubMenu();

                    switch (rtaSub) {
                        case 1:
                            copiarArreglo(Estadios, copiaEstadios);

                            tiempoI = System.nanoTime();                //iniciamos el tiempo
                            quicksortA(copiaEstadios, 0, cantEstadios - 1);
                            tiempoF = System.nanoTime();   //finalizamos el tiempo
                            MostrarEstadios(copiaEstadios, cantEstadios);

                            tiempoTotal = tiempoF - tiempoI;            //tiempo total
                            tiempoTotal = tiempoTotal;    //pasamos de nanosegundos a segundos 
                            System.out.println("tiempo quicksort Ascendiente:" + tiempoTotal);
                            break;
                        case 2:
                            copiarArreglo(Estadios, copiaEstadios);

                            tiempoI = System.nanoTime();
                            quicksortD(copiaEstadios, 0, cantEstadios - 1);
                            tiempoF = System.nanoTime();
                            MostrarEstadios(copiaEstadios, cantEstadios);

                            tiempoTotal = tiempoF - tiempoI;
                            tiempoTotal = tiempoTotal;
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

                            tiempoI = System.nanoTime();            //tiempo inicial  cambiar a long
                            insercionA(copiaEstadios, cantEstadios);
                            tiempoF = System.nanoTime();//tiempo final
                            MostrarEstadios(copiaEstadios, cantEstadios);

                            tiempoTotal = tiempoF - tiempoI;        //tiempo total
                            tiempoTotal = tiempoTotal;
                            System.out.println("tiempo insercion Ascendiente:" + tiempoTotal);
                            break;
                        case 2:
                            copiarArreglo(Estadios, copiaEstadios);

                            tiempoI = System.nanoTime();
                            insercionD(copiaEstadios, cantEstadios);
                            tiempoF = System.nanoTime();
                            MostrarEstadios(copiaEstadios, cantEstadios);

                            tiempoTotal = tiempoF - tiempoI;
                            tiempoTotal = tiempoTotal;
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

                    posEstadio = posEstadio(Estadios, numEstadio, pos, cantEstadios);
                    nomModificado = abreviatura(Estadios, posEstadio, pos);
                    nomModificado = Mayuscula(nomModificado);

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

    //Menus
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

    //Metod para leer el archivo txt
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

    //metodo para buscar la posicion del estadio
    public static int posEstadio(Estadio Estadios[], int numEstadio, int i, int cantEstadios) {
        int pos = 0;
        if (i < cantEstadios) {
            if (numEstadio == Estadios[i].getNumero()) {
                pos = i;
            } else {
                pos = posEstadio(Estadios, numEstadio, i + 1, cantEstadios);
            }
        }

        return pos;
    }

    //metodo que retorna una cadena sin vocales y sin espacios
    public static String abreviatura(Estadio Estadios[], int numEstadio, int pos) {
        String nomOficial, nomModificado = "";
        nomOficial = Estadios[numEstadio].getNombre().toLowerCase();//pasamos el nombre al minuscula para no tener problemas
        nomOficial = nomOficial.trim();
        if (pos < nomOficial.length()) {//buscamos las vocales y los espacios y los saltamos
            if (nomOficial.charAt(pos) == 'a' || nomOficial.charAt(pos) == 'e' || nomOficial.charAt(pos) == 'i'
                    || nomOficial.charAt(pos) == 'o' || nomOficial.charAt(pos) == 'u' || nomOficial.charAt(pos) == ' ') {
                nomModificado = abreviatura(Estadios, numEstadio, pos + 1);
            } else {
                nomModificado = nomModificado + nomOficial.charAt(pos) + abreviatura(Estadios, numEstadio, pos + 1);
            }
        }
        return nomModificado;
    }

    //metodo vuelve la primer letra de la cadena  mayuscula
    public static String Mayuscula(String cadena) {
        String nuevaCadena = "";
        char letra;
        for (int i = 0; i < cadena.length(); i++) {//concatenamos una nueva cadena con la primerletra mayuscula
            if (i == 0) {                          //separamos la primer letra 
                letra = cadena.charAt(i);
                nuevaCadena = "" + letra;
                nuevaCadena = nuevaCadena.toUpperCase();//con el metodo toUpperCase la volvemos mayuscula
            } else {
                nuevaCadena = nuevaCadena + cadena.charAt(i);
            }
        }
        return nuevaCadena;
    }

    //Insercion
    //Ascendentemente
    public static void insercionA(Estadio Estadios[], int cantEstadios) {

        for (int i = 1; i < cantEstadios; i++) {
            reubicarA(Estadios, i);
        }

    }

    public static void reubicarA(Estadio Estadios[], int i) {
        int j;
        Estadio auxEstadio = new Estadio(0);
        auxEstadio = Estadios[i];
        j = i - 1;
        while (j >= 0 && Estadios[j].CompareTo(auxEstadio) > 0) {
            Estadios[j + 1] = Estadios[j];
            j--;
        }
        Estadios[j + 1] = auxEstadio;
    }

    //Descendentemente
    public static void insercionD(Estadio Estadios[], int cantEstadios) {
        for (int i = 1; i < cantEstadios; i++) {
            reubicarD(Estadios, i);
        }
    }

    public static void reubicarD(Estadio Estadios[], int i) {
        int j;
        Estadio auxEstadio = new Estadio(0);
        auxEstadio = Estadios[i];
        j = i - 1;
        while (j >= 0 && Estadios[j].CompareTo(auxEstadio) < 0) {
            Estadios[j + 1] = Estadios[j];
            j--;
        }
        Estadios[j + 1] = auxEstadio;
    }

    //Quicksort
    // Ascendentemente
    public static void quicksortA(Estadio Estadios[], int izq, int der) {//
        Estadio pivoteEstadio = new Estadio(0);
        Estadio auxEstadio = new Estadio(0);
        pivoteEstadio = Estadios[izq];          //  tomamos primer elemento como pivote 
        int i = izq;                            //  i analiza de izquierda a derecha                                               
        int j = der;                            //  j analiza de derecha a izquierda                         

        while (i < j) {                         // mientras no se crucen las búsquedas                                   
            while (Estadios[i].CompareTo(pivoteEstadio) <= 0 && i < j) {
                i++;                            // busca elemento mayor que pivote
            }
            while (Estadios[j].CompareTo(pivoteEstadio) > 0) {
                j--;                            // busca elemento menor que pivote 
            }
            if (i < j) {                        //si las iteradores no se cruzan                                              
                auxEstadio = Estadios[i];       // intercambia elemtos          
                Estadios[i] = Estadios[j];
                Estadios[j] = auxEstadio;
            }
        }

        Estadios[izq] = Estadios[j];                   // se coloca el pivote de forma en donde los elementos                                    
        Estadios[j] = pivoteEstadio;                   // menores a su esten a su izquierda y los mayores a su derecha 
        //repetimos procesos con los subconjunto restantes
        if (izq < j - 1) {
            quicksortA(Estadios, izq, j - 1);          // ordenamos subarray izquierdo
        }

        if (j + 1 < der) {
            quicksortA(Estadios, j + 1, der);          // ordenamos subarray derecho
        }
    }

    //Descendentemente
    public static void quicksortD(Estadio Estadios[], int izq, int der) {
        Estadio pivoteEstadio = new Estadio(0);
        Estadio auxEstadio = new Estadio(0);
        pivoteEstadio = Estadios[izq];
        int i = izq;//HACER QUE SEA MEDIO
        int j = der;

        while (i < j) {
            while (Estadios[i].CompareTo(pivoteEstadio) >= 0 && i < j) {
                i++;
            }
            while (Estadios[j].CompareTo(pivoteEstadio) < 0) {
                j--;
            }
            if (i < j) {
                auxEstadio = Estadios[i];
                Estadios[i] = Estadios[j];
                Estadios[j] = auxEstadio;
            }
        }

        Estadios[izq] = Estadios[j];
        Estadios[j] = pivoteEstadio;

        if (izq < j - 1) {
            quicksortD(Estadios, izq, j - 1);
        }
        if (j + 1 < der) {
            quicksortD(Estadios, j + 1, der);
        }
    }

}
