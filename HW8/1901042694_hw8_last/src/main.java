/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public class main {
    public static void main(String[] args) {


        MyGraph<Integer> testingGraph = new MyGraph<>(6);
        //Initialize vertex
        Vertex Dogubeyazit = testingGraph.newVertex("Dogubeyazit", 19.0);
        Vertex Suadiye = testingGraph.newVertex("Suadiye", 22.0);
        Vertex Pendik = testingGraph.newVertex("Pendik", 25.0);
        Vertex Gebze = testingGraph.newVertex("Gebze", 30);
        Vertex Maltepe = testingGraph.newVertex("Maltepe", 10);
        Vertex Ciftlikkoy= testingGraph.newVertex("Ciftlikkoy", 28);
        //This boosting for the 3rd question
        /**/
        //Give some properties
        //Color part
        Gebze.properties.put("Color","Gray");
        Dogubeyazit.properties.put("Color","Red");
        Suadiye.properties.put("Color","Blue");
        Maltepe.properties.put("Color","Orange");
        Ciftlikkoy.properties.put("Color","White");
        Pendik.properties.put("Color","Yellow");
        //City part
        Gebze.properties.put("City","Kocaeli");
        Dogubeyazit.properties.put("City","Agri");
        Suadiye.properties.put("City","Istanbul");
        Pendik.properties.put("City","Istanbul");
        Maltepe.properties.put("City","Istanbul");
        Ciftlikkoy.properties.put("City","Yalova");



        testingGraph.addVertex(Dogubeyazit);//0
        testingGraph.addVertex(Suadiye);//1
        testingGraph.addVertex(Pendik);//2
        testingGraph.addVertex(Gebze);//3
        testingGraph.addVertex(Maltepe);//4
        testingGraph.addVertex(Ciftlikkoy);//5


        testingGraph.addEdge(0,1,1500);//Dogubeyazit - Suadiye - 1500
        testingGraph.addEdge(0,3,1400);//Dogubeyazit - Gebze - 1400
        testingGraph.addEdge(1,3,100);//Suadiye - Gebze - 100
        testingGraph.addEdge(1,2,25);//Suadiye - Pendik - 25
        testingGraph.addEdge(2,3,30);//Pendik - Gebze - 30
        testingGraph.addEdge(3,4,35);//Gebze - Maltepe - 35
        testingGraph.addEdge(3,5,55);//Gebze - Ciftllikoy - 55

        testingGraph.printGraph();




        System.out.println("--------------------------------------");
        MyGraph<Integer> IstanbulGraph = testingGraph.filterVertices("City","Istanbul");
        IstanbulGraph.printGraph();

        System.out.println("---------------------------------------");


        double myExportMatrix [][] = testingGraph.exportMatrix();

        for(int i=0; i<testingGraph.getNumV();i++){
            System.out.print(i + " ");
            for (int j=0; j < testingGraph.getNumV();j++){
                System.out.print(myExportMatrix[i][j] + " ");
            }
            System.out.println();
        }



      /*
        System.out.println("Remove vertex");
    //   testingGraph.removeVertex(0);
       testingGraph.printGraph();

        System.out.println("Remove Edge");
     //   testingGraph.removeEdge(3,2);
        testingGraph.printGraph();

        System.out.println("Remove Vertex but parameter is Label string");
      //  testingGraph.removeVertex("Doubeyazit");
        testingGraph.printGraph();

       */



        
      double diff=  ThirQuestion.DiffBetweenTravers(testingGraph, 2, 5);

        System.out.println("Difference "+diff);




        int predArray[] = new int[100];
        double distanceArray[] = new double[100];
        Dogubeyazit.setBoosting(4.0);
        Suadiye.setBoosting(7.0);
        Pendik.setBoosting(8.0);
        Gebze.setBoosting(11.0);
        Maltepe.setBoosting(21.0);
        Ciftlikkoy.setBoosting(40.0);
        DijkstrasAlgorithm testDijkstrasAlgorithm = new DijkstrasAlgorithm();

        testDijkstrasAlgorithm.dijkstrasAlgorithm(testingGraph,3,predArray,distanceArray);
        System.out.println("Gebze to Istanbul  Dijkstra'a Algortihm Value: " + distanceArray[0]);
        System.out.println("Gebze to Suadiye  Dijkstra'a Algortihm Value: " +distanceArray[1]);
        System.out.println("Gebze to Ciftlikkoy  Dijkstra'a Algortihm Value: " + distanceArray[5]);







    }


}
