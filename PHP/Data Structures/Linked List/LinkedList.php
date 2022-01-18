<?php
class MyLinkedList {
    /**
     */
    public $head;
    public $val = null;
    public $next = null;
    function __construct() {
    }
  
    /**
     * @param Integer $index
     * @return Integer
     */
    function get($index) {
        
    }
  
    /**
     * @param Integer $val
     * @return NULL
     */
    function addAtHead($val) {
        if($this->head === null)
        {
         $this->head = new MyLinkedList();
         $this->head->val = $val;
         $this->head->next = null;
        }
        else
        {
            $newNode = new MyLinkedList();
            $newNode->val = $val;
            
            $newNode->next = $this->head;
            
            $this->head = $newNode;
            
            
        }
    }
  
    /**
     * @param Integer $val
     * @return NULL
     */
    function addAtTail($val) {
        
        $this->head = $this->reverse($this->head);
        $this->addAtHead($val);
        $this->head = $this->reverse($this->head);
    }
  
    /**
     * @param Integer $index
     * @param Integer $val
     * @return NULL
     */
    function addAtIndex($index, $val) {
        if($index === 0)
        {
            $this->addAtHead($val);
        }
        
        $next = null;
        $previous = null;
        $temp = &$this->head;
        $current = $index;
        
        while($temp != null && $current > 1)
        {
            $current -= 1;
            $previous = $this->head;
            $temp = $temp->next;
            $next = $temp->next;
        }
        
        if($current === 1)
        {
            $newNode = new MyLinkedList();
            $newNode->val = $val;
            
            $newNode->next = null;
            $temp->next = $newNode->next;
            //$temp->next = $next;
            
        }
        
    }
  
    /**
     * @param Integer $index
     * @return NULL
     */
    function deleteAtIndex($index) {
        
    }
    
    public function reverse($list) {
        
        if($list === null)
            return null;
        
        $next = null;
        $previous = null;
        
        while($list != null)
        {
            $next = $list->next;
            $list->next = $previous;
            $previous = $list;
            $list = $next;
        }
        
        return $previous;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * $obj = MyLinkedList();
 * $ret_1 = $obj->get($index);
 * $obj->addAtHead($val);
 * $obj->addAtTail($val);
 * $obj->addAtIndex($index, $val);
 * $obj->deleteAtIndex($index);
 */

$list = new MyLinkedList();

$list->addAtHead(1);
$list->addAtHead(2);
$list->addAtTail(3);
$list->addAtIndex(1, 5);

print_r($list);