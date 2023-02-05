package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Ordenar_lista orden = new Ordenar_lista();
        System.out.println("Ingrese el tamaño de la lista a generar aleatoriamente: ");
        int numero = Integer.parseInt(getNumber(in));
        //creacion de la lista vacia
        SingleLinkedList<Integer> lista = new SingleLinkedList<Integer>();
        // llenar la lista con numeros aleatorios para que esta este desordenada
        for (int i = 0 ; i< numero; i++ ){
            int a = (int) (Math.random() * 100);
            lista.InsertAtEnd(a);
        }
        // se guarda la lista desordenada en un archivo de texto para poder recuperarla desordenada luego de ordenarla
        String name = "Lista.txt";
        Archivo_texto archivo = new Archivo_texto();
        archivo.Escribir(name, lista);

        System.out.println("********************\n" +
                "*    Gnome sort    *\n" +
                "********************\n \n");
        System.out.println("Lista sin ordenar:");
        printList(lista);
        System.out.println("Presione cualquier tecla para iniciar el ordenamiento de la lista.");
        in.nextLine();
        System.out.println("Ordenando...");
        lista = orden.GnomeSort(lista);
        System.out.println("Lista ordenada:");
        printList(lista);
        System.out.println("Presione enter para continuar");
        in.nextLine();

        //cargamos la lista original desordenada
        lista = archivo.leerArchivo(name);

        //mismo proceso al anterior
        System.out.println("********************\n" +
                "*    Merge sort    *\n" +
                "********************\n \n");
        System.out.println("Lista sin ordenar:");
        printList(lista);
        System.out.println("Presione cualquier tecla para iniciar el ordenamiento de la lista.");
        in.nextLine();
        System.out.println("Ordenando...");
        lista = orden.MergeSort(lista);

        System.out.println("Lista ordenada:");
        printList(lista);
        System.out.println("Presione cualquier tecla para continuar");
        in.nextLine();

        //cargamos la lista original desordenada
        lista = archivo.leerArchivo(name);

        //mismo proceso al anterior
        System.out.println("********************\n" +
                "*    Quick sort    *\n" +
                "********************\n \n");
        System.out.println("Lista sin ordenar:");
        printList(lista);
        System.out.println("Presione cualquier tecla para iniciar el ordenamiento de la lista.");
        in.nextLine();
        System.out.println("Ordenando...");
        lista = orden.QuikSort(lista);

        System.out.println("Lista ordenada:");
        printList(lista);

        System.out.println("Presione cualquier tecla para continuar");
        in.nextLine();

        //cargamos la lista original desordenada
        lista = archivo.leerArchivo(name);

        //mismo proceso al anterior
        System.out.println("********************\n" +
                "*    Radix Sort    *\n" +
                "********************\n \n");
        System.out.println("Lista sin ordenar:");
        printList(lista);
        System.out.println("Presione cualquier tecla para iniciar el ordenamiento de la lista.");
        in.nextLine();
        System.out.println("Ordenando...");

        lista = orden.RadixSort(lista);

        System.out.println("Lista ordenada:");
        printList(lista);
        System.out.println("Presione cualquier tecla para continuar");
        in.nextLine();

        //cargamos la lista original desordenada
        lista = archivo.leerArchivo(name);

        //mismo proceso al anterior
        System.out.println("**************************\n" +
                "*      counting sort     *\n" +
                "**************************\n \n");
        System.out.println("Lista sin ordenar:");
        printList(lista);
        System.out.println("Presione Enter para iniciar el ordenamiento de la lista.");
        in.nextLine();
        System.out.println("Ordenando...");
        lista = orden.countsort(lista);

        System.out.println("Lista ordenada:");
        printList(lista);
        System.out.println("Presione Enter para continuar");
        in.nextLine();






    }

    /**
     * Este metodo imprime la lista que se le ingrese
     * @param lista es la lista a imprimir
     */
    public static void printList(SingleLinkedList<Integer> lista){
        for (int i= 0; i < lista.Count(); i++){
            System.out.println("[" + i  + "]: " + lista.Get(i));
        }
    }

    /**
     *
     * @param keyboard se ingresa el objeto que permite leer lo ingresado en la terminal
     * @return  un entero ingresado por el usuario
     */
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