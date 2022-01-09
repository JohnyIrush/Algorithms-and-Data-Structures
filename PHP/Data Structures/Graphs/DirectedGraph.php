<?php

class ListNode
{
    public $id;
    public $next;

    public function __construct($id)
    {
        // Set value of node key
        $this->id = $id;
        $this->next = Null;
    }
}

class Vertices
{
    public $data;
    public $next;
    public $last;

    public function __construct($data)
    {
        $this->data = $data;
        $this->next = NULL;
        $this->last = NULL;
    }
}


class GraphTwo
{
    public $size;
    public $node;

    public function __construct($size)
    {
        $this->size = $size;
        $this->node = array_fill(0, $size, NULL);
        $this->setData();
    }

    public function setData()
    {
        if ($this->size  <= 0)
        {
            echo PHP_EOL . "Empty Graph";
        }
        else
        {
            for ($index = 0; $index < $this->size; $index++)
            { 
                $this->node[$index] = new Vertices($index);
            }

            # print_r($this->node);
        }
    }

    public function connect($start, $last)
    {
        $edge = new ListNode($last);

        if ($this->node[$start]->next == NULL)
        {
            echo "Is Null";
            $this->node[$start]->next = $edge;
        }
        else
        {
            $this->node[$start]->last->next = $edge;
        }
        $this->node[$start]->last = $edge;
    }

    public function addEdge($start, $last)
    {
        if ($start >= 0 && $start < $this->size && $last >= 0 && $last < $this->size)
        {
            $this->connect($start, $last);
        }
        else
        {
            // When invalid nodes
			printf("%s\n", "\nHere Something Wrong");
        }
    }

    public function printGraph()
    {
        if ($this->size > 0)
        {
            for ($index = 0; $index < $this->size; $index++)
            { 
                printf("\nAdjacency list of vertex %d :",$index);
                $temp = $this->node[$index]->next;

                while ($temp != NULL)
                {
					// Display graph node 
					printf("  %d",($this->node[$temp->id]->data));
					// visit to next edge
					$temp = $temp->next;
                }
            }
        }
    }

    public function traversal(&$visit, $point)
    {
        if ($visit[$point])
        {
            return;
        }

        $visit[$point] = true;
        echo $point;

        $temp = $this->node[$point]->next;

        while ($temp != NULL)
        {
            $this->traversal($visit, $temp->id);

            $temp = $temp->next;
        }
    }

	// Handles the request of printing dfs sequence
	public	function dfs($point)
	{
		if ($this->size <= 0 || $point < 0 || $point >= $this->size)
		{
			return;
		}
		// This is node visitor
		$visit = array_fill(0, $this->size, false);
		// There is no initial node visiting
		for ($i = 0; $i < $this->size; ++$i)
		{
			$visit[$i] = false;
		}
		// Start traversal
		$this->traversal($visit, $point);
	}
    
}

$graph = new GraphTwo(5);
$graph->addEdge(0, 1);
$graph->addEdge(0, 2);
$graph->addEdge(0, 4);
$graph->addEdge(0, 3);
$graph->addEdge(1, 3);
$graph->addEdge(2, 4);
$graph->addEdge(2, 1);
$graph->addEdge(2, 1);
$graph->addEdge(3, 2);
$graph->addEdge(4, 2);
$graph->printGraph();
echo PHP_EOL;
$graph->dfs(1);



?>