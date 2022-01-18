
var  result = 0;

var array = [3,4,5];
var n = array.length;
var count;

for (let i = 0; i < array.length; i++)
{
    var count = (i) * (array.length - i + 1);
    if(count % 2) result ^= array[i];
}

console.log(result);