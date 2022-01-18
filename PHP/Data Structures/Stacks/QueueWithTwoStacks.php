<?php
class MyQueue {
    /**
     */
    public $output;
    public $input;
    
    function __construct() {
        
        $this->output = new SplStack();
        $this->input = new SplStack();
    }
  
    /**
     * @param Integer $x
     * @return NULL
     */
    function push($x) {
        $this->input->push($x);
    }
  
    /**
     * @return Integer
     */
    function pop() {
        if($this->output->isEmpty())
           $this->shift();
        if(!$this->output->isEmpty())
           return $this->output->pop();
    }
  
    /**
     * @return Integer
     */
    function peek() {
        if($this->output->isEmpty())
           $this->shift();
        if(!$this->output->isEmpty())
           return $this->output->top();
    }
  
    /**
     * @return Boolean
     */
    function empty() {
        return $this->input->isEmpty() &&  $this->output->isEmpty();
    }

    public function shift()
    {
        while($this->input->isEmpty())
        {
            $this->output->push($this->input->pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * $obj = MyQueue();
 * $obj->push($x);
 * $ret_2 = $obj->pop();
 * $ret_3 = $obj->peek();
 * $ret_4 = $obj->empty();
 */