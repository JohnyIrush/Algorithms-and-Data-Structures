//-- Solve in O(N)

var array = [2,4,1];
var result = 0;

//-- O(N2)
/*
for (let i = 1; i < array.length; i++)
{
    for (let j = 1; j < array.length; j++)
    {
         result ^=  array[i] + array[j];
    }
}
*/

//-- O(N)

for (let j = 0; j < array.length; j++)
{
     result ^=  array[j] * 2;
}

console.log(result);
