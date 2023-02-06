package org.example;

public class Ordenar_lista {

    /**
     * constructor
     */
    public Ordenar_lista() {
    }

    /**
     * ordena
     * @param lista lista a ordenar
     * @return lista, la lista ordenada
     */
    public SingleLinkedList<Integer> RadixSort(SingleLinkedList<Integer> lista){
        int n = lista.Count();
        int[] L = new int[n];
        for (int k = 0; k < n; k++){
            L[k] = lista.Get(k);
        }
        radixSort(L);
        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        for (int k = 0; k < n; k++){
            list.InsertAtEnd(L[k]);
        }
        return list;

    }

    /**
     * ordena una lista
     * @param arr lista a ordenar
     */
    private static void radixSort(int[] arr) {
        int[][] bucket = new int[10][arr.length];
        int[] bucketOfElement = new int[10];
        int max=0;
        // Encuentra el elemento más grande en la matriz
        for(int i = 0 ; i < arr.length;i++) {
            if(arr[i]>max){
                max = arr[i];
            }
        }
        // Calcula el número de bits del elemento más grande
        int maxLength = (max+"").length();
        for(int m = 0,n=1;m<maxLength;m++,n*=10) {
            // Coloca los números en arr en los cubos correspondientes según sus unidades, decenas, centenas, etc.
            for(int i = 0 ; i < arr.length;i++) {
                int digit = arr[i]/n%10;
                // Asignar el valor de arr [i] a la matriz bidimensional en el depósito
                bucket[digit][bucketOfElement[digit]] = arr[i];
                bucketOfElement[digit]++;
            }
            int index = 0;
            // Leer los elementos en el depósito y reasignarlos a arr
            for(int j = 0;j<10;j++) {
                for(int k = 0 ; k<bucketOfElement[j];k++) {
                    arr[index] = bucket[j][k];
                    index++;
                }
                bucketOfElement[j]=0;// Borrar el número de elementos en cada uno
            }
        }
    }

    /**
     * ordena lista
     * @param lista lista a ordenar
     * @return lita ordenada
     */
    public SingleLinkedList<Integer> GnomeSort(SingleLinkedList<Integer> lista){
        int i = 0;
        int n = lista.Count();
        int[] L = new int[n];
        for (int k = 0; k < n; k++){
            L[k] = lista.Get(k);
        }
        while (i < n) {
            if (i == 0 || L[i] >= L[i-1]) {
                i++;
            } else {
                int temp = 0;
                temp = L[i];
                L[i] = L[i-1];
                L[i-1] = temp;
                i--;
            }
        }
        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        for (int k = 0; k < n; k++){
            list.InsertAtEnd(L[k]);
        }
        return list;
    }

    /**
     * ordena una lista
     * @param lista , lista a ordenar
     * @return lista ordenada
     */
    public SingleLinkedList<Integer> QuikSort(SingleLinkedList<Integer> lista) {
    int n = lista.Count();
    int[] L = new int[n];
    for (int i= 0; i < n; i++){
        L[i] = lista.Get(i);
    }
    quickSort(L,0, n-1);
    SingleLinkedList<Integer> Lord = new SingleLinkedList<Integer>();
    for (int i= 0; i < n; i++){
        Lord.InsertAtEnd(L[i]);
    }
    return Lord;
}

    /**
     *
     * @param myArray lista a ordenar
     * @param inf valor
     * @param sup valor
     */
    private void quickSort(int[] myArray, int inf, int sup) {
        int i = inf - 1;
        int j = sup;
        boolean flag = true;
        int temp;


        if (inf >= sup) {
            return;
        }

         int elem_div = myArray[sup];


        while (flag) {
            while( myArray[++i] < elem_div); //Move the index i until it finds an element bigger than elem_div
            while( (myArray[--j] > elem_div)  && (j > inf)); //Move the index j until it finds element smaller than elem_div

            if (i < j) {
                temp = myArray[i];
                myArray[i] = myArray[j];
                myArray[j] = temp;
            } else {
                flag = false;
            }
        }

        temp = myArray[i];
        myArray[i] = myArray[sup];
        myArray[sup] = temp;
        quickSort(myArray, inf, i - 1);
        quickSort(myArray, i + 1, sup);
    }


    /**
     * ordena una lista
     * @param lista lista a ordenar
     * @return lista ordenada
     */
  public SingleLinkedList<Integer> countsort(SingleLinkedList<Integer> lista){
        int max = 0;
        for (int i = 0; i < lista.Count(); i++){
            if (lista.Get(i)> max)
                max = lista.Get(i);
        }
        max++;
        int[] listaConteo = new int[max]; // un arreglo

        for (int i = 0; i < lista.Count(); i++){
            int j = lista.Get(i);
          listaConteo[j] = 1 + listaConteo[j];
        }
        SingleLinkedList<Integer> lista_orden = new SingleLinkedList<Integer>();
        for (int i = 0; i < listaConteo.length;i++){

          for (int j = 0; j < listaConteo[i]; j++ ){
              lista_orden.InsertAtEnd(i);
          }

        }
        return  lista_orden;
  }

    /**
     * ordena lista
     * @param lista lista a ordenar
     * @return lista ordenada
     */
    public SingleLinkedList<Integer> MergeSort(SingleLinkedList<Integer> lista) {
        if (lista.Count() <= 1)
            return lista;
        else{
            SingleLinkedList<SingleLinkedList<Integer>> L = corte(lista);
            return fusion(MergeSort(L.Get(0)),MergeSort(L.Get(1)));
        }
    }

    /**
     * fusiona  listas de manera especial para ordenarlas
     * @param A lista 1
     * @param B lista 2
     * @return lista fusionada
     */
    private SingleLinkedList<Integer>  fusion(SingleLinkedList<Integer> A, SingleLinkedList<Integer> B) {
        if (A.IsEmpty())
            return B;
        if (B.IsEmpty())
            return A;
        if (A.Get(0) <= B.Get(0)) {
            int a = A.Get(0);
            A.DeleteAtStart();
            SingleLinkedList<Integer> L1 = fusion(A,B);
            L1.InsertAtStart(a);
            return L1;
        }
        else{
            int b = B.Get(0);
            B.DeleteAtStart();
            SingleLinkedList<Integer> L2 = fusion(A,B);
            L2.InsertAtStart(b);
            return L2;
        }
    }

    /**
     * divide una lista en 2 partes casi iguales
     * @param lista lista a dividir
     * @return lista de 2 listas que conforman la original dividida
     */
    private SingleLinkedList<SingleLinkedList<Integer>> corte(SingleLinkedList<Integer> lista) {
        int n = lista.Count();
        SingleLinkedList<Integer> A = new SingleLinkedList<Integer>();
        SingleLinkedList<Integer> B = new SingleLinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (i < (n / 2))
                A.InsertAtEnd(lista.Get(i));
            else {
                B.InsertAtEnd(lista.Get(i));
            }
        }
        SingleLinkedList<SingleLinkedList<Integer>> L = new SingleLinkedList<SingleLinkedList<Integer>>();
        L.InsertAtEnd(A);
        L.InsertAtEnd(B);
        return L;
    }

}



