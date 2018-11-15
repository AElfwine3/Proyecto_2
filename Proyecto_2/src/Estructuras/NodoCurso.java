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
public class NodoCurso {
    
    String codigo, nombre, cui, credito, seccion;
    ListaPre pre;
    ListaPost post;
    NodoCurso siguiente;

    public NodoCurso(String codigo, String nombre, String cui, String credito, String seccion, ListaPre pre, ListaPost post) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cui = cui;
        this.credito = credito;
        this.seccion = seccion;
        this.pre = pre;
        this.post = post;
        this.siguiente = null;
    }

    public String obtenerCodigo() {
        return codigo;
    }

    public String obtenerNombre() {
        return nombre;
    }
    
    public String obtenerCui() {
        return cui;
    }

    public String obtenerCredito() {
        return credito;
    }

    public String obtenerSeccion() {
        return seccion;
    }
    
    public ListaPre obtenerPre(){
        return pre;
    }
    
    public ListaPost obtenerPost(){
        return post;
    }

    public void enlazarSiguiente(NodoCurso n) {
        siguiente = n;
    }

    public NodoCurso obtenerSiguiente() {
        return siguiente;
    }
    
}
