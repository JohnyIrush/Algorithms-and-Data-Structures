<?php

// Definition for a binary tree node.
class TreeNode {
    public $val = null;
    public $left = null;
    public $right = null;
    function __construct($val = 0, $left = null, $right = null) {
        $this->val = $val;
        $this->left = $left;
        $this->right = $right;
    }
}

class MergeTwoBinaryTrees
{
   
    /**
     * @param TreeNode $root1
     * @param TreeNode $root2
     * @return TreeNode
     */
    public $mergedTree;
    function __construct() 
    {
        $this->mergedTree = new TreeNode();
    }

    function mergeTrees($root1, $root2)
    {
        $this->mergedTree = $root1;
        $this->initialize($this->mergedTree);
    }


    public function preorder($root1, $root2)
    {
        if($root1 !== null || $root2 !== null)
        {
            if($root1->val !== null && $root2->val !== null)
            {
                $this->insert($this->mergedTree,($root1->val + $root2->val));
            }
            else if($root1->val !== null)
            {
                $this->insert($this->mergedTree,$root1->val);
            }
            else
            {
                $this->insert($this->mergedTree,$root2->val);
            }
        
        
            $this->preorder($root1->left, $root2->left);
            $this->preorder($root1->right, $root2->right);
        }
    }

    public function insert($root,$value = null)
    {
        if($root !== null)
        {
          if($root->val === null)
          {
            $root->val = $value;
          }
          $this->insert($this->mergedTree->left);
          $this->insert($this->mergedTree->right);
        }
    }

    public function initialize($root)
    {
        if($root !== null)
        {
          $root->val = null;
          $this->initialize($this->mergedTree->left);
          $this->initialize($this->mergedTree->right);
        }
    }
}