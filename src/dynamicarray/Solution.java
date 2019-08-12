package dynamicarray;

/**
 * Problem 
 *
 *  Create a list, 'seqList', of N empty sequences, where each sequence is indexed from 0 to N-1.
 *  The elements within each of the N sequences also use 0-indexing.
 *  
 *  Create an integer, 'lastAnswer', and initialize it to 0.
 *  
 *  Two types of queries can be performed on your list of sequences (seqList) are:
 *  
 *    Query: 1 x y
 *    
 *      1. Find the sequence, 'seq', at index ((x Bitwise XOR lastAnswer) % N) in 'seqList'.
 *      2. Append integer y to sequence 'seq'.
 *      
 *    Query: 2 x y
 *    
 *      1. Find the sequence, 'seq', at index (( x Bitwise XOR lastAnswer) % N) in 'seqList'.
 *      2. Find the value of element y % size in 'seq' (where 'size' is the size of 'seq') and
 *         assign it to 'lastAnswer'.
 *      3. Print the new value of 'lastAnswer' on a new line.
 *      
 * Task
 * 
 *  Given N,Q and then the Q queries, execute each query.
 *  
 *  Note: + is the bitwise XOR operation, which corresponds to the ^ operator in most languages.
 *  
 * Input Format
 * 
 *  The first line contains two space-separated integers, N (the number of sequences) and Q (the 
 *  number of queries), respectively.
 *  Each of the Q subsequent lines contains a query in the format defined above.
 *  
 * Constraints
 * 
 *  - 1 <= N, Q <= 10 pow 5
 *  - 0 <= x, y <= 10 pow 9
 *  - It is guaranteed that query type 2 will never query an empty sequence or index.
 * 
 * Output Format
 * 
 *  For each type 2 query, print the updated value of lastAnswer on a new line.
 */

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

	// Complete the dynamicArray function below.
	static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {

		//  Create the list, 'seqList', of n empty sequences.
		List<List<Integer>> seqList = new ArrayList<>(n);
    	
		// Create the initial list, 'seq', for each element in 'seqList'.
		for (int i = 0; i < n; i++) {
			List<Integer> seq = new ArrayList<>();
			seqList.add(seq);
		}
    	
		// Keep track of the lastAnswer
		int lastAnswer = 0;
    	
		// Keep track of the results
		List<Integer> result = new ArrayList<>();

		//Process queries
		for (int i = 0; i < queries.size(); i++) {
			// Get the query
			List<Integer> query = queries.get(i);
			// Find the seq row to process from the seqList
			// (using the bitwise XOR and remainder operators)
			int seq = ((query.get(1) ^ lastAnswer) % n);
			// Check if query type 1
			if (query.get(0) == 1) {
				// Append integer (index=2) to the seq row (ArrayList)
				seqList.get(seq).add(query.get(2));
			}
			// Check if query type 2
			if (query.get(0) == 2) {
				// Find the integer value of element ((index=2) % size) in the seq row
				int element = query.get(2) % seqList.get(seq).size();
				lastAnswer = seqList.get(seq).get(element);
				System.out.println(lastAnswer);
				result.add(lastAnswer); 
			}
		}
    	
		return result; 
	}
    

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("result.txt"));

		String[] nq = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(nq[0]);

		int q = Integer.parseInt(nq[1]);

		List<List<Integer>> queries = new ArrayList<>();

		IntStream.range(0, q).forEach(i -> {
			try {
				queries.add(
					Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt)
						.collect(toList())
				);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		List<Integer> result = dynamicArray(n, queries);

		bufferedWriter.write(
			result.stream()
				.map(Object::toString)
				.collect(joining("\n"))
			+ "\n"
		);

		bufferedReader.close();
		bufferedWriter.close();
	}
}
