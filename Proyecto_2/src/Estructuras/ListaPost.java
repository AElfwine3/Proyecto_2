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
public class ListaPost {
    
    NodoPost cabeza;
    int tamaño;
    
    public ListaPost(){
        cabeza = null;
        tamaño = 0;
    }
    
    public void addPrimero(int codigo) {
        if (cabeza == null) {
            cabeza = new NodoPost(codigo);
        } else {
            NodoPost temp = cabeza;
            NodoPost nuevo = new NodoPost(codigo);
            nuevo.enlazarSiguiente(temp);
            cabeza = nuevo;
        }
        tamaño++;
    }
    
    public int obtener(int index) {
        int contador = 0;
        NodoPost temporal = cabeza;
        while (contador < index) {
            temporal = temporal.obtenerSiguiente();
            contador++;
        }
        return temporal.obtenerCodigo();
    }
    
    public void imprimir() {
        NodoPost temp = cabeza;
        if (!estaVacia()) {
            while (temp != null){
                System.out.print(temp.codigo + ", ");
                temp = temp.obtenerSiguiente();
            }
        }
    }
    
    public int tamaño() {
        return tamaño;
    }

    public boolean estaVacia() {
        return (cabeza == null) ? true : false;
    }
    
}
