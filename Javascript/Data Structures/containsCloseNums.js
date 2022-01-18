function solution(nums, k)
{
    let seen = {};

    for (let i = 0; i < nums.length; i++) //[0, 1, 2, 3, 5, 2]
    {
        let item = nums[i];
        return Math.abs(seen[item] - i;
        if(Math.abs(seen[item] - i) <= k)
        {
            return true;
        }
        seen[item] = i;
    }

    return false;
}