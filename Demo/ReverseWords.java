/*
 * Author: Lakshya Chaudhary 
 */

import fileHandler.*;
import java.io.IOException;
import reusableMethods.*;
import java.util.*;

/*
 * Class ReverseWords:-
 * 
 * For detailed explanation of problem, please visit:-
 * https://code.google.com/codejam/contest/351101/dashboard#s=p1
 * 
 * This class reverses any given sentence on the basis of word.
 * For e.g:- 
 * 
 * Input sentence:- This is a sentence for reversal
 * Output sentence:- reversal for sentence a is This
 */

public class ReverseWords{
	
	public static void main(String [] args) throws IOException{
		
		/*
		 * **************************************************************
		 * **************************************************************
		 * Specify the Input File location and Output File location below
		 * **************************************************************
		 * **************************************************************
		 */
		
		String input_File_Name = "Problems\\ReverseWords-large-practice.in";
		String output_File_Name = "Problems\\ReverseWords-large-practice-result.txt";
		
		/*
		 * **************************************************************
		 * **************************************************************
		 */
		
		List<String> data = new ArrayList<String>();
		int number_Of_Test_Cases;
		int size_Of_Test_Case = 1;
		
		//Below I am using the ReadFile class to read the Input file and getting a String ArrayList
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
			List<String> inputList = customList.getStringList(testCase.get(0));
			
			List<String> tempList = new ArrayList<String>();
			
			if(inputList.size()%2 == 0){
				tempList = reverseEvenList(inputList);
			}else{
				int middleIndex = (inputList.size()-1)/2;
				String tempMiddleString = inputList.get(middleIndex);
				inputList.remove(middleIndex);
				tempList = reverseEvenList(inputList);
				tempList.add(middleIndex,tempMiddleString);
			}
			outputList.add("Case #" + (caseCounter+1) + ": " + customList.getSingleString(tempList));
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
	
	/*
	 * reverseEvenList() reverses any sentence of even word length by exchanging
	 * the 'i' element with 'N-i' element of array where N is the length of the array.
	 * 
	 * For reversing sentence with odd word length:-
	 * 1. Remove the middle element from array.
	 * 2. Reverse the array using reverseEvenList().
	 * 3. Push the removed word back again in the middle of the array. 
	 */
	
	static List<String> reverseEvenList(List<String> strList){
		List<String> tempList = strList;
		int tempLength = tempList.size()-1;
		int i;
		for(i=0;i<(tempList.size()/2);i++){
			String tempStr = tempList.get(i);
			tempList.set(i,tempList.get(tempLength-i));
			tempList.set(tempLength-i,tempStr);
		}
		return tempList;
	}
}