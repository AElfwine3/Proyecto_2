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
public class ListaCatedratico {

    NodoCatedratico cabeza;
    NodoCatedratico cola;
    int tamaño;

    public ListaCatedratico() {
        cabeza = null;
        cola = null;
        tamaño = 0;
    }

    public void addPrimero(String cui, String nombre, String correo, String contraseña) {
        NodoCatedratico nuevo = new NodoCatedratico(cui, nombre, correo, contraseña);
        if (cabeza == null) {
            nuevo.enlazarSiguiente(nuevo);
            cabeza = nuevo;
            cola = nuevo;
        } else {
            NodoCatedratico temp = cabeza;
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

    public void modificar(int index, String RefCui, String RefNombre, String RefCorreo, String RefContraseña) {
        NodoCatedratico temp = cabeza;
        NodoCatedratico modificado = new NodoCatedratico(RefCui, RefNombre, RefCorreo, RefContraseña);
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
                    NodoCatedratico siguiente = cabeza.obtenerSiguiente();
                    modificado.enlazarSiguiente(siguiente);
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
                    NodoCatedratico temp = cabeza;
                    while (temp.obtenerSiguiente() != cabeza) {
                        temp = temp.obtenerSiguiente();
                    }
                    cola = temp;
                    cabeza = cabeza.obtenerSiguiente();
                    cola.enlazarSiguiente(cabeza);
                }
            } else {
                int contador = 0;
                NodoCatedratico temporal = cabeza;
                while (contador < index - 1) {
                    temporal = temporal.obtenerSiguiente();
                    contador++;
                }
                temporal.enlazarSiguiente(temporal.obtenerSiguiente().obtenerSiguiente());
            }
            tamaño--;
        }
    }

    public String obtenerCuiL(int index) {
        int contador = 0;
        NodoCatedratico temporal = cabeza;
        while (contador < index) {
            temporal = temporal.obtenerSiguiente();
            contador++;
        }
        return temporal.obtenerCui();
    }

    public String obtenerNombreL(int index) {
        int contador = 0;
        NodoCatedratico temporal = cabeza;
        while (contador < index) {
            temporal = temporal.obtenerSiguiente();
            contador++;
        }
        return temporal.obtenerNombre();
    }

    public String obtenerCorreoL(int index) {
        int contador = 0;
        NodoCatedratico temporal = cabeza;
        while (contador < index) {
            temporal = temporal.obtenerSiguiente();
            contador++;
        }
        return temporal.obtenerCorreo();
    }

    public String obtenerContraseñaL(int index) {
        int contador = 0;
        NodoCatedratico temporal = cabeza;
        while (contador < index) {
            temporal = temporal.obtenerSiguiente();
            contador++;
        }
        return temporal.obtenerContraseña();
    }

    public boolean buscar(String RefCui) {
        boolean encontrado = false;
        NodoCatedratico temp = cabeza;
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

    public String buscarNombre(String RefCui) {
        NodoCatedratico temp = cabeza;
        if (!estaVacia()) {
            do {
                if (RefCui.equals(temp.obtenerCui())) {
                    break;
                } else {
                    temp = temp.obtenerSiguiente();
                }
            } while (temp != cabeza);
        } else {
            return "Sin Catedratico";
        }
        return temp.obtenerNombre();
    }

    public int tamaño() {
        return tamaño;
    }

    public boolean estaVacia() {
        return (cabeza == null);
    }

}
