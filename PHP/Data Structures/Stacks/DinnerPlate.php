<?php
class DinnerPlate
{
    public $capacity;
    public $left;
    public $right;
    public $list = [];

    /**
     * @param Integer $capacity
     */
    function __construct($capacity) {
        $this->capacity = $capacity;
        $this->left = 0;
        $this->right = 0;
        $this->list = array_fill(0, 100, new SplStack());
    }
  
    /**
     * @param Integer $val
     * @return NULL
     */
    function pushTwo($val) {
        
        $stack = new SplStack();
        $idx = -1;

        for ($i = $this->left; $i < sizeof($this->list); $i++)
        { 
            if(sizeof($this->list[$i]) < $this->capacity)
            {
                $stack = $this->list[$i];
                $idx = $i;
                break;
            }
        }

        if($stack !== null)
        {
            $stack->push($val);
            $this->left = $idx;

            $list[$idx] = $stack;
        }
        else
        {
            $stack = new SplStack();
            $stack->push($val);
            array_push($list,$stack);
            $this->left = sizeof($list) - 1;
            $this->right = sizeof($list) - 1;
        }

        //return $this->list;
    }
  
    /**
     * @return Integer
     */
    function pop() {
        
    }
  
    /**
     * @param Integer $index
     * @return Integer
     */
    function popAtStack($index) {
        
    }
}

$dinnerPlate = new DinnerPlate(2);
$dinnerPlate->pushTwo(1);
//$dinnerPlate->push(2);
//$dinnerPlate->push(3);
//$dinnerPlate->push(4);
$dinnerPlate->pushTwo(5);
print_r($dinnerPlate->list);

