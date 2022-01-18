// Solve in O(1)

function xorQueries(array, queries)
{
    var N = array.length;
    var prefix = [];
    prefix[0] = array[0];

    for (let i = 1; i < array.length; i++) // [1,2,3] [1,1^2,2^3]
    {
        prefix[i] = prefix[i - 1] ^ array[i]; 

        var result = [];

        for (let j = 0; j < queries.length; j++) // [[0,1],[1,2]]
        {
            var L = queries[j][0];
            var R = queries[j][1];

            if(L == 0) result.push(prefix[R]);
            else
            result.push(prefix[R] ^ prefix[L - 1]);
        }
    }

    return [prefix, result];
}
const queries = [[0,1],[1,2],[0,3],[3,3]];
const array = [1,3,4,8];
// [1,2,6,14]
//console.log(xorQueries(array, queries));

console.log(14^6);