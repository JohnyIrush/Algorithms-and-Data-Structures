<?php

class Graph
{
    public $adjacency_list = [];

    public function createGraph($vertices)
    {
        for ($i = 0; $i < $vertices; $i++)
        { 
            array_push($this->adjacency_list, []);
        }
    }

    public function addEdge($source, $vertex)
    {
        array_push($this->adjacency_list[$source], $vertex);
        array_push($this->adjacency_list[$vertex], $source);
    }

    public function printGraph()
    {
        print("\nAdjacent List Representation Of Graph");
        for ($i = 0; $i  < sizeof($this->adjacency_list); $i++)
        { 
            print("\nAdjacent nodes of vertex" . $i);
            for ($j = 0; $j < sizeof($this->adjacency_list[$i]); $j++)
            { 
                echo(" -> " . $this->adjacency_list[$i][$j]);
            }
        }
    }
}

//Graph::createGraph(5);
/*
$graph = new Graph();
$graph->createGraph(6);
$graph->addEdge(0, 1);
$graph->addEdge(0, 4);
$graph->addEdge(1, 2);
$graph->addEdge(1, 3);
$graph->addEdge(1, 4);
$graph->addEdge(2, 3);
$graph->addEdge(3, 4);

$graph->printGraph();
*/

?>