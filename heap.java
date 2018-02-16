package com.company;

import java.util.*;

public class heap {
    int size;
    node arr[];
    int in;
    public heap(int n){
        size = n;
        arr = new node[n];
        in = 1;
    }
    public void add(node n){
        arr[in] = n;
        swim(in);
        in++;
    }
    private void swim(int i){
        if(i <= 1) return;
        if(arr[i].getCount() < arr[i/2].getCount()){
            swap(i, i/2);
            swim(i/2);
        }
    }
    private void swap(int i, int j){
        node temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public node getMin(){
        node temp = arr[1];
        in--;
        swap(1, in);
        sink(1);
        return temp;
    }
    private void sink(int i){
        if(2*i >= in) return;
        node n = arr[i]; int it = i;
        if(n.getCount() > arr[2*i].getCount())
            it = 2*i;
        if(2*i + 1 < in && n.getCount() > arr[2*i + 1].getCount() && arr[2*i].getCount() > arr[2*i + 1].getCount())
            it = 2*i + 1;
        if(it != i){
            swap(i, it);
            sink(it);
        }
    }
    public void print(){
        int i;
        for(i = 1; i < in; i++)
            System.out.print(arr[i].count+" "+arr[i].c+"  ");
    }
    public node convertTo(){
        node node1, node2, node3 = null;
        while(in > 2) {
            node1 = getMin();
            node2 = getMin();
            node3 = new node(node1, node2);
            add(node3);
        }
        return arr[1];
    }

}
