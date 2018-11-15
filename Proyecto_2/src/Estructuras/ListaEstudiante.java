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
public class ListaEstudiante {

    NodoEstudiante cola, cabeza;
    int tamaño;

    public ListaEstudiante() {
        cabeza = null;
        cola = null;
        tamaño = 0;
    }

    public void addPrimero(String carne, String cui, String nombre, String correo, String credito, String contraseña, ListaSemestre semestres) {
        NodoEstudiante nuevo = new NodoEstudiante(carne, cui, nombre, correo, credito, contraseña, semestres);
        if (cabeza == null) {
            nuevo.enlazarSiguiente(nuevo);
            nuevo.enlazarAnterior(nuevo);
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola = cabeza.obtenerAnterior();
            nuevo.enlazarSiguiente(cabeza);
            nuevo.enlazarAnterior(cola);
            cabeza.enlazarAnterior(nuevo);
            cola.enlazarSiguiente(nuevo);
            cabeza = nuevo;
            //NodoEstudiante temp = cabeza;
            //nuevo.enlazarSiguiente(temp);
            //temp.enlazarAnterior(nuevo);
            //cabeza = nuevo;
        }
        tamaño++;
    }

    public void modificar(int index, String RefCarne, String RefCui, String RefNombre, String RefCorreo, String RefCredito, String RefContraseña, ListaSemestre semestres) {
        NodoEstudiante temp = cabeza;
        NodoEstudiante modificado = new NodoEstudiante(RefCarne, RefCui, RefNombre, RefCorreo, RefCredito, RefContraseña, semestres);
        if (cabeza != null) {
            if (index == 0) {
                if (tamaño == 1) {
                    modificado.enlazarSiguiente(modificado);
                    modificado.enlazarAnterior(modificado);
                    cabeza = modificado;
                } else {
                    cola = cabeza.obtenerAnterior();
                    modificado.enlazarSiguiente(cabeza.obtenerSiguiente());
                    modificado.enlazarAnterior(cola);
                    cabeza.obtenerSiguiente().enlazarAnterior(modificado);
                    cola.enlazarSiguiente(modificado);
                    cabeza = modificado;
                }
            } else {
                int contador = 0;
                while (contador <= index - 1) {
                    temp = temp.obtenerSiguiente();
                    contador++;
                }
                NodoEstudiante anterior = temp.obtenerAnterior();
                temp = temp.obtenerSiguiente();
                anterior.enlazarSiguiente(modificado);
                temp.enlazarAnterior(modificado);
                modificado.enlazarAnterior(anterior);
                modificado.enlazarSiguiente(temp);
                //modificado.enlazarSiguiente(temp.obtenerSiguiente().obtenerSiguiente());
                //modificado.enlazarAnterior(temp);
                //temp.obtenerSiguiente().obtenerSiguiente().enlazarAnterior(modificado);
                //temp.enlazarSiguiente(modificado);
            }
        }
    }

    public void eliminar(int index) {
        //if (!estaVacia()) {
        if (index == 0) {
            if (tamaño == 1) {
                cabeza = null;
                cola = null;
            } else {
                cola = cabeza.obtenerAnterior();
                cabeza = cabeza.obtenerSiguiente();
                cola.enlazarSiguiente(cabeza);
                cabeza.enlazarAnterior(cola);
            }
        } else {
            int contador = 0;
            NodoEstudiante temporal = cabeza;
            while (contador <= index - 1) {
                temporal = temporal.obtenerSiguiente();
                contador++;
            }
            NodoEstudiante anterior = temporal.obtenerAnterior();
            temporal = temporal.obtenerSiguiente();
            anterior.enlazarSiguiente(temporal);
            temporal.enlazarAnterior(anterior);
            //temporal.enlazarSiguiente(temporal.obtenerSiguiente().obtenerSiguiente());
            //temporal.obtenerSiguiente().obtenerSiguiente().enlazarAnterior(temporal);
        }
        tamaño--;
        //}
    }

    public String obtenerCarneL(int index) {
        int contador = 0;
        NodoEstudiante temporal = cabeza;
        while (contador < index) {
            temporal = temporal.obtenerSiguiente();
            contador++;
        }
        return temporal.obtenerCarne();
    }

    public String obtenerCuiL(int index) {
        int contador = 0;
        NodoEstudiante temporal = cabeza;
        while (contador < index) {
            temporal = temporal.obtenerSiguiente();
            contador++;
        }
        return temporal.obtenerCui();
    }

    public String obtenerNombreL(int index) {
        int contador = 0;
        NodoEstudiante temporal = cabeza;
        while (contador < index) {
            temporal = temporal.obtenerSiguiente();
            contador++;
        }
        return temporal.obtenerNombre();
    }

    public String obtenerCorreoL(int index) {
        int contador = 0;
        NodoEstudiante temporal = cabeza;
        while (contador < index) {
            temporal = temporal.obtenerSiguiente();
            contador++;
        }
        return temporal.obtenerCorreo();
    }

    public String obtenerCreditoL(int index) {
        int contador = 0;
        NodoEstudiante temporal = cabeza;
        while (contador < index) {
            temporal = temporal.obtenerSiguiente();
            contador++;
        }
        return temporal.obtenerCredito();
    }

    public String obtenerContraseñaL(int index) {
        int contador = 0;
        NodoEstudiante temporal = cabeza;
        while (contador < index) {
            temporal = temporal.obtenerSiguiente();
            contador++;
        }
        return temporal.obtenerContraseña();
    }
    
    public ListaSemestre obtenerSemestreL(int index) {
        int contador = 0;
        NodoEstudiante temporal = cabeza;
        while (contador < index) {
            temporal = temporal.obtenerSiguiente();
            contador++;
        }
        return temporal.obtenerSemestre();
    }

    public boolean buscar(String RefCui) {
        boolean encontrado = false;
        NodoEstudiante temp = cabeza;
        if (!estaVacia()) {
            do {
                if (RefCui.equals(temp.obtenerCui())) {
                    encontrado = true;
                    break;
                }
                temp = temp.obtenerSiguiente();
            } while (temp != cabeza);
        }
        return encontrado;
    }

    public boolean buscarCarne(String RefCarne) {
        boolean encontrado = false;
        NodoEstudiante temp = cabeza;
        if (!estaVacia()) {
            do {
                if (RefCarne.equals(temp.obtenerCarne())) {
                    encontrado = true;
                    break;
                }
                temp = temp.obtenerSiguiente();
            } while (temp != cabeza);
        }
        return encontrado;
    }

    public String buscarCarneS(String RefCarne) {
        NodoEstudiante temp = cabeza;
        if (!estaVacia()) {
            do {
                if (RefCarne.equals(temp.obtenerCarne())) {
                    break;
                } else {
                    temp = temp.obtenerSiguiente();
                }
            } while (temp != cabeza);
        } else {
            return "Sin Nombre";
        }
        return temp.obtenerNombre();
    }

    public boolean buscarContraseña(String RefContraseña) {
        boolean encontrado = false;
        NodoEstudiante temp = cabeza;
        if (!estaVacia()) {
            do {
                if (RefContraseña.equals(temp.obtenerContraseña())) {
                    encontrado = true;
                    break;
                }
                temp = temp.obtenerSiguiente();
            } while (temp != cabeza);
        }
        return encontrado;
    }
    
    public int obtenerIndice(String RefCarne) {
        NodoEstudiante temp = cabeza;
        int contador = 0;
        while (!RefCarne.equals(temp.obtenerCarne())) {
            contador++;
            temp = temp.obtenerSiguiente();
        }
        return contador;
    }

    public void imprimir() {
        NodoEstudiante temp = cabeza;
        if (!estaVacia()) {
            do {
                System.out.println(temp.carne + " - " + temp.cui + " - " + temp.nombre + " - " + temp.correo + " - " + temp.credito + " - " + temp.contraseña);
                temp = temp.obtenerSiguiente();
            } while (temp != cabeza);
        }
    }

    public int tamaño() {
        return tamaño;
    }

    public boolean estaVacia() {
        return (cabeza == null);
    }

}
