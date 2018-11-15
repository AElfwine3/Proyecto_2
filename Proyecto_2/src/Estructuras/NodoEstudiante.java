/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author Ushi
 */
public class NodoEstudiante {

    String carne, cui, nombre, correo, credito, contraseña;
    ListaSemestre semestres;
    NodoEstudiante siguiente, anterior;

    public NodoEstudiante(String carne, String cui, String nombre, String correo, String credito, String contraseña, ListaSemestre semestres) {
        this.carne = carne;
        this.cui = cui;
        this.nombre = nombre;
        this.correo = correo;
        this.credito = credito;
        this.contraseña = contraseña;
        this.semestres = semestres;
        this.siguiente = null;
        this.anterior = null;
    }

    public String obtenerCarne() {
        return carne;
    }

    public String obtenerCui() {
        return cui;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerCorreo() {
        return correo;
    }

    public String obtenerCredito() {
        return credito;
    }

    public String obtenerContraseña() {
        return contraseña;
    }
    
    public ListaSemestre obtenerSemestre() {
        return semestres;
    }

    public void enlazarSiguiente(NodoEstudiante n) {
        siguiente = n;
    }

    public void enlazarAnterior(NodoEstudiante n) {
        anterior = n;
    }

    public NodoEstudiante obtenerSiguiente() {
        return siguiente;
    }

    public NodoEstudiante obtenerAnterior() {
        return anterior;
    }

}
