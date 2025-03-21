package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class WorkintechList<T extends Comparable<T>> extends ArrayList<T> {

    //WorkintechList<T> classı ArrayList<T>'yi extends ediyor. (ArrayList<T>'in tüm özelliklerini miras alıyor)
    //<T extends Comparable<T>>:  T, jenerik bir türdür (herhangi bir veri tipi olabilir).
    //T, Comparable<T> arayüzünü uygulamak zorundadır. Böylece elemanları sıralayabiliriz.

    //Tekrar edeni engellemek için method:
    @Override
    public boolean add(T element){
        if(!this.contains(element)) {
            return super.add(element); //ArrayList'in add() methodunu kullanıyoruz..
        }
        return false;
    }

    //Belirtilen konuma eklemek için method:
    @Override
    public void add(int index, T element){
        if(!this.contains(element)) {
            super.add(index, element);
        }
    }

    //Sıralama methodu:
    public void sort(){
        Collections.sort(this); //Collections.sort() Java’nın hazır bir metodudur ve içine verdiğimiz listeyi sıralar.
    }

    //Silip listeyi sıralama methodu:
    @Override
    public boolean remove(Object obj){
        boolean removed = super.remove(obj); //ArrayList'in remove() methodunu kullanıyoruz..
        if(removed) {
            sort();
        }
        return removed;
    }

}
