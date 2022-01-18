function minimumFlips(a, b, c)
{
    result = 0;

    for (let i = 0; i < 32; i++)
    {
       x = false, y = false, z = false; 

       if(a & (1 << i))
       x = true;

       if(b & (1 << i))
       y = true;

       if(c & (1 << i))
       z = true;

       if(z == false)
       {
           if(x == true && y == true)
           result += 2;
           else if(x == true || y == true)
           result++;
       }
       else
       {
           if(x == false && y == false)
           result++;
       }
    }

    return result;
}

var a = 2, b = 6, c = 5;
console.log("a: " + a + " -> "  + a.toString(2) + " " + "b: " + b + " -> "  + b.toString(2) + " " + "c: " + c + " -> "  + c.toString(2));

console.log("Minimum Number of Flips: " + minimumFlips(a, b, c));

console.log(1^1);