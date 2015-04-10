/*
 * Author: Lakshya Chaudhary 
 */

import fileHandler.*;
import java.io.IOException;
import reusableMethods.*;
import java.util.*;

/*
 * Class MSP:-
 * 
 * For detailed explanation of problem, please visit:-
 * https://code.google.com/codejam/contest/32016/dashboard#s=p0
 * 
 * PROBLEM:-
 * Acronym for Minimum Scalar Product - MSP
 * To vectors are given of equal size. We have to multiply 'i' component
 * of first vector with 'j' component of second vector such that
 * sum of all i x j is minimum.
 * 
 * This can be perceived more clearly if we consider two arrays of equal length and
 * multiply 'i' element of first array with 'j' element of second array such that
 * sum of all multiplication is minimum.
 * 
 * SOLUTION:-
 * 1. Sort both arrays.
 * 2. Multiply smallest element of first array with largest element of second array.
 * 3. The sum of all these products will always be minimum.
 * 
 * Below is the implmentation of above solution using array list.
 */

public class MSP{
	
	public static void main(String [] args) throws IOException{
		
		/*
		 * **************************************************************
		 * **************************************************************
		 * Specify the Input File location and Output File location below
		 * **************************************************************
		 * **************************************************************
		 */
		
		String input_File_Name = "Problems\\MSP-large-practice.in";
		String output_File_Name = "Problems\\MSP-large-practice-result.txt";
		
		/*
		 * **************************************************************
		 * **************************************************************
		 */
		
		List<String> data = new ArrayList<String>();
		int number_Of_Test_Cases;
		int size_Of_Test_Case = 3;
		
		// Below I am using the ReadFile class to read the Input file and getting a String ArrayList
		try{
			ReadFile file = new ReadFile(input_File_Name);
			data = file.OpenFile();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		
		number_Of_Test_Cases = Integer.parseInt(data.get(0));
		data.remove(0);
		TestCases testCases = new TestCases(data,number_Of_Test_Cases,size_Of_Test_Case);

		
		int caseCounter;
		List<String> outputList = new ArrayList<String>();
		
		
		/*
		 * Test case counter started,
		 * The folowing loop iterates over all the test cases one by one
		 * 
		 */
		
		for(caseCounter=0;caseCounter<number_Of_Test_Cases;caseCounter++){
			
			List<String> testCase = testCases.getCase(caseCounter);
			ParsableList customList = new ParsableList();
			
			List<Long> vector1 = customList.getLongIntegerList(customList.getStringList(testCase.get(1)));
			List<Long> vector2 = customList.getLongIntegerList(customList.getStringList(testCase.get(2)));
			
			SortableList sortedVector1 = new SortableList(vector1);
			vector1 = sortedVector1.getSortedLongList();
			SortableList sortedVector2 = new SortableList(vector2);
			vector2 = sortedVector2.getSortedLongList();
			
			int i;
			List<Long> tempResult = new ArrayList<Long>();
			for(i=0;i<vector1.size();i++){
				tempResult.add(vector1.get(i) * vector2.get(vector2.size()-i-1));
			}
			
			long result = customList.getSumedList(tempResult);
			System.out.println(Long.toString(result));
			
			/*int i;
			for(i=0;i<vector1.size();i++){
				System.out.println(Long.toString(vector1.get(i)));
			}*/
			
			outputList.add("Case #" + (caseCounter+1) + ": " + Long.toString(result));
		}	
		System.out.println(Integer.toString(outputList.size()));
		int i;
		for(i=0;i<outputList.size();i++){
			System.out.println(outputList.get(i));
		}
		
		//Below I am using the WriteFile class to write the solution line by line into an output file.
		WriteFile writeFile = new WriteFile(output_File_Name);
		writeFile.writeContent(outputList);
	}
}