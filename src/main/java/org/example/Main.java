package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el tamaño de la lista a generar aleatoriamente: ");
        int numero = Integer.parseInt(getNumber(in));
        SingleLinkedList<Integer> lista = new SingleLinkedList<Integer>();
        for (int i = 0 ; i< numero; i++ ){
            lista.Insert(i, (int) (Math.random() * 1000));
        }
        String name = "Lista.txt";
        Archivo_texto archivo = new Archivo_texto();
        archivo.Escribir(name, lista);






    }

    public static String getNumber(Scanner keyboard) {
        String number = keyboard.nextLine(); // Obtiene el input
        boolean isNumber = false;

        while (!isNumber) { // Vuelve a pedir input hasta que este sea un número
            try {
                int nm = Integer.parseInt(number); // Verifica que el input sea un número
                isNumber = true;
            } catch (NumberFormatException nft) {
                System.out.println("ERROR. Verifique que el valor ingresado sea numérico e intente de nuevo.");
                number = keyboard.nextLine();
            }
        }

        return number;
    }
}