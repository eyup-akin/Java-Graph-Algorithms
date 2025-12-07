/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.graphstrain;

/**
 *
 * @author Eyüp
 */
public class GraphsTrain {

    public static void main(String[] args) {
        Graph<Integer> graf = new Graph();
        graf.addVertex(1);
        graf.addVertex(2);
        graf.addVertex(3);
        graf.addVertex(4);
        graf.addVertex(5);

        graf.addEdge(1, 2);
        graf.addEdge(1, 3);
        graf.addEdge(2, 4);
        graf.addEdge(2, 5);
        graf.addEdge(3, 4);
        graf.addEdge(4, 5);

        graf.display();
        System.out.println("--------------");

        graf.breadthFirstSearch(1);
        System.out.println("--------------");

        graf.depthFirstSearch(1);
        System.out.println("--------------");

//        System.out.println(graf.outDegree(2));
//        System.out.println(graf.inDegree(2));
//        System.out.println(graf.isAdjacent(3,4));
//        System.out.println(graf.vertexCount());
//        int [][] arr = graf.adjacentMatrix();
//        int size = graf.vertexCount();
//        
//        System.out.println("Komsuluk Matrisi");
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                System.out.print(" " + arr[i][j]);
//            }
//            System.out.println("");
//        }
//        graf.display();
//        System.out.println(graf.findVertexWithZeroInDegree());
//        graf.topolocigalSorting();
    }

}
