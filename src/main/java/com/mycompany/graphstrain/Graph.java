/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.graphstrain;

/**
 *
 * @author Eyüp
 */
public class Graph<T extends Comparable> {

    private Vertex<T> head;

    //veri yapısına yeni verex ekleyen metod
    public void addVertex(T id) {
        Vertex<T> newVertex = new Vertex(id);
        //head null sa yani lste boşsa
        if (head == null) {
            head = newVertex;
        } else {//değilse
            Vertex<T> iterator = head;
            //sona kadar ilerle
            while (iterator.nextVertex != null) {
                iterator = iterator.nextVertex;
            }
            iterator.nextVertex = newVertex;

        }

    }

    //verilen id değerindeki vertexi döndüren metod
    public Vertex<T> findVertex(T id) {
        Vertex<T> iterator = head;
        while (iterator != null) {
            if (iterator.id.compareTo(id) == 0) {
                return iterator;
            }

            iterator = iterator.nextVertex;
        }
        return null;
    }

    //istenilen id'deki vertexe kenar ekler
    public void addEdge(T startId, T endId) {
        //komşuyu ekleyeceğim düğüm
        Vertex<T> startVertex = findVertex(startId);
        if (startVertex != null && findVertex(endId) != null) {
            Edge<T> newEdge = new Edge(endId);
            //eklenecek düğümün hiç kenarı yoksa
            if (startVertex.edgeLink == null) {
                startVertex.edgeLink = newEdge;
            } else {
                //daha önce eklenmiş kenarları varsa
                Edge<T> iterator = startVertex.edgeLink;
                while (iterator.nextEdge != null) {
                    iterator = iterator.nextEdge;
                }

                iterator.nextEdge = newEdge;
            }

        } else {
            System.out.println("başlangıç veya bitiş düğümü yok");
        }

    }

    //çizgeyi listeler
    public void display() {
        if (head == null) {
            return;
        }

        Vertex<T> iterator = head;
        while (iterator != null) {
            System.out.print(iterator.id);
            Edge<T> current = iterator.edgeLink;

            while (current != null) {
                System.out.print("-->" + current.vertexId);
                current = current.nextEdge;
            }
            iterator = iterator.nextVertex;
            System.out.println("");

        }
    }

    //id sini vermiş olduğum vertexten çıksn yol sayısı
    public int outDegree(T id) {
        int count = 0;
        Vertex<T> iterator = findVertex(id);
        Edge<T> current = iterator.edgeLink;
        while (current != null) {
            count++;
            current = current.nextEdge;
        }
        return count;
    }

    //id si girilen dügüme giren yol sayısı
    public int inDegree(T id) {
        int count = 0;
        Vertex<T> iterator = head;
        //her bir düğümü geziyoruz
        while (iterator != null) {
            Edge<T> current = iterator.edgeLink;
            //gezdiğimiz her düğümün yollarına bakıyoruz
            while (current != null) {
                //baktığımız yollar istediğimiz vertexe çıkıyorsa count'u arttırıyoruz.
                if (current.vertexId.compareTo(id) == 0) {
                    count++;
                }
                current = current.nextEdge;
            }
            iterator = iterator.nextVertex;
        }
        return count;
    }

    //düğüm sayısını döndüren metod
    public int vertexCount() {
        int count = 0;
        Vertex<T> iterator = head;
        while (iterator != null) {
            count++;
            iterator = iterator.nextVertex;
        }

        return count;
    }

    //verilen iki adet değerin komşu olup olmadığnı kontrol eder
    public int isAdjacent(T v1, T v2) {
        //kendisine komşu olmaz
        if (v1.compareTo(v2) == 0) {
            return 0;
        }
        Vertex<T> vertex1 = findVertex(v1);

        Edge<T> current = vertex1.edgeLink;

        while (current != null) {
            if (current.vertexId.compareTo(v2) == 0) {
                return 1;
            }
            current = current.nextEdge;

        }
        return 0;
    }

    //verilen vertexlerin komşu olup olmadığını kontrol eder.
    public int isAdjacent(Vertex<T> v1, Vertex<T> v2) {
        //kendine komşu olamaaz
        if (v1.id.compareTo(v2.id) == 0) {
            return 0;
        }
        Edge<T> current = v1.edgeLink;
        while (current != null) {
            if (current.vertexId.compareTo(v2.id) == 0) {
                return 1;
            }
            current = current.nextEdge;
        }

        return 0;
    }

    //komşuluk matrisini oluşturup döndüren metod
    public int[][] adjacentMatrix() {
        int size = this.vertexCount();
        //komşuluk matrisini tutacağım dizi
        int[][] arr = new int[size][size];

        Vertex<T> iterator = head;
        //indexleme yapabilmek için her elemanı birbiri ile kıyaslama işlemi
        for (int i = 0; i < size; i++) {
            Vertex<T> current = head;
            for (int j = 0; j < size; j++) {
                if (iterator != null && current != null) {
                    arr[i][j] = isAdjacent(iterator, current);
                    current = current.nextVertex;
                }
            }
            iterator = iterator.nextVertex;
        }

        return arr;
    }

    //idsi verilen düğümü silen metod
    public void delete(T id) {
        //verilen id değeri listede yoksa
        if (findVertex(id) == null) {
            return;
        }
        //id head a eşitse
        if (head.id.compareTo(id) == 0) {
            head = head.nextVertex;
        } else {
            //id headdan farklı ise 
            Vertex<T> iterator = head;
            Vertex<T> previous = head;

            while (iterator.id.compareTo(id) != 0) {
                previous = iterator;
                iterator = iterator.nextVertex;
            }

            previous.nextVertex = iterator.nextVertex;
            iterator.nextVertex = null;

        }

    }

    //hiçkimsenin komşusu olmayan vertexleri dönen metod
    public Vertex<T> findVertexWithZeroInDegree() {

        if (head == null) {
            return null;
        }

        Vertex<T> iterator = head;
        while (iterator != null) {
            if (inDegree(iterator.id) == 0) {
                return iterator;
            }
            iterator = iterator.nextVertex;
        }

        return null;
    }

    //topolojik sıralama yapan metod
    //Bir işi yapmadan önce bitirilmesi gereken ön koşulları sıralamak
    public void toptlocigalSorting() {
        int size = vertexCount();
        for (int i = 0; i < size; i++) {
            Vertex<T> current = findVertexWithZeroInDegree();
            if (current.id == null) {
                System.out.println("grafta cycle var topolocigal sorting olmaz");
                return;
            }
            System.out.println(current + " ");
            delete(current.id);

        }
    }

    //düğümlerin gezildi bilgisini sıfırlar
    public void resetVizited() {
        Vertex<T> iterator = head;
        while (iterator != null) {
            iterator.visited = false;
            iterator = iterator.nextVertex;
        }
    }

    //BFS dolaşma algoritmasi
    public void breadthFirstSearch(T startId) {
        // Başlangıç düğümünü bul
        Vertex<T> startVertex = findVertex(startId);

        if (startVertex == null) {
            System.out.println("baslangic dugumu bulunamadi");
            return;
        }

        // Eski ziyaret kayıtlarını temizle
        resetVizited();

        MyQueue<Vertex<T>> queue = new MyQueue<>();

        // Başlangıcı işaretle ve kuyruğa at
        startVertex.visited = true;
        queue.enQueue(startVertex);

        System.out.println("BFS: ");

        // Kuyruk boşalana kadar dön
        while (!queue.isEmpty()) {
            // Sıradaki düğümü al ve yazdır
            Vertex<T> current = queue.deQueue();
            System.out.print(current.id + " ");

            // Komşuları gezmeye başla
            Edge<T> edgeIterator = current.edgeLink;

            while (edgeIterator != null) {
                // Kenarın ucundaki komşuyu bul
                Vertex<T> neighbor = findVertex(edgeIterator.vertexId);

                // Komşu varsa ve ziyaret edilmemişse
                if (neighbor != null && !neighbor.visited) {
                    neighbor.visited = true;   // İşaretle
                    queue.enQueue(neighbor);   // Kuyruğa ekle
                }

                // Sonraki komşuya geç
                edgeIterator = edgeIterator.nextEdge;
            }

        }
        System.out.println("");
    }

    //DFS dolaşma algoritması
    public void depthFirstSearch(T startId) {
        // Başlangıç düğümünü bul
        Vertex<T> startVertex = findVertex(startId);

        if (startVertex == null) {
            System.out.println("baslangic dugumu bulunamadi");
            return;
        }

        // Eski ziyaret kayıtlarını temizle
        resetVizited();

        // DFS için Yığın (Stack) oluştur (LIFO mantığı)
        MyStack<Vertex<T>> stack = new MyStack();

        // Başlangıcı işaretle ve yığına at
        startVertex.visited = true;
        stack.push(startVertex);

        System.out.println("DFS: ");

        // Yığın boşalana kadar dön
        while (!stack.isEmpty()) {
            // En üstteki elemanı çek ve yazdır
            Vertex<T> current = stack.pop();
            System.out.print(current.id + " ");

            // Komşuları gezmeye başla
            Edge<T> edgeIterator = current.edgeLink;
            while (edgeIterator != null) {
                // Kenarın ucundaki komşuyu bul
                Vertex<T> neighbor = findVertex(edgeIterator.vertexId);

                // Komşu varsa ve ziyaret edilmemişse
                if (neighbor != null && !neighbor.visited) {
                    neighbor.visited = true;  // İşaretle
                    stack.push(neighbor);     // Yığına ekle (Derine inmek için)
                }
                // Sonraki komşuya geç
                edgeIterator = edgeIterator.nextEdge;
            }
        }

        System.out.println("");
    }

}
