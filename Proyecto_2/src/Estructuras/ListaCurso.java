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
public class ListaCurso {
    
    NodoCurso cabeza, cola;
    int tamaño;
    
    public ListaCurso(){
        cabeza = null;
        cola = null;
        tamaño = 0;
    }
    
    public void addPrimero(String codigo, String nombre, String cui, String credito, String seccion, ListaPre pre, ListaPost post) {
        NodoCurso nuevo = new NodoCurso(codigo, nombre, cui, credito, seccion, pre, post);
        if (cabeza == null) {
            nuevo.enlazarSiguiente(nuevo);
            cabeza = nuevo;
            cola = nuevo;
        } else {
            NodoCurso temp = cabeza;
            nuevo.enlazarSiguiente(temp);
            while (temp.obtenerSiguiente() != cabeza) {
                temp = temp.obtenerSiguiente();
            }
            cola = temp;
            cola.enlazarSiguiente(nuevo);
            cabeza = nuevo;
        }
        tamaño++;
    }
    
    public void modificar(int index, String RefCodigo, String RefNombre, String RefCui, String RefCredito, String RefSeccion, ListaPre RefPre, ListaPost RefPost) {
        NodoCurso temp = cabeza;
        NodoCurso modificado = new NodoCurso(RefCodigo, RefNombre, RefCui, RefCredito, RefSeccion, RefPre, RefPost);
        if (cabeza != null) {
            if (index == 0) {
                if (tamaño == 1) {
                    modificado.enlazarSiguiente(modificado);
                    cabeza = modificado;
                    cola = modificado;
                } else {
                    while (temp.obtenerSiguiente() != cabeza) {
                        temp = temp.obtenerSiguiente();
                    }
                    cola = temp;
                    modificado.enlazarSiguiente(cabeza.obtenerSiguiente());
                    cola.enlazarSiguiente(modificado);
                    cabeza = modificado;
                }
            } else {
                int contador = 0;
                while (contador < index - 1) {
                    temp = temp.obtenerSiguiente();
                    contador++;
                }
                modificado.enlazarSiguiente(temp.obtenerSiguiente().obtenerSiguiente());
                temp.enlazarSiguiente(modificado);
            }
        }
    }
    
    public void eliminar(int index) {
        if (!estaVacia()) {
            if (index == 0) {
                if (tamaño == 1) {
                    cabeza = null;
                } else {
                    NodoCurso temp = cabeza;
                    while (temp.obtenerSiguiente() != cabeza) {
                        temp = temp.obtenerSiguiente();
                    }
                    cola = temp;
                    cabeza = cabeza.obtenerSiguiente();
                    cola.enlazarSiguiente(cabeza);
                }
            } else {
                int contador = 0;
                NodoCurso temporal = cabeza;
                while (contador < index - 1) {
                    temporal = temporal.obtenerSiguiente();
                    contador++;
                }
                temporal.enlazarSiguiente(temporal.obtenerSiguiente().obtenerSiguiente());
            }
            tamaño--;
        }
    }
    
    public String obtenerCodigoL(int index) {
        int contador = 0;
        NodoCurso temporal = cabeza;
        while (contador < index) {
            temporal = temporal.obtenerSiguiente();
            contador++;
        }
        return temporal.obtenerCodigo();
    }
    
    public String obtenerNombreL(int index) {
        int contador = 0;
        NodoCurso temporal = cabeza;
        while (contador < index) {
            temporal = temporal.obtenerSiguiente();
            contador++;
        }
        return temporal.obtenerNombre();
    }
    
    public String obtenerCuiL(int index) {
        int contador = 0;
        NodoCurso temporal = cabeza;
        while (contador < index) {
            temporal = temporal.obtenerSiguiente();
            contador++;
        }
        return temporal.obtenerCui();
    }
    
    public String obtenerCreditoL(int index) {
        int contador = 0;
        NodoCurso temporal = cabeza;
        while (contador < index) {
            temporal = temporal.obtenerSiguiente();
            contador++;
        }
        return temporal.obtenerCredito();
    }
    
    public String obtenerSeccionL(int index) {
        int contador = 0;
        NodoCurso temporal = cabeza;
        while (contador < index) {
            temporal = temporal.obtenerSiguiente();
            contador++;
        }
        return temporal.obtenerSeccion();
    }
    
    public ListaPre obtenerPreL(int index) {
        int contador = 0;
        NodoCurso temporal = cabeza;
        while (contador < index) {
            temporal = temporal.obtenerSiguiente();
            contador++;
        }
        return temporal.obtenerPre();
    }
    
    public ListaPost obtenerPostL(int index) {
        int contador = 0;
        NodoCurso temporal = cabeza;
        while (contador < index) {
            temporal = temporal.obtenerSiguiente();
            contador++;
        }
        return temporal.obtenerPost();
    }
    
    public void imprimir() {
        NodoCurso temp = cabeza;
        if (!estaVacia()) {
            do {
                System.out.print(temp.codigo + " - " + temp.nombre + " - " + temp.cui + " - " + temp.credito + " - " + temp.seccion + " - ");
                temp.pre.imprimir();
                System.out.print(" - ");
                temp.post.imprimir();
                System.out.println("");
                temp = temp.obtenerSiguiente();
            } while (temp != cabeza);
        }
    }
    
    public int tamaño() {
        return tamaño;
    }

    public boolean estaVacia() {
        return (cabeza == null) ? true : false;
    }
    
}
