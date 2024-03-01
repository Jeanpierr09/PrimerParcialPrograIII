package org.example;

import java.util.Scanner;

public class Matriz {

    public static void main(String[] args) {
        int matriz[][] = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la posicion de la fila (0,2)");
        int fila = scanner.nextInt();
        System.out.println("Ingrese la posicion de la columna (de 0 a 2)");
        int columna = scanner.nextInt();

        System.out.println("Se determino ver las posiciones adyacentes de: fila: " + fila + " Columna: " + columna);

        //Elemento de la izquierda
        if(columna > 0){
            System.out.println("Posicion adyacente de la izquierda ( fila: " + fila +  " Columna: " + (columna-1) + ")");
        }

        //Elemento de la derecha
        if(columna < 2){
            System.out.println("Posicion adyacente de la derecha ( fila: " + fila +  " Columna: " + (columna+1) + ")");
        }

        //Elemento de arriba
        if(fila > 0){
            System.out.println("Posicion adyacente de la arriba ( fila: " + (fila-1) +  " Columna: " + columna + ")");
        }
        //Elemento de abajo
        if(fila < 2){
            System.out.println("Posicion adyacente de la izquierda ( fila: " + (fila+1) +  " Columna: " + columna + ")");
        }

    }
}
