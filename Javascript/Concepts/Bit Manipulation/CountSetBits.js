var N = 11;
console.log(N.toString(2));

var count = 0;

//-- Approach 
/*
while(N > 0)
{
    if((N & 1) > 0)
    count++;

    N = N >> 1;
}

console.log("Number of Set Bits: " + count);
*/
//-- Approach 2

while(N > 0)
{
    count++;

    N = N & (N - 1);
}

console.log("Number of Set Bits: " + count);