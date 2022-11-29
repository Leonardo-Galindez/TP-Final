/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clase;

/**
 *
 * @author galin
 */
public class Estadio {

    //Atributos
    private int numero;
    private String nombre;
    private String ciudad;
    private int capacidad;
    private String mundial;

    //constructores
    public Estadio(int num) {
        this.numero = num;
        this.nombre = "";
        this.ciudad = "";
        this.capacidad = 0;
        this.mundial = "";
    }

    public Estadio(int num, String nom, String ciu, int capa, String anioM) {
        this.numero = num;
        this.nombre = nom;
        this.ciudad = ciu;
        this.capacidad = capa;
        this.mundial = anioM;
    }

    //observadores
    public int getNumero() {
        return this.numero;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public String getMudial() {
        return this.mundial;
    }

    //modificadores
    public void setNombre(String nom) {
        this.nombre = nom;
    }

    public void setCiudad(String ciu) {
        this.ciudad = ciu;
    }

    public void setCapacidad(String nom) {
        this.nombre = nom;
    }

    public void setMundial(String nom) {
        this.nombre = nom;
    }

    //mostradores
    public String toString() {
        return "Numero: " + numero
                + " \nNombre:" + nombre
                + " \nCiudad:" + ciudad
                + " \nCapacidad:" + capacidad
                + " \nMundial:" + mundial;
    }
    //retorna
    //positivo si la ciudad del estadio llamador es mayor al que entra por parametros
    //negativo si la ciudad del estadio llamador es menor al que entra por parametros
    //positivo si son iguales
    public int CompareTo(Estadio nuevoEstadio) {
        
        int num;

        if (this.ciudad.compareTo(nuevoEstadio.ciudad) == 0) {
            //si la ciudad es igual realiza la comparacion mediante el nombre del estadio
            num = this.nombre.compareTo(nuevoEstadio.nombre);
        } else {
            num = this.ciudad.compareTo(nuevoEstadio.ciudad);
        }

        return num;
    }

    public boolean equals(Estadio nuevoEstadio) {
        return this.numero == nuevoEstadio.numero;
    }

    //propias del tipo
}
