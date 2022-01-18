<?php
class ValidParenthesisString {

/**
 * @param String $s
 * @return Boolean
 */
function checkValidString($s) {
    if(strlen($s)%2 !== 0)
      return false;

    $stack = new SplStack();

    foreach(str_split($s) as $char) // {} () [] -> {() []}
    {
        if($char === "(" || $char === "{" || $char === "[" ) //["{"]  -> ["{",]
        {
            $stack->push($char);
        }
        else if($char === ")" && !$stack->isEmpty() && $stack->top() === "(")
        {
            $stack->pop();
        }
        else if($char === "}" && !$stack->isEmpty() && $stack->top() === "{")
        {
            $stack->pop();
        }
        else if($char === "]" && !$stack->isEmpty() && $stack->top() === "[")
        {
            $stack->pop();
        }
    }

    return $stack->isEmpty();
}
}