<?php
function solution($nums, $k) {

    //$seen = range(0, $k, 1);
    $seen = [];
    
    
    if($k === 0)
      return false;
    for($i = 0; $i < sizeof($nums); $i++)
    {
        $item = $nums[$i];
        
        if(abs($seen[$item] - $i) <= $k)
        {
            return true;
        }
        
        $seen[(string)$item] = $i;
    }
    
    return false;
    }
    