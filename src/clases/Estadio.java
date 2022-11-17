/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

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

    //
    public String toString() {
        return "Numero: " + numero 
                + " \nNombre:" + nombre
                + " \nCiudad:" + ciudad
                + " \nCapacidad:" + capacidad
                + " \nMundial:" + mundial;
    }
    
    public int CompareTo(Estadio nuevoEstadio){
        return this.numero-nuevoEstadio.numero;
    }
    
    public boolean equals(Estadio nuevoEstadio){
        return this.numero==nuevoEstadio.numero;
    }
    
    //propias del tipo
}
