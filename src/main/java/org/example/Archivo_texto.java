package org.example;
import java.util.*;
import java.io.*;
public class Archivo_texto {
    // es esta hoja de trabajo cada número se escribira en una linea del archivo de texto.


    public Archivo_texto() {
    }

    /**
     * Metodo para leer archivos de texto, los convierte en listas de strings
     * @param nombreFichero nombre del archivo a leer
     * @return una lista de strig donde cada strig de la lista representa una linea del archivo de texto
     */
    public SingleLinkedList<Integer> leerArchivo(String nombreFichero){
        SingleLinkedList<Integer> lista = new SingleLinkedList<Integer>();
        // Declarar una variable BufferedReader
        BufferedReader br = null;
        try {
            // Crear un objeto BufferedReader al que se le pasa
            //   un objeto FileReader con el nombre del fichero
            br = new BufferedReader(new FileReader(nombreFichero));
            // Leer la primera línea, guardando en un String
            String texto = br.readLine();

            // Repetir mientras no se llegue al final del fichero
            while(texto != null) {
                // agregar la linea leida a la lista
                lista.InsertAtEnd(Integer.parseInt(texto));

                // Leer la siguiente línea
                texto = br.readLine();
            }

        }
        // Captura de excepción por fichero no encontrado
        catch (FileNotFoundException ex) {
            System.out.println("Error: Fichero no encontrado");
            ex.printStackTrace();
        }
        // Captura de cualquier otra excepción
        catch(Exception ex) {
            System.out.println("Error de lectura del fichero");
            ex.printStackTrace();
        }
        // Asegurar el cierre del fichero en cualquier caso
        finally {
            try {
                // Cerrar el fichero si se ha podido abrir
                if(br != null) {
                    br.close();
                }
            }
            catch (Exception ex) {
                System.out.println("Error al cerrar el fichero");
                ex.printStackTrace();
            }
        }
        return lista;
    }

    /**
     * Este metodo permite escribir una lista en un archivo .txt donde cada linea es una "casilla" de la lista
     * @param nombre es el nombre que tendra el archivo de texto
     * @param lista es la lista que se desea escribir en el archivo de texto
     */
    public void Escribir(String nombre, SingleLinkedList<Integer> lista){
        //Un texto cualquiera guardado en una variable

        try {
            //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            File archivo = new File(nombre);
            archivo.delete();

            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter escribir = new FileWriter(archivo, true);


            //Escribimos en el archivo con el metodo write
            for (int i = 0; i < lista.Count(); i++){
                escribir.write("" + lista.Get(i));
                escribir.write("\r\n");
            }



            //Cerramos la conexion
            escribir.close();
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir");
        }

    }





}
