<?php
function solution($n)
{
    //1 ≤ n ≤ 104
    
    if(1 <= $n && $n <= pow(10,4))
    {
     $count = 0;
     if($n%2 == 0)
     {
         $pivot = floor($n/2);
         $numbers = range(1,$pivot, 1);
         countExpressions(0,$pivot,$numbers,$n, $count);
         return $count;
     }
     else
     {
         $pivot = floor($n/2) + 1;
         $numbers = range(1,$pivot, 1);
         countExpressions(0,$pivot,$numbers,$n, $count);
         return $count;
     }
    }
    
    return 0;
    
}

function countExpressions($start,$end, $numbers, $number, &$count)
{
    if($end > $start)
    {
        for($i = sizeof($numbers); $i > 0; $i--)
        {  
            
         $sum = (int)add($start,$i,$numbers);
         
         if($sum === (int)$number)
           $count = $count + 1;
           
         if($sum < (int)$number)
           break;
        }
        
        $start = $start + 1;
        
        countExpressions($start,$end, $numbers, $number, $count);
    }
    
    return $count;
}

function add($start,$end,$array)
{
    $arr = [];
        for($i = $start; $i < $end; $i++)
        { 
            array_push($arr,$array[$i]);
        }
        
    return array_sum($arr);
    
}
