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
    private String numero;
    private String nombre;
    private String ciudad;
    private String capacidad;
    private String mundial;

    //constructores
    public Estadio(String num) {
        this.numero = num;
        this.nombre = "";
        this.ciudad = "";
        this.capacidad = "";
        this.mundial = "";
    }

    public Estadio(String num, String nom, String ciu, String capa, String anioM) {
        this.numero = num;
        this.nombre = nom;
        this.ciudad = ciu;
        this.capacidad = capa;
        this.mundial = anioM;
    }

    //observadores
    public String getNumero() {
        return this.numero;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public String getCapacidad() {
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
    
    public void CompareTo(Estadio nuevoEstadio){
       
    }
    
    
    public boolean equals(Estadio nuevoEstadio){
        return this.numero==nuevoEstadio.numero;
    }
    
    //propias del tipo
}
