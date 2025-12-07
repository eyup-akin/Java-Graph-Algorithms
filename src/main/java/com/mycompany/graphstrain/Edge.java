/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.graphstrain;

/**
 *
 * @author Eyüp
 */
public class Edge<T extends Comparable> {
    T vertexId;
    Edge<T> nextEdge;
    
    public Edge(T id){
        this.vertexId = id;
        this.nextEdge = null;
    }
    
    @Override
    public String toString(){
        return String.valueOf(this.vertexId);
    }
    
}
