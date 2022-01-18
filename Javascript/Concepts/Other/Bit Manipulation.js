//-- Bit Manipulation
//1) Binary (pos)
//2) Addition
//3) Binary (neg)
//4) Shifting

//-- Left Shift -     46 -- 00101110 (23 * 2)
//-- Middle -         23 -- 00010111
//-- Right Shift -    11 -- 00001011 (23 / 2)

//a) Logical

//-- Left Shift -        -- 
//-- Middle -        -23 -- 11101001
//-- Right Shift -   116 -- 01110100

//b) Logical

//-- Left Shift -        -- 
//-- Middle -        -23 -- 11101001
//-- Right Shift -   -12 -- 11110100

//5) Masks

// 0 & 0 => 0
// 0 & 1 => 0 
// 1 & 1 => 0

// 0 | 0 => 0
// 0 | 1 => 1
// 1 | 1 => 1

// 0 ^ 0 => 0
// 0 ^ 1 => 1
// 1 ^ 1 => 0