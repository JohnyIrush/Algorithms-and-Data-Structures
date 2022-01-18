<?php

$str ="abdc";
$pairs =[[1,4], 
         [3,4]];

function solution($str, $pairs)
{
    $map = [];

    for ($i=0; $i < sizeof($pairs); $i++)
    { 
        $u = $pairs[$i][0];
        $v = $pairs[$i][1];

        (is_array($map[$u]) && sizeof($map[$u]) > 0)? array_push($map[$u], $v): $map[$u] = [$v];
        (is_array($map[$v]) && sizeof($map[$v]) > 0)? array_push($map[$v], $u): $map[$v] = [$u];
    }

    $css = [];
    $visited = array_fill(0,strlen($str) - 1, false);

    foreach ($map as $key => $value)
    {
        if (!$visited[$key])
        {
            $visited[$key] = true;
            $current = [];
            array_push($current,$key);
            dfs($map, $key, $visited, $current);
            array_push($css, $current);
        }
    }
    
    # print_r($map);

    # print_r($css);

    $ans = str_split($str);

    foreach ($css as $key => $set)
    {
        $ordered = [];
        $nodes = $set;

        for ($i=0; $i < sizeof($nodes); $i++)
        { 
            array_push($ordered, $str[$i]);
        }
        sort($ordered);
        array_reverse($ordered);

        for ($i=0; $i < sizeof($nodes); $i++)
        { 
            $ans[$nodes[$i] - 1] = $ordered[$i];
        }
    }

    return join("",$ans);
}

function dfs($map, $u, &$visited, &$current)
{
    foreach ($map[$u] as $key => $node)
    {
        if (!$visited[$node])
        {
            $visited[$node] = true;
            array_push($current,$node);
            dfs($map, $node, $visited, $current);
        }
    }
}
solution($str, $pairs);