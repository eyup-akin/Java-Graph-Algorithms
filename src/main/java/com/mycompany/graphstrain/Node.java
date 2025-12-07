/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.graphstrain;

/**
 *
 * @author Eyüp
 */
public class Node<T> {
    T value;
    Node<T> next;
    
    public Node(T val){
        this.value = val;
        this.next = null;
    }
}
