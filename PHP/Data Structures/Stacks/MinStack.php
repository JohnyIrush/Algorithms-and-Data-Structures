
<?php
class MinStack {
    /**
     */
    public $stack;
    public $minStack;

    function __construct() {
        $this->stack = new SplStack();
        $this->minStack = new SplStack();
        

    }
  
    /**
     * @param Integer $val
     * @return NULL
     */
    function push($val) {
           $this->stack->push($val);
           $this->setMin($val); 
    }
  
    /**
     * @return NULL
     */
    function pop() {
        if (!$this->stack->isEmpty())
        {
            if($this->minStack->top() === $this->stack->top())
            {
                $this->minStack->pop();  
            }
            return $this->stack->pop();
        }
          
    }
  
    /**
     * @return Integer
     */
    function top() {
        if (!$this->stack->isEmpty())
          return $this->stack->top();
    }
  
    /**
     * @return Integer
     */
    function getMin() {
        
        return $this->minStack->top();
    }


    function setMin($val) {
        if ($this->minStack->isEmpty() ||  $val <= $this->minStack->top())
           $this->minStack->push($val);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * $obj = MinStack();
 * $obj->push($val);
 * $obj->pop();
 * $ret_3 = $obj->top();
 * $ret_4 = $obj->getMin();
 */