<?php

function solution($strings, $patterns) {
    
    $match = array_combine($patterns,$strings);

return (sizeof($match) === sizeof(array_unique($match)) && sizeof(array_unique($strings)) === sizeof(array_unique($patterns))) && checkPattern($strings, $patterns);



}






function checkPattern($strings, $patterns)
{
    $dictionary = array_combine($patterns, $strings);
    $values = $strings;
    $keys = $patterns;

    for ($i = 0; $i < sizeof($values); $i++)
    { 
        $key = $keys[$i];
        $value = $values[$i];

        if($key !== array_search($value,$dictionary))
            return false;
    }

    return true;
}