//-- Approach 1

function solution(n, m) {
    return (
      1 <<
      (n ^ m)
        .toString(2)
        .split("")
        .reverse()
        .join("")
        .indexOf("1")
    );
  }

  
  function solution2(n, m)
  {
      var count = 1;
      var musk = 1;
      while ((musk & n) == (musk & m))
      {
        count++;
        musk <<= 1;
      }

      return count;
  }


  var n = 7;
  var m = 23;
  console.log(solution(n, m));