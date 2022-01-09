<?php

include("Graph.php");
class DFS
{
    public $adjacency_list;
    public $vertices;
    protected $visited;

    public function __construct($adjacency_list)
    {
        $this->adjacency_list = $adjacency_list;
        $this->vertices = sizeof($this->adjacency_list);
    }

    public function dfs($vertex)
    {
        $this->visited = array();
        echo "\nDFS Traversal: \n";

        for ($i = 0; $i < $this->vertices; $i++)
        {
            array_push($this->visited, "false");
        }

        $this->traversal($vertex, $this->visited);
    }

    protected function traversal($vertex, $visited)
    {
        $visited[$vertex] = "true";

        echo $vertex . " ";

        # print_r($visited);

        $childNodes = $this->adjacency_list[$vertex];

        # print_r($this->adjacency_list);

        foreach ($childNodes as $node)
        {
            if(count(array_unique($visited)) === 1)
            {
                exit;
            }
            # echo $visited[$node];
            if($visited[$node] === "false")
            {
                $this->traversal($node, $visited);
            }
        }
    }
}

$graph = new Graph();
$graph->createGraph(5);
$graph->addEdge(0, 1);
$graph->addEdge(0, 4);
$graph->addEdge(1, 2);
$graph->addEdge(1, 3);
$graph->addEdge(1, 4);
$graph->addEdge(2, 3);
$graph->addEdge(3, 4);

$graph->printGraph();

$dfs = new DFS($graph->adjacency_list);
$dfs->dfs(0);
?>