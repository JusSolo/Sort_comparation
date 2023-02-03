package org.example;

public class Ordenar_lista {
    public Ordenar_lista() {
    }

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

    public SingleLinkedList<Integer> MergeSort(SingleLinkedList<Integer> lista) {
        if (lista.Count() <= 1)
            return lista;
        else{
            SingleLinkedList<SingleLinkedList<Integer>> L = corte(lista);
            return fusion(MergeSort(L.Get(0)),MergeSort(L.Get(1)));
        }
    }

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



