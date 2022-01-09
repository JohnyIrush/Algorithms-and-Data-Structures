<?php


function binarySearch($needle, $haystack, $start, $end) //-- O(LogN)
{
  if ($end >= $start)
  {
    $middle = floor($start + ($end - $start)/2);

    if ($haystack[$middle] === $needle ) 
        return $middle;

    if ($haystack[$middle] > $needle) 
        return binarySearch($needle, $haystack, $start, $middle - 1);

    return binarySearch($needle, $haystack, $middle + 1, $end);
  }

  return -1;
}

$haystack = [1,2,3,3,4,5,5, 10];

echo binarySearch(10, $haystack, 0, (count($haystack) - 1)); //-- Output 


/*
// PHP program to implement
// recursive Binary Search
 
// A recursive binary search
// function. It returns location
// of x in given array arr[l..r]
// is present, otherwise -1
function binarySearch($arr, $l, $r, $x)
{
if ($r >= $l)
{
        $mid = ceil($l + ($r - $l) / 2);
 
        // If the element is present
        // at the middle itself
        if ($arr[$mid] == $x)
            return floor($mid);
 
        // If element is smaller than
        // mid, then it can only be
        // present in left subarray
        if ($arr[$mid] > $x)
            return binarySearch($arr, $l,
                                $mid - 1, $x);
 
        // Else the element can only
        // be present in right subarray
        return binarySearch($arr, $mid + 1,
                            $r, $x);
}
 
// We reach here when element
// is not present in array
return -1;
}
 
// Driver Code
$arr = [1,2,4,5,5,3,3];//-- array(2, 3, 4, 40);
$n = count($arr);
$x = 10;
$result = binarySearch($arr, 0, $n - 1, $x);
if(($result == -1))
echo "Element is not present in array";
else
echo "Element is present at index ",
                            $result;
                             
// This code is contributed by anuj_67.
*/
?>