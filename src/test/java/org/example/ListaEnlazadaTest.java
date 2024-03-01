package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaEnlazadaTest {

    @Test
    public void testConstruirLista() {
        ListaEnlazada lista = new ListaEnlazada();
        ListaEnlazada.Nodo cabeza = lista.construirLista();
        assertNotNull(cabeza); // Verificar que la cabeza no sea nula
        assertNull(cabeza.siguiente); // Verificar que no haya más nodos
    }

    @Test
    public void testImprimirLista() {
        ListaEnlazada lista = new ListaEnlazada();
        ListaEnlazada.Nodo cabeza = new ListaEnlazada.Nodo(1);
        cabeza.siguiente = new ListaEnlazada.Nodo(2);
        cabeza.siguiente.siguiente = new ListaEnlazada.Nodo(3);
        lista.imprimirLista(cabeza);

    }

    @Test
    public void testOrdenarLista() {
        ListaEnlazada lista = new ListaEnlazada();
        ListaEnlazada.Nodo cabeza = new ListaEnlazada.Nodo(4);
        cabeza.siguiente = new ListaEnlazada.Nodo(2);
        cabeza.siguiente.siguiente = new ListaEnlazada.Nodo(1);
        cabeza.siguiente.siguiente.siguiente = new ListaEnlazada.Nodo(3);
        cabeza = lista.ordenarLista(cabeza);
        assertEquals(1, cabeza.valor); // Verificar el primer nodo
        assertEquals(2, cabeza.siguiente.valor); // Verificar el segundo nodo
        assertEquals(3, cabeza.siguiente.siguiente.valor); // Verificar el tercer nodo
        assertEquals(4, cabeza.siguiente.siguiente.siguiente.valor); // Verificar el cuarto nodo
        assertNull(cabeza.siguiente.siguiente.siguiente.siguiente); // Verificar que no haya más nodos
    }
}