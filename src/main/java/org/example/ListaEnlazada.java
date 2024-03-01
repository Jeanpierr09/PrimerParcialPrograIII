package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class ListaEnlazada {
    static class Nodo {
        int valor;              //Creamos la variable que almacena el valor contenido en el nodo
        Nodo siguiente;         // Variable que representa la referencia al siguiente nodo en la lista
        Nodo(int valor) {       //Aca tenemos el constructor
            this.valor = valor; //Y asignamos el valor proporcionado al nodo que se esta creando
        }
    }

    // Método para ordenar la lista enlazada en orden ascendente
    public Nodo ordenarLista(Nodo cabeza) {
        // Paso 1  Convertir la lista enlazada a un arreglo
        int longitud = 0;
        Nodo actual = cabeza;   //Este nodo se inicializa en la cabeza de la lista
        while (actual != null) {    //Con el ciclo while recorremos la lista  para encontrar la longitud, esta incrementa
            longitud++;             //y avanzamos al siguiente nodo
            actual = actual.siguiente;
        }

        int[] arreglo = new int[longitud]; //Almacenamos los valores de la lista
        actual = cabeza;                   //reiniciamos el nodo actual
        for (int i = 0; i < longitud; i++) { //Recorremos la lista para copiar los valores al arreglo
            arreglo[i] = actual.valor;      //Almacenamos el valor del nodo en el arreglo
            actual = actual.siguiente;      //pasamos al siguiente
        }

        // Paso 2: Ordenar el arreglo
        Arrays.sort(arreglo);  // Utiliza el método sort de la clase Arrays para ordenar el arreglo

        // Paso 3: Reconstruir la lista enlazada a partir del arreglo ordenado
        actual = cabeza;
        for (int i = 0; i < longitud; i++) {  //Recorremos la lista para actualizar valores con el arreglo ya ordenado
            actual.valor = arreglo[i];    //Actualizamos el valor del nodo con el del arreglo
            actual = actual.siguiente;
        }

        return cabeza; //devolvemos la cabeza de la lista ordenada
    }

    // Método para imprimir la lista enlazada
    public void imprimirLista(Nodo cabeza) {
        Nodo actual = cabeza;   //inicializamos el nodo actual en la cabeza
        while (actual != null) {  //Miramos que el nodo tenga un valor para seguir
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    // Método para construir la lista enlazada a partir de los datos ingresados por el usuario
    public Nodo construirLista() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese los números separados por espacios: ");
        String[] valores = scanner.nextLine().split(" "); // Leer la línea de entrada del usuario y dividirla en una matriz de cadenas utilizando espacios como delimitador

        Nodo cabeza = null;  // Inicializar la cabeza de la lista como nula
        Nodo actual = null;  // Inicializar el nodo actual como nulo
        for (String valor : valores) {  // Iterar sobre cada valor en la matriz de cadenas
            int num = Integer.parseInt(valor);  // Convertir el valor de cadena a entero
            Nodo nuevoNodo = new Nodo(num);  // Crear un nuevo nodo con el valor entero
            if (cabeza == null) {  // Si la cabeza es nula, significa que es el primer nodo de la lista
                cabeza = nuevoNodo;  // Asignar el nuevo nodo como la cabeza de la lista
                actual = nuevoNodo;  // Actualizar el nodo actual al nuevo nodo
            } else {  // Si la cabeza no es nula, significa que ya hay nodos en la lista
                actual.siguiente = nuevoNodo;  // Asignar el nuevo nodo como el siguiente nodo del nodo actual
                actual = actual.siguiente;  // Actualizar el nodo actual al siguiente nodo
            }
        }
        return cabeza;  // Devolver la cabeza de la lista construida
    }

    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();  // Crear una instancia de la clase ListaEnlazada

        // Construir la lista enlazada a partir de los datos ingresados por el usuario
        Nodo cabeza = lista.construirLista();

        // Imprimir la lista original
        System.out.println("Lista original:");
        lista.imprimirLista(cabeza);

        // Ordenar la lista enlazada
        cabeza = lista.ordenarLista(cabeza);

        // Imprimir la lista ordenada
        System.out.println("Lista ordenada:");
        lista.imprimirLista(cabeza);
    }
}
