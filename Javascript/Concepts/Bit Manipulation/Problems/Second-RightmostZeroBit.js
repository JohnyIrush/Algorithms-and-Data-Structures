//-- Approach 1

function solution(n)
{
    return (1 << (n.toString(2).length - n.toString(2).lastIndexOf("0", n.toString(2).lastIndexOf("0") - 1) - 1));
}

var n = 4;

var nb = n.toString(2);

console.log(nb);

console.log(n.toString(2).lastIndexOf("0", n.toString(2).lastIndexOf("0") - 1));
  

