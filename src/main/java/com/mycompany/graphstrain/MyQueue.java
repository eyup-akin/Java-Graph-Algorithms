/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.graphstrain;

/**
 *
 * @author Eyüp
 */
public class MyQueue<T> {
    private Node<T> front;
    private Node<T> rear;
    int size;
    
    public MyQueue(){
        this.front = null;
        this.rear = null;
    }
    
    //kuyruk boş olup olmadığını kontrol eden metod
    public boolean isEmpty(){
        return this.front == null;
    }
    
    
    //kuyruğun sonuna ekleme yapan metod
    public void enQueue(T val){
        size++;
        Node<T> newNode = new Node(val);
        
        //kuyruk tamamen boşsa
        if (isEmpty()) {
            this.front = newNode;
            this.rear = newNode;
            return;
        }
        
        //kuyruk boş değğilse sona ekle
        //reari güncelle
        
        this.rear.next = newNode;
        this.rear = newNode;
    }
    
    //kuyruğun başından çıkarma yapan metod
    public T deQueue(){
        //kuyruk boşsa
        if (isEmpty()) {
            return null;
        }
        
        T temp = this.front.value;
        this.front = this.front.next;
        
        if (front == null) {
            this.rear = null;
        }
        
        size--;
        return temp;
    }
    
    
    //kuyruğun eleman sayısını döndürür
    public int getSize(){
        return size;
    }
    
    
}
