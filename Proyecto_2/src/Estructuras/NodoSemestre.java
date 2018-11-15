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
public class NodoSemestre {

    String nombre;
    int año;
    ListaCurso cursos;
    NodoSemestre siguiente, anterior;

    public NodoSemestre(String nombre, int año, ListaCurso cursos) {
        this.nombre = nombre;
        this.año = año;
        this.cursos = cursos;
        this.anterior = null;
        this.siguiente = null;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public int obtenerAño() {
        return año;
    }
    
    public ListaCurso obtenerCurso() {
        return cursos;
    }

    public void enlazarAnterior(NodoSemestre n) {
        anterior = n;
    }

    public NodoSemestre obtenerAnterior() {
        return anterior;
    }

    public void enlazarSiguiente(NodoSemestre n) {
        siguiente = n;
    }

    public NodoSemestre obtenerSiguiente() {
        return siguiente;
    }

}
