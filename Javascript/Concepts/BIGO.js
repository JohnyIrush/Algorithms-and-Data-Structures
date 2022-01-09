//-- O(N)
function contains(arr, x)
{
    arr.forEach(element => {
        if(element == x)
        {
            return true;
        }
    });
} 

//-- O(N2)

printPairs(arr)
{
    for(x in arr)
    {
     for(y in arr)
     {
         console.log(x, y);
     }   
    }  
}


//Rules
//1) Different steps get added

function something(a, b) // O(a+b)
{
    a.forEach(element => {
        console.log(); // O(a)
    });

    b.forEach(element => {
        console.log(); // O(b)
    });
}

//2) Drop Constants

function minMax1(array) // O(N)
{
    var min, max = null;
    
    array.forEach(element => { // O(N)
        min = Math.min(element, min);
    });

    array.forEach(element => { // O(N)
        max = Math.max(element, max);
    });
}


function minMax2(array) // O(N)
{
    var min, max = null;
    
    array.forEach(element => {
        min = Math.min(element, min);
        max = Math.max(element, max);
    });
}


//3) Different inputs -> Different Variables

function intersectionSize(arrayA, arrayB) // O(a*b)
{
    var count = 0;
    
    arrayA.forEach(a => { //
        array.forEach(b => { //
           if (a == b) {
               count++;
           }
        }); 
    });
    return count;
}

//4) Drop Non dominant terms

function whyWouldIDoThis(array) // O(N2)
{
    var max = null;
    
    array.forEach(a => { // O(N)
        max = Math.max(a, max);
    });

    console.log(max);

    array.forEach(a => { // O(N2)
     array.forEach(b => {
         console.log(a, b);
     });   
    }); 
}