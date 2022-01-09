class Solution:
    def findKthLargest(self, numbers: List[int], k: int)
    /*Brute force
    numbers.sort()
    return numbers[len(nums) - k]
    */
    k = len(numbers) - k
    def quickSelect(l, r)
    pivot, p = numbers[r], l
    for i in range(l, r)
    if numbers[i] <= pivot
       numbers[p], numbers[i] = numbers[i], numbers[p]
       p += 1 
    numbers[p] = pivot       