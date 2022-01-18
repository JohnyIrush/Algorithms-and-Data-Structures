<?php
function solution($N)
{

    // constraint on values 
    // of L gives us the 
    // time Complexity as O(N^0.5)
    $count = 0;
    for ($L = 1; $L * ($L + 1) < 2 * $N; $L++)
    {
        $a = (int)(1.0 * $N - ($L * (int)($L + 1)) / 2) / ($L + 1);
        
        if ($a - (int)$a == 0.0) 
            $count++; 
    }
    return $count;
    

}

function solution2($n)
{
    $count = 0;
    for ($k = 1; $k*($k+1) < 2 * $n; $k++)
    { 
        $a = (int) ((1.0 * $n) - (($k*(int)($k+1))/2))/($k+1);
        if ($a - (int)$a == 0.0) 
           $count++; 
    }

    return $count;
}

