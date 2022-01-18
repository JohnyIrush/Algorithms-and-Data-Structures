<?php

class FreqStack {
    /**
     */

     public $stack;
     public $frequencyMap;
     public $maxFrequency;
     
    function __construct() {
        $this->stack = array_fill(0,100,new SplStack()); ;
        $this->frequencyMap = array_fill(0,100,0); 
        $this->maxFrequency = 0;
    }
  
    /**
     * @param Integer $val
     * @return NULL
     */
    function push($val) {
        $freq = $this->frequencyMap[$val]  + 1;
        $this->frequencyMap[$val] = $freq;
        if($freq > $this->maxFrequency) $this->maxFrequency = $freq;

        $this->stack[$freq]->push($val);
    }
  
    /**
     * @return Integer
     */
    function pop() {
        $stack = $this->stack[$this->maxFrequency];

        $top = $stack->pop();

        if($stack->isEmpty()) $this->maxFrequency--;

        $this->frequencyMap[$top] = $this->frequencyMap[$top] - 1;

        return $top;
    }
}

//["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"]
//[[],[5],[7],[5],[7],[4],[5],[],[],[],[]]

/**
 * Your FreqStack object will be instantiated and called as such:
 * $obj = FreqStack();
 * $obj->push($val);
 * $ret_2 = $obj->pop();
 */

$freqStack = new FreqStack();
$freqStack->push(5); // The stack is [5]
$freqStack->push(7); // The stack is [5,7]
$freqStack->push(5); // The stack is [5,7,5]
$freqStack->push(7); // The stack is [5,7,5,7]
$freqStack->push(4); // The stack is [5,7,5,7,4]
$freqStack->push(5); // The stack is [5,7,5,7,4,5]
//echo $freqStack->pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
//$freqStack->pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
//$freqStack->pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
//$freqStack->pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].

print_r($freqStack->stack);
//print_r($freqStack->frequencyMap);