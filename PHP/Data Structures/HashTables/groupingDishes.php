<?php
function solution($dishes)
{
    $hash = [];

    foreach ($dishes as $key => $ingridients)
    {

        for ($j=1; $j < sizeof($ingridients); $j++)
        { 
            array_push($hash,$ingridients[$j]);
        }

        array_fill_keys($hash,[]);
        print_r($hash);
        $dish = $ingridients[0];

        for ($i=1; $i < sizeof($ingridients); $i++)
        { 
            if(!array_key_exists($ingridients[$i],$hash))
            {
                $hash[$ingridients[$i]] = [$dish];
            }
            else
            {
                array_push($hash[$ingridients[$i]], $dish);
            }
        }

    }

    return select($hash);
}


function select($hash)
{
    $result = [];
    foreach ($hash as $ingridient => $dish)
    {
        if(is_array($dish) && sizeof($dish) > 1)
        {
            $arr = [$ingridient];
            sort($dish);
            for ($i=0; $i < sizeof($dish); $i++)
            { 
                array_push($arr,$dish[$i]);
            }

            array_push($result, $arr);
        }
    }

    //ksort($result);

    return array_reverse($result);
}

$dishes = 
[["Salad","Tomato","Cucumber","Salad","Sauce"], 
 ["Pizza","Tomato","Sausage","Sauce","Dough"], 
 ["Quesadilla","Chicken","Cheese","Sauce"], 
 ["Sandwich","Salad","Bread","Tomato","Cheese"]];

 print_r(solution($dishes));