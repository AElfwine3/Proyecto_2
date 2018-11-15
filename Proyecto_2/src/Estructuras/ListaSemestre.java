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
public class ListaSemestre {

    NodoSemestre cabeza, cola;
    int tamaño;

    public ListaSemestre() {
        cabeza = null;
        cola = null;
        tamaño = 0;
    }

    public void addPrimero(String nombre, int año, ListaCurso cursos) {
        NodoSemestre temp = cabeza;
        NodoSemestre nuevo = new NodoSemestre(nombre, año, cursos);
        if (cabeza == null) {
            cabeza = nuevo;
            //cola = nuevo;
        } else {
            nuevo.enlazarSiguiente(temp);
            temp.enlazarAnterior(nuevo);
            cabeza = nuevo;
        }
        tamaño++;
    }

    public void modificar(int index, String nombre, int año, ListaCurso cursos) {
        NodoSemestre temporal = cabeza;
        NodoSemestre modificado = new NodoSemestre(nombre, año, cursos);
        if (index == 0) {
            if (tamaño == 1) {
                cabeza = modificado;
            } else {
                modificado.enlazarSiguiente(temporal.obtenerSiguiente());
                temporal.siguiente.enlazarAnterior(modificado);
                cabeza = modificado;
            }
        } else {
            int contador = 0;
            if (index == tamaño - 1) {
                while (contador <= index - 1) {
                    temporal = temporal.obtenerSiguiente();
                    contador++;
                }
                NodoSemestre anterior = temporal.obtenerAnterior();
                anterior.enlazarSiguiente(modificado);
                modificado.enlazarAnterior(anterior);
            } else {
                while (contador <= index - 1) {
                    temporal = temporal.obtenerSiguiente();
                    contador++;
                }
                NodoSemestre anterior = temporal.obtenerAnterior();
                temporal = temporal.obtenerSiguiente();
                anterior.enlazarSiguiente(modificado);
                temporal.enlazarAnterior(modificado);
                modificado.enlazarAnterior(anterior);
                modificado.enlazarSiguiente(temporal);
            }
        }
    }

    public String obtenerNombreL(int index) {
        int contador = 0;
        NodoSemestre temporal = cabeza;
        while (contador < index) {
            temporal = temporal.obtenerSiguiente();
            contador++;
        }
        return temporal.obtenerNombre();
    }

    public int obtenerAñoL(int index) {
        int contador = 0;
        NodoSemestre temporal = cabeza;
        while (contador < index) {
            temporal = temporal.obtenerSiguiente();
            contador++;
        }
        return temporal.obtenerAño();
    }

    public ListaCurso obtenerCurso(int index) {
        int contador = 0;
        NodoSemestre temporal = cabeza;
        while (contador < index) {
            temporal = temporal.obtenerSiguiente();
            contador++;
        }
        return temporal.obtenerCurso();
    }

    public boolean buscar(String RefNombre) {
        boolean encontrado = false;
        NodoSemestre temp = cabeza;
        if (!estaVacia()) {
            do {
                if (RefNombre.equals(temp.obtenerNombre())) {
                    encontrado = true;
                    break;
                }
                temp = temp.obtenerSiguiente();
            } while (temp != null);
        }
        return encontrado;
    }
    
    public int obtenerIndice(String RefNombre) {
        NodoSemestre temp = cabeza;
        int contador = 0;
        while (!RefNombre.equals(temp.obtenerNombre())) {
            contador++;
            temp = temp.obtenerSiguiente();
        }
        return contador;
    }

    public void imprimir() {
        NodoSemestre temp = cabeza;
        while (temp != null) {
            System.out.println("Semestre: " + temp.obtenerNombre() + " " + temp.obtenerAño());
            temp.cursos.imprimir();
            temp = temp.obtenerSiguiente();
        }
    }

    /**
     *
     * @return
     */
    public int tamaño() {
        return tamaño;
    }

    public boolean estaVacia() {
        return (cabeza == null);
    }

}
