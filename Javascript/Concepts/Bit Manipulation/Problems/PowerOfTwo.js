var N = 8;

//-- Approach 1
/*
return (countSetBits(N) == 1)? console.log('true'): console.log('false');

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
*/

//-- Approach 2

((N & (N - 1)) == 0)? console.log("Power of 2") : console.log("Not Power of 2");
