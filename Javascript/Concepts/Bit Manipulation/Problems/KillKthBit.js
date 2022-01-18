function solution(n, k) {
    return n & ~(1 << (k - 1));
  }

var k = 3;
var n = 37;

console.log((1 << (k - 1)));
  console.log(~(1 << (k - 1)).toString(2));
  console.log(n);
  console.log(n.toString(2));
  console.log((n & ~(1 << (k - 1))).toString(2));