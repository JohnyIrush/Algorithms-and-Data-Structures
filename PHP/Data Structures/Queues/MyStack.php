<?php

class MyStack {

    public $input;
    public $output;
    
    public function __construct() {
        $this->input = new SplQueue();
        $this->output = new SplQueue();
    }
    
    public function push($x) {
        $this->input->enqueue($x);
    }
    
    public function pop() {
        if($this->output->isEmpty())
            $this->shift();
        if(!$this->output->isEmpty())
            return $this->output->dequeue();
    }
    
    public function top() {
        if($this->output->isEmpty())
            $this->input->top();
        if(!$this->output->isEmpty())
            return $this->output->top();
    }
    
    public function empty() {
        return $this->output->isEmpty() && $this->input->isEmpty();
    }
    
    public function shift()
    {
        while(!$this->input->isEmpty())
        {
            $this->output->enqueue($this->input->dequeue());
        }
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */