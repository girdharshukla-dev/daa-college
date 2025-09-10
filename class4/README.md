Lab 4: Comparing Methods for Finding Minimum and Maximum in an Array
Due August 22, 2025 11:59 PM
Instructions
Objective 

The goal of this lab is to: 

Implement two different algorithms to find the minimum and maximum element in an array: 
Method 1: Linear traversal of the array. 
Method 2: Divide and Conquer approach. 
Compare the number of operations performed by each method for different input sizes. 
Analyze the Time Complexities of the 2 methods. 

Some notes for understanding Method 2: 

We don’t want to just scan the whole array with a simple loop (that’s the brute-force O(n) approach). 
Instead, we’ll split the problem into smaller problems and combine results. 
 

The Idea (Intuition) 

Split the array into two halves. 
Recursively find: 
Max in the left half. 
Max in the right half. 
Min in the left half. 
Min in the right half. 
Combine: 
Overall max = larger of the two max values. 
Overall min = smaller of the two min values. 
Base Cases 

Stop recursion when: 

One element → both min and max are that element. 
Two elements → directly compare them. 