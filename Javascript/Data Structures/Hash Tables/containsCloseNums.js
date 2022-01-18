function solution(nums, k)
{
    let seen = {};

    for (let i = 0; i < nums.length; i++) //[0, 1, 2, 3, 5, 2]
    {
        let item = nums[i]; // item 0, 1, 2, 3, 2

        if(Math.abs(seen[item] - i) <= k) // false, false, false , false, false, 
        {
            return true;
        }
        seen[item] = i; //["0" : 0, "1" : 1, "2" : 2, "3" : 3, "5" : 4]
    }

    return false;
}

const nums = [0, 1, 2, 3, 5, 2];
var k = 3;

console.log(solution(nums, k));