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
public class NodoPre {
    
    int codigo;
    NodoPre siguiente;
    
    public NodoPre(int codigo){
        this.codigo = codigo;
        this.siguiente = null;
    }
    
    public int obtenerCodigo(){
        return codigo;
    }
    
    public void enlazarSiguiente(NodoPre n) {
        siguiente = n;
    }

    public NodoPre obtenerSiguiente() {
        return siguiente;
    }
    
}
