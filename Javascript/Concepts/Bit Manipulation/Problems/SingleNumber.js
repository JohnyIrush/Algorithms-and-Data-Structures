function singleNumber(array)
{
    N = array.length;

    var frequencies = [];

    for (let l = 0; l < 32; l++)
    {
        frequencies[l] = 0;
    }
    
    for (const value of array)
    {
        console.log(value);
        for (let i = 0; i < 32; i++)
        {
            if(value & (1 << i))
            {
                frequencies[i]++;
            }
        }

    }
    var result = 0;
    for (let k = 0; k < 32; k++)
    {
        if(frequencies[k] % 3 == 1)
          result += (1 << k);
    }
    

    return  result;
}

const array = [2,3,3];

console.log("single Number is: " + singleNumber(array));

//console.log(frequencies);