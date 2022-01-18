function solution(coins, quantity)
{
    var sums = new Set();
    sums.add(0);
    
    for (let i = 0; i < coins.length; i++)
    {
        var next = new Set();

        sums.forEach (function(prev) {
            for (let j = 1; j <= quantity[i]; j++)
            {
                next.add(prev + (coins[i] * j));
            }
        });


        sums.add(next);
    }

    return sums.size - 1;
}
