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
public class NodoCatedratico {
    String cui, nombre, correo, contraseña;
    NodoCatedratico siguiente;

    public NodoCatedratico(String cui, String nombre, String correo, String contraseña) {
        this.cui = cui;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.siguiente = null;
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

    public String obtenerContraseña() {
        return contraseña;
    }

    public void enlazarSiguiente(NodoCatedratico n) {
        siguiente = n;
    }

    public NodoCatedratico obtenerSiguiente() {
        return siguiente;
    }

}
