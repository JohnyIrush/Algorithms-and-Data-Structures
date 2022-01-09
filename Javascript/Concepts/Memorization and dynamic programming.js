//-- Recursion

function fib(n)
{
    if (n <= 0) 
    {
       return 0; 
    }
    else if(n == 1)
    {
        return 1;
    }
    else
    {
        return fib(n-1) + fib(n-2)
    }

}

console.log(fib(9)); // 0,1,1,2,3,5,8,13,21