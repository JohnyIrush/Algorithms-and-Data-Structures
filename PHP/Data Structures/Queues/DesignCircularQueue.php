<?php
class MyCircularQueue {
    /**
     * @param Integer $k
     */
    public $queue = [];
    public $front = 0, $rear = 0, $size = 0;

    function __construct($k)
    {
     $this->queue = new SplFixedArray($k);  
     $this->queue = array_fill(0,$k,-1);
    }
  
    /**
     * @param Integer $value
     * @return Boolean
     */
    function enQueue($value) {
        if($this->isFull())
        {
            return false;
        }
        if($this->isEmpty())
        {
            $this->rear = $this->front = 0; 
            $this->queue[$this->rear] = $value;
            $this->size++;
            return true;
        }
        $this->rear++;
        $this->size++;
        $this->rear = $this->rear % sizeof($this->queue);
        $this->queue[$this->rear] = $value;
        return true;
    }
  
    /**
     * @return Boolean
     */
    function deQueue() {
        if($this->isEmpty())
          return false;

        $this->queue[$this->front] = -1;
        $this->front++;
        $this->size--;
        $this->front = $this->front % sizeof($this->queue);
        return true;
    } 
  
    /**
     * @return Integer
     */
    function Front() {
        return $this->queue[$this->front];
    }
  
    /**
     * @return Integer
     */
    function Rear() {
        return $this->queue[$this->rear];
    }
  
    /**
     * @return Boolean
     */
    function isEmpty() {
        return $this->size === 0;
    }
  
    /**
     * @return Boolean
     */
    function isFull() {
        return sizeof($this->queue) === $this->size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * $obj = MyCircularQueue($k);
 * $ret_1 = $obj->enQueue($value);
 * $ret_2 = $obj->deQueue();
 * $ret_3 = $obj->Front();
 * $ret_4 = $obj->Rear();
 * $ret_5 = $obj->isEmpty();
 * $ret_6 = $obj->isFull();
 */