/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.graphstrain;

/**
 *
 * @author Eyüp
 */
public class MyStack<T> {
    private Node<T> top;
    private int size;
    
    public MyStack(){
        this.size = 0;
        this.top = null;
    }
    
    //stack boş mu diye kontrol eder
    public boolean isEmpty(){
        return this.top == null;
    }
    
    //ekleme islemi
    public void push(T val){
        Node<T> newNode = new Node(val);
        newNode.next = top;
        top = newNode;
        size++;
    }
    
    //stackten eleman çıkarma
    public T pop(){
        if (isEmpty()) {
            return null;
        }
        
        T temp = top.value;
        size--;
        top = top.next;
        return temp;
    }
    
    //stacktaki elemanların sayısını döndürür
    public int getSize(){
        return size;
    }
    
}
