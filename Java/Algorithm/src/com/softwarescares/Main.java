package com.softwarescares;


import com.softwarescares.Graph;
import com.softwarescares.Graphs.Prims;

import javax.lang.model.type.NullType;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// define edges of the graph
        /*
        Graph.createGraph(5);
        // Adding edges one by one

        Graph.addEdge(0, 1);
        Graph.addEdge(0, 4);
        Graph.addEdge(1, 2);
        Graph.addEdge(1, 3);
        Graph.addEdge(1, 4);
        Graph.addEdge(2, 3);
        Graph.addEdge(3, 4);




        com.softwarescares.Graph.createGraph(6);
        com.softwarescares.Graph.addEdge(0, 5);
        com.softwarescares.Graph.addEdge(5, 2);
        com.softwarescares.Graph.addEdge(5, 0);
        com.softwarescares.Graph.addEdge(4, 0);
        com.softwarescares.Graph.addEdge(4, 1);
        com.softwarescares.Graph.addEdge(2, 3);
        com.softwarescares.Graph.addEdge(3, 1);
        com.softwarescares.Graph.printGraph();

         */


        /*
       com.softwarescares.DFS dfs = new com.softwarescares.DFS(com.softwarescares.Graph.adjacency_list);

       System.out.println(
                "Following is Depth First Traversal");

       dfs.dfs(5);



        com.softwarescares.BFS bfs = new com.softwarescares.BFS(com.softwarescares.Graph.adjacency_list);

        System.out.println();
        System.out.println(
                "Following is Breath First Traversal");

        bfs.bfs(5);





        com.softwarescares.TopologicalSort topologicalSort = new com.softwarescares.TopologicalSort(com.softwarescares.Graph.adjacency_list);

        System.out.println();
        System.out.println(
                "Following is Topological Sort");

        topologicalSort.topologicalSort();




        ArrayList<ArrayList<Integer>> array_list = new ArrayList<>();

        array_list.add(new ArrayList<>());
        array_list.get(0).add(10);
        array_list.get(0).add(10);
        System.out.println(array_list.get(0));

         */

        /*
        System.out.println();

        // make dictionary
        Set<String> Dictionary = new HashSet<>();
        Dictionary.add("poon");
        Dictionary.add("doon");
        Dictionary.add("plee");
        Dictionary.add("same");
        Dictionary.add("poie");
        Dictionary.add("plie");
        Dictionary.add("poin");
        Dictionary.add("plea");
        String start = "toon";
        String target = "plea";
        System.out.print("Length of shortest chain is: "
                + ShortChainLength.shortestChainLength(start, target, Dictionary));


        Graph.createGraph(10);
        Graph.addEdge(1, 2);
        Graph.addEdge(1, 3);
        Graph.addEdge(3, 6);
        //Graph.addEdge(3, 4);
        Graph.addEdge(2, 5);
        Graph.addEdge(5, 7);
        Graph.addEdge(5, 8);
        Graph.addEdge(5, 9);
        Graph.printGraph();

        DFS dfs = new DFS(Graph.adjacency_list);

        System.out.println(
                "Following is Depth First Traversal");

        dfs.dfs(1);


        System.out.println();

        CheckSamePath query = new CheckSamePath(Graph.adjacency_list);
        query.dfs(1);

        // Below are calls for few pairs of nodes
        if (query.query(1, 5))
            System.out.print("Yes\n" );
        else
            System.out.print("No\n");

        if (query.query(2, 9))
            System.out.print("Yes\n");
        else
            System.out.print("No\n");

        if (query.query(4, 3))
            System.out.print("Yes\n" );
        else
            System.out.print("No\n");



        int m = 5, n = 5;

        int i = 2, j = 2;


        int N = 2;
            System.out.println("Probability is " +
                    MatrixProbability.findProbability(m, n, i,
                        j, N));



        Graph.createGraph(7);
        Graph.addEdge(0, 1);
        Graph.addEdge(0, 2);
        Graph.addEdge(1, 3);
        Graph.addEdge(4, 1);
        Graph.addEdge(6, 4);
        Graph.addEdge(5, 6);
        Graph.addEdge(5, 2);
        Graph.addEdge(6, 0);

        System.out.println("The mother vertex is " +
                new MotherVertex(Graph.adjacency_list).motherVertex());

        System.out.print((1%10));


        int x = 40;
        JumpingNumbers obj = new JumpingNumbers();
        obj.printJumpingNumbers(x);



        TrianglesInGraph obj = new TrianglesInGraph(3);

        int graph[][] = { {0, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 0}
        };

        System.out.println("Total number of Triangle in Graph : "+
                obj.triangleInGraph(graph));

         */
        /*
        com.softwarescares.Graph.createGraph(4);
        com.softwarescares.Graph.addEdge(0, 1);
        com.softwarescares.Graph.addEdge(0, 2);
        com.softwarescares.Graph.addEdge(1, 2);
        com.softwarescares.Graph.addEdge(2, 0);
        com.softwarescares.Graph.addEdge(2, 3);
        com.softwarescares.Graph.addEdge(3, 3);
        com.softwarescares.Graph.printGraph();

        if(new com.softwarescares.DetectCycle(com.softwarescares.Graph.adjacency_list).isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");
         */
		/* Let us create the following graph
		0
		| \
		|  \
		1---2 */
        /*
        int V = 3, E = 3;
        UnionFind graph = new UnionFind(V, E);

        // add edge 0-1
        graph.edge[0].source = 0;
        graph.edge[0].destination = 1;

        // add edge 1-2
        graph.edge[1].source = 1;
        graph.edge[1].destination = 2;

        // add edge 0-2
        graph.edge[2].source = 0;
        graph.edge[2].destination = 2;

        if (graph.isCycle(graph)==1)
            System.out.println( "graph contains cycle" );
        else
            System.out.println( "graph doesn't contain cycle" );


        // Create a graph given
        // in the above diagram
        Graph.createGraph(5);
        Graph.addEdge(1, 0);
        Graph.addEdge(0, 2);
        Graph.addEdge(2, 1);
        Graph.addEdge(0, 3);
        Graph.addEdge(3, 4);
        if (new DetectCycleUndirectedGraph(Graph.adjacency_list).isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");

        Graph.createGraph(3);
        Graph.addEdge(0, 1);
        Graph.addEdge(1, 2);
        if (new DetectCycleUndirectedGraph(Graph.adjacency_list).isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");



        // Create a graph given in the above diagram
         Graph.createGraph(4);
        Graph.addEdge( 0, 1);
        Graph.addEdge( 0, 2);
        Graph.addEdge( 1, 2);
        Graph.addEdge( 2, 0);
        Graph.addEdge( 2, 3);
        Graph.addEdge( 3, 3);
        if (new DetectCycleColor(Graph.adjacency_list).isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");



        // Create a graph given in the above diagram
        Graph.createGraph(5);
        Graph.addEdge(1, 0);
        Graph.addEdge(0, 2);
        Graph.addEdge(2, 1);
        Graph.addEdge(0, 3);
        Graph.addEdge(3, 4);
        Graph.printGraph();
        new Kosorajus(Graph.adjacency_list).printTransposed();

        System.out.println("Following are strongly connected components "+
                "in given graph ");
        new Kosorajus(Graph.adjacency_list).printSCCs();



        Graph.createGraph(5);

        Graph.addEdge(1, 0);
        Graph.addEdge(0, 2);
        Graph.addEdge(2, 1);
        Graph.addEdge(0, 3);
        Graph.addEdge(1, 4);
        Graph.printGraph();

        System.out.println("Following is the Depth First Traversal");
        new IterativeDFS(Graph.adjacency_list).dfs(0);
         */

        /*
        // Create a graph given in the above diagram
        com.softwarescares.Graph.createGraph(5);
        com.softwarescares.Graph.addEdge(1, 0);
        com.softwarescares.Graph.addEdge(0, 2);
        com.softwarescares.Graph.addEdge(0, 3);
        com.softwarescares.Graph.addEdge(3, 4);
        if (new com.softwarescares.CheckIfGraphIsTree(com.softwarescares.Graph.adjacency_list).isTree())
            System.out.println("Graph is Tree");
        else
            System.out.println("Graph is not Tree");

        com.softwarescares.Graph.createGraph(5);
        com.softwarescares.Graph.addEdge(1, 0);
        com.softwarescares.Graph.addEdge(0, 2);
        com.softwarescares.Graph.addEdge(2, 1);
        com.softwarescares.Graph.addEdge(0, 3);
        com.softwarescares.Graph.addEdge(3, 4);

        if (new com.softwarescares.CheckIfGraphIsTree(com.softwarescares.Graph.adjacency_list).isTree())
            System.out.println("Graph is Tree");
        else
            System.out.println("Graph is not Tree");

         */


        /*
        // Create graphs given in above diagrams
        System.out.println("Bridges in first graph ");
        Graph.createGraph(5);
        Graph.addEdge(1, 0);
        Graph.addEdge(0, 2);
        Graph.addEdge(2, 1);
        Graph.addEdge(0, 3);
        Graph.addEdge(3, 4);
        Graph.printGraph();
        new Bridges(Graph.adjacency_list).bridge();

        System.out.println();

        System.out.println("Bridges in Second graph");
        Graph.createGraph(4);
        Graph.addEdge(0, 1);
        Graph.addEdge(1, 2);
        Graph.addEdge(2, 3);
        Graph.printGraph();
        new Bridges(Graph.adjacency_list).bridge();

        System.out.println();

        System.out.println("Bridges in Third graph ");
        Graph.createGraph(7);
        Graph.addEdge(0, 1);
        Graph.addEdge(1, 2);
        Graph.addEdge(2, 0);
        Graph.addEdge(1, 3);
        Graph.addEdge(1, 4);
        Graph.addEdge(1, 6);
        Graph.addEdge(3, 5);
        Graph.addEdge(4, 5);
        Graph.printGraph();
        new Bridges(Graph.adjacency_list).bridge();




        // Let us create the example graph discussed above
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        com.softwarescares.Dijkstra dijkstra = new com.softwarescares.Dijkstra(graph);
        dijkstra.dijkstra(0);




        int graph[][] = new int[][] { { 0, 1, 1, 1},
                                      { 1, 0, 0, 1},
                                      { 1, 0, 0, 1},
                                      { 1, 1, 1, 0}
                                     };

        VertexDegree.findDegree(graph, 1);



        Graph.createGraph(4);
        Graph.addEdge( 0, 2);
        Graph.addEdge( 0, 3);
        Graph.addEdge( 2, 3);
        Graph.addEdge( 1, 3);

        System.out.println("Sum of dependencies is " +
                (new SumOfDependencies(Graph.adjacency_list).findSum()));




        // Create a graph given in the above diagram
        Graph.createGraph(8);
        Graph.addEdge(0, 1);
        Graph.addEdge(0, 2);
        Graph.addEdge(1, 2);
        Graph.addEdge(3, 4);
        Graph.addEdge(4, 5);
        Graph.addEdge(6, 7);

        System.out.println(new CountUnreachableNodes(Graph.adjacency_list).countUnreachable(2));



        // Create a graph given in the above diagram.
        // Here vertex numbers are 0, 1, 2, 3, 4, 5 with
        // following mappings:
        // 0=r, 1=s, 2=t, 3=x, 4=y, 5=z
        WeightedGraph.Graph g = new WeightedGraph.Graph(6);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 5, 1);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);

        int s = 1;
        System.out.print("Following are longest distances from source vertex "+ s + " \n" );
        new LongestPath(g.adjacency_list).longestPath(s);

        int cost[][] = { {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3} };

        System.out.print(MinimumCostPath.minCost(cost, 2, 2));

        //-- Merge sort

        int[] inputArray = {1,6,7,5,0};

        MergeSort.mergeSort(inputArray);
        for (int index = 0; index < inputArray.length; index++)
        {
            System.out.print(inputArray[index]);
        }
        */
        //-- Quick Sort

        /*
        int[] inputArray = {1,6,7,5,0,8,10,-1};

        com.softwarescares.QuickSort.quickSort(inputArray);
        for (int index = 0; index < inputArray.length; index++)
        {
            System.out.print(inputArray[index]);
        }
        */
        /*
        PrimTwo t = new PrimTwo();
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };

        // Print the solution
        t.primMST(graph);

        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };
        Prims t = new Prims(graph);

        // Print the solution
        t.prim();


        int V = 4; // Number of vertices in graph
        int E = 5; // Number of edges in graph
        Kruskals graph = new Kruskals(V, E);

        // add edge 0-1
        graph.edge[0].source = 0;
        graph.edge[0].destination = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].source = 0;
        graph.edge[1].destination = 2;
        graph.edge[1].weight = 6;

        // add edge 0-3
        graph.edge[2].source = 0;
        graph.edge[2].destination = 3;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].source = 1;
        graph.edge[3].destination = 3;
        graph.edge[3].weight = 15;

        // add edge 2-3
        graph.edge[4].source = 2;
        graph.edge[4].destination = 3;
        graph.edge[4].weight = 4;

        // Function call
        graph.kruskal();

        //-- Insertion sort

        int[] inputArray = {1,6,7,5,0};

        InsertionSort.sort(inputArray);
        for (int index = 0; index < inputArray.length; index++)
        {
            System.out.print(inputArray[index]);
        }
        */

        /*
        //-- Selection sort
        Integer[] inputArray = {1,6,7,5,0};

        new com.softwarescares.SelectionSort<>(inputArray).sort();
        for (int index = 0; index < inputArray.length; index++)
        {
            System.out.print(inputArray[index]);
        }

         */

        /*
        //-- Counting sort

        int[] inputArray = {1,6,7,5,0};

        new CountingSort(inputArray).sort();
        for (int index = 0; index < inputArray.length; index++)
        {
            System.out.print(inputArray[index]);
        }

         */


        //-- Kadanes
        /*
        int[] array = {-2,-3,4,-1,-2,1,5,-1};
        Kadanes kadanes = new Kadanes(array);
        System.out.println(kadanes.largeSumSubArray());

         */
        /*

        //-- Flood Fill
        int[][] image = {{1,1,1},
                         {1,1,0},
                         {1,0,1}};

        FloodFill floodFillObj = new FloodFill();
        int[][] Output = floodFillObj.floodFill(image, 0,0,2);

        for (int i = 0; i < image.length; i++)
        {
            for (int j = 0; j < image.length; j++)
            {
                System.out.println(Output[i][j]);
            }
        }
        */
        /*
        KMP kmp = new KMP();
        String string = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        kmp.kmp(string, pattern);

        int[] lps = new int[pattern.length()];
        kmp.createLPS(pattern,pattern.length(), lps);

        for (int i = 0; i < pattern.length(); i++)
        {
            System.out.print(lps[i]);
        }
         */
        /*
        if (kmp.kmp("abcdabcabcdf", "abcdf"))
            System.out.println("There is a Pattern");
        else
            System.out.println("There is No Pattern");
        */

        /*
        Euclidean gcd = new Euclidean();
        System.out.println(gcd.gcd(252,105));
        //System.out.println(252%105);
         */

        /*
        // Create a graph given in the above diagram
        Graph.createGraph(6);
        Graph.addEdge(5, 2);
        Graph.addEdge(5, 0);
        Graph.addEdge(4, 0);
        Graph.addEdge(4, 1);
        Graph.addEdge(2, 3);
        Graph.addEdge(3, 1);
        System.out.println(
                "Following is a Topological Sort");
        new Khans(Graph.adjacency_list).topologicalSort();
         */

        /*
        Huffman huffman = new Huffman("aaaaaaaabbbbbbbccccdd");
        String encodedText = huffman.encode();
        System.out.println(encodedText);
         */
        
        //-- BubbleSort

        /*
        int[] array = {17,10,1,-1,0};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array);

        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        */


    }
}
