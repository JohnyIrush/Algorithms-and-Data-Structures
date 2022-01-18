 var array = [1,3,2,5,5,6,7];
 var n = array.length;

 var result = 0;

 for (let i = 1; i <= array.length; i++) result = result ^ array[i];
 for (let i = 1; i <= array.length; i++) result = result ^ i;

 var setBit = result & ~(result - 1);

 var L = 0, R = 0;

 for (let i = 1; i <= array.length; i++) 
 {
     if(array[i] & setBit)
     {
         L = L^array[i];
     }
     else
     {
         R = R ^ array[i];
     }
 }

 /*
 var N = 7;
 var N2 = N & ~(N - 1);
 var N3 = ~(N - 1);

 console.log(N.toString(2));
 console.log(N3.toString(2));
 console.log(N3);
 */
var missing;
(array.find(L) == L) ? missing = R : missing = L;
 console.log("Missing is: " + missing);
 console.log("Reapiting is: " + (missing == L )? R: L );


  