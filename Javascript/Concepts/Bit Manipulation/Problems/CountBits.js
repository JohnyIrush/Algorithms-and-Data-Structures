var N = 5;
const array = [];

for (let i = 0; i <= N; i++)
{  
    array.push(countSetBits(i));
}

function countSetBits(Integer)
{
    var count = 0;

    while (Integer > 0)
    {
        count++;
        Integer = Integer & (Integer - 1);
    }
    return count;
}

console.log(array);