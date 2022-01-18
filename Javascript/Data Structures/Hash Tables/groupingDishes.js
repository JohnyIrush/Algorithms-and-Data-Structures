
















function solution($strings, $patterns) {
    
    $match = array_combine($patterns,$strings);

return (sizeof($match) === sizeof(array_unique($match)) && sizeof(array_unique($strings)) === sizeof(array_unique($patterns)));



}



 /*
 
{
  "Tomato" : [Salad,Pizza, Sandwich],
  "Cucumber" : [Salad] ,
  "Sauce" : [Salad, Pizza,Quesadilla] ,
  "Sausage" : [Pizza] ,
  "Dough" : [Pizza] ,
  "Chicken" : [Quesadilla] ,
  "Cheese" : [Quesadilla, Sandwich] , 
  "Salad" : [Sandwich] ,
  "Bread" : [Sandwich] , 
}
 */
 
function solution(dishes) {

    let hash = {}
    //return hash;
    dishes.forEach((dish)=>{ // Loop through all dishes -> ing
        let name = dish[0] // Dish name
        //console.log(dish[0]);                           
        for(let i=1; i<dish.length; i++){
            if(!hash[dish[i]]){ // check if ingredient is already a key in hash
                hash[dish[i]]=[] // insert it as key then set array as its value
                hash[dish[i]].push(name) // push the dish as value of this key array
            }else{
                hash[dish[i]].push(name) // push the dish as value of this key array
            }
        }
    })
    
    
    //console.log(hash);
    return select(hash)
    
}


function select(hash){
    let selected = [] // Selected Ing
    
    for(const [Ingridient,dishes] of Object.entries(hash)){

        if(dishes.length>1){
            console.log(Ingridient);
            let arr = []
            arr.push(Ingridient)
            arr = arr.concat(dishes.sort()) // sort the dishes lexographically
            selected.push(arr)
        }
    }
    
    
    return selected.sort((a, b) => a[0] < b[0] ? -1 : a[0] === b[0] ? 0 : 1)
}


 console.log(solution(dishes));