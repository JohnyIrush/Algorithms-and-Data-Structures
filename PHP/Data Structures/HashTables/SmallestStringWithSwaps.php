<?php

class SmallestStringWithSwaps
{

    /**
     * @param String $s
     * @param Integer[][] $pairs
     * @return String
     */
    public $group = [];

    public function __construct()
    {
        $this->group = [];
    }

    public function union($a, $b)
    {
        $this->group[$this->find($a)] = $this->group[$this->find($b)];
    }

    public function find($a)
    {
        if($this->group[$a] !== $a)
           $this->group[$a] = $this->find($this->group[$a]);

        return $this->group[$a];
    }

    function smallestStringWithSwaps($s, $pairs)
    {
        $this->group = new SplFixedArray(strlen($s));
        $this->group = array_fill(0,strlen($s),"");

        for ($i=0; $i < strlen($s); $i++)
        { 
            $this->group[$i] = $i;
        }

        foreach ($pairs as $key => $pair)
        {
            $this->union($pair[0] - 1, $pair[1] - 1);
        }

        $groupChar = [];

        for ($j = 0; $j < strlen($s); $j++)
        { 
            (is_object($groupChar[$this->find($j)]) && sizeof($groupChar[$this->find($j)]) > 0)? $groupChar[$this->find($j)]->enqueue($s[$j]): $groupChar[$this->find($j)] = (new SplQueue())->enqueue($s[$j]);
        }

        $output = "";

        for ($k=0; $k < strlen($s); $k++)
        { 
            $output .= $groupChar[$this->find($k)]->dequeue();
        }

        return $output;
    } 
}

echo gettype((new SplQueue()));