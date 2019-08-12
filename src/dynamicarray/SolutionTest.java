package dynamicarray;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test0() {
		//   Input
		//     2 5
		//     1 0 5
		//     1 1 7
		//     1 0 3
		//     2 1 0
		//     2 1 1
		//   Expected Output
		//     7
		//     3
		//   Explanation
		//     Initial Values:
		//       N = 2
		//       lastAnswer = 0
		//       seq0 = []
		//       seq1 = []
		//     Query 0: Append 5 to sequence ((0 XOR 0) % 2) = 0.
		//       lastAnswer = 0
		//       seq0 = [5]
		//       seq1 = []
		//     Query 1: Append 7 to sequence ((1 XOR 0) % 2) = 1.
		//       lastAnswer = 0
		//       seq0 = [5]
		//       seq1 = [7]
		//     Query 2: Append 3 to sequence ((0 XOR 0) % 2) = 0.
		//       lastAnswer = 0
		//       seq0 = [5,3]
		//       seq1 = [7]
		//     Query 3: Assign the value at index 0 of sequence ((1 XOR 0) % 2) = 1 to lastAnswer,
		//       print lastAnswer.
		//       lastAnswer = 7
		//       seq0 = [5,3]
		//       seq1 = [7]
		//     Query 4: Assign the value at index 1 of sequence ((1 XOR 7) % 2) = 0 to lastAnswer,
		//       print lastAnswer.
		//       lastAnswer = 3
		//       seq0 = [5,3]
		//       seq1 = [7]
		
		// Input

		// Define the number of sequences
		Integer n = 2;
		// Define the number of queries
		Integer q = 5;
		// Create the query list
		List<List<Integer>> queries = new ArrayList<>();
		// Create query 0 and add to the query list
		String q0 = "1 0 5";
		queries.add(Stream.of(q0.split(" ")).map(Integer::parseInt).collect(toList()));
		// Create query 1 and add to the query list
		String q1 = "1 1 7";
		queries.add(Stream.of(q1.split(" ")).map(Integer::parseInt).collect(toList()));
		// Create query 2 and add to the query list
		String q2 = "1 0 3";
		queries.add(Stream.of(q2.split(" ")).map(Integer::parseInt).collect(toList()));
		// Create query 3 and add to the query list
		String q3 = "2 1 0";
		queries.add(Stream.of(q3.split(" ")).map(Integer::parseInt).collect(toList()));
		// Create query 4 and add to the query list
		String q4 = "2 1 1";
		queries.add(Stream.of(q4.split(" ")).map(Integer::parseInt).collect(toList()));
	
		// Display input queries
		//for (List l : queries) {
		//    System.out.println(l);
		//}
        
		// Expected result
		List<Integer> result = new ArrayList<>();
		result.add(7);
		result.add(3);

		// Run the Test
		assertEquals(Solution.dynamicArray(n, queries),result);
	}
	
}
