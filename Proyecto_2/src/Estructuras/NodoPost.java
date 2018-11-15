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
public class NodoPost {
    int codigo;
    NodoPost siguiente;
    
    public NodoPost(int codigo){
        this.codigo = codigo;
        this.siguiente = null;
    }
    
    public int obtenerCodigo(){
        return codigo;
    }
    
    public void enlazarSiguiente(NodoPost n) {
        siguiente = n;
    }

    public NodoPost obtenerSiguiente() {
        return siguiente;
    }
}
