
function solution2(n)
{
var count  = 0;
while (n > 0)
{
    if(n & 1)
    {
        return count;
    }
    
    n >>= 1;
    count++;
}
}

n = 37;

console.log(solution2(36));