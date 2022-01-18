<?php
function solution($l, $r)
{
    $count = 0;
    for ($i = $l ; $i <= $r; $i++)
    { 
        for ($j = $i + 1; $j <= $r; $j++)
        { 
            $a = sumDigits($i);
            $b = sumDigits($j);

            if($j >= ($i - $a) && $j <= ($i + $a) && $i >= ($j - $b) && $i<= ($j+$b))
            {
                $count++;
            }
        }
    }
    return $count;
}


function sumDigits($number)
{
    $sum = 0;
    while($number > 0)
    {
        $sum += ($number%10);
        $number = (int)($number/10);
    }
    
    return $sum;
}

