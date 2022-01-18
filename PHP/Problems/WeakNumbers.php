<?php

function solution($n, $weakness = [])
{
    if($n != 1 && sizeof($weakness) == 0)
        $weakness = array_fill(0,$n-1,0);

    if($n == 1 && sizeof($weakness) == 0)
       return [0, 1];
    else if($n == 0 || $n < 0)
       return answer($weakness);
       
    $weakness[$n - 1] = divisors($n - 1);

    return solution($n - 2,$weakness);
}


function divisors($number)
{
    $count = 0;
    for ($i = 2; $i  < $number - 1; $i ++)
    { 
        if($number%$i == 0)
          $count++;
    }

    return $count;
}

function answer($weakness)
{
    return $weakness;
    $weakest = max($weakness);

    $counts = array_count_values($weakness);

    return [$weakest,$counts[$weakest]];
}


print_r(solution(500));