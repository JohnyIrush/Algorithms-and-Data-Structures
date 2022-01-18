<?php
class OrderlyQueue {

/**
 * @param String $s
 * @param Integer $k
 * @return String
 */
function orderlyQueue($s, $k)
{
    if($k = 0)
       return $s;
    else if($k > 1)
    {
        $charArr = str_split($s);
        sort($charArr);
        return join("",$charArr);
    }
    else if($k == 1)
    {
        $ans = $s;
        $reorderedStr = "";
        for ($i=1; $i < strlen($s); $i++)
        { 
            $reorderedStr = substr($s,$i,strlen($s) - $i) . substr($s,0,$i);
            if(strcmp($ans, $reorderedStr) > 0)
               $ans = $reorderedStr;     
        }
        return $ans;
    }

    return $s;
}



}