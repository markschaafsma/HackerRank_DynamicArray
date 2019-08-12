# HackerRank_DynamicArray

### Overview

This repository contains my Java SE 8 solution to the HackerRank problem [Dynamic Array](https://www.hackerrank.com/challenges/dynamic-array/problem).

### Problem 

Create a list, 'seqList', of N empty sequences, where each sequence is indexed from 0 to N-1.
The elements within each of the N sequences also use 0-indexing.
 
Create an integer, 'lastAnswer', and initialize it to 0.
 
The two types of queries that can be performed on the list of sequences (seqList) are:
  
      1) Query: 1 x y
    
         1. Find the sequence, 'seq', at index ((x Bitwise XOR lastAnswer) % N) in 'seqList'.
         2. Append integer y to sequence 'seq'.
      
      2) Query: 2 x y
    
         1. Find the sequence, 'seq', at index (( x Bitwise XOR lastAnswer) % N) in 'seqList'.
         2. Find the value of element y % size in 'seq' (where 'size' is the size of 'seq') and
            assign it to 'lastAnswer'.
         3. Print the new value of 'lastAnswer' on a new line.
      
### Task
 
Given N, Q, and then the Q queries, execute each query.
  
### Note

The bitwise XOR operation corresponds to the ^ operator in most languages.
  
### Input Format
 
The first line contains two space-separated integers, N (the number of sequences) and Q (the 
number of queries), respectively.

Each of the Q subsequent lines contains a query in the format defined above.
  
### Constraints
 
   - 1 <= N, Q <= 10 pow 5
   - 0 <= x, y <= 10 pow 9
   - It is guaranteed that query type 2 will never query an empty sequence or index.
 
### Output Format
 
For each type 2 query, print the updated value of lastAnswer on a new line.

### Testcases

   - Testcase 0
	    - Input
	      -  2 5
		    -  1 0 5
		    -  1 1 7
		    -  1 0 3
		    -  2 1 0
		    -  2 1 1
	    - Expected Output
	      -  7
		    -  3
