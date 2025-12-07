/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.graphstrain;

/**
 *
 * @author Eyüp
 */
public class Vertex<T extends Comparable> {
    T id;
    Vertex<T> nextVertex;
    Edge<T> edgeLink;
    boolean visited = false;
    
    
    public Vertex(T id){
        this.id = id;
        this.edgeLink = null;
        this.nextVertex = null;
    }
    
    @Override
    public String toString(){
        return String.valueOf(this.id);
    }
    
}
