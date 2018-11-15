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
public class ListaPre {
    
    NodoPre cabeza;
    int tamaño;
    
    public ListaPre(){
        cabeza = null;
        tamaño = 0;
    }
    
    public void addPrimero(int codigo) {
        if (cabeza == null) {
            cabeza = new NodoPre(codigo);
        } else {
            NodoPre temp = cabeza;
            NodoPre nuevo = new NodoPre(codigo);
            nuevo.enlazarSiguiente(temp);
            cabeza = nuevo;
        }
        tamaño++;
    }
    
    public int obtener(int index) {
        int contador = 0;
        NodoPre temporal = cabeza;
        while (contador < index) {
            temporal = temporal.obtenerSiguiente();
            contador++;
        }
        return temporal.obtenerCodigo();
    }
    
    public void imprimir() {
        NodoPre temp = cabeza;
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
