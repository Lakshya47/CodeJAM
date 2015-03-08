import fileHandler.*;
import java.io.IOException;
import reusableMethods.*;
import java.util.*;

public class ReverseWords{
	
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
	
	public static void main(String [] args) throws IOException{
		
		String input_File_Name = "Problems\\B-large-practice.in";
		String output_File_Name = "Problems\\B-large-practice-result.txt";
		List<String> data = new ArrayList<String>();
		int number_Of_Test_Cases;
		int size_Of_Test_Case = 1;
		
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
			ParsableList customList = new ParsableList(testCase.get(0));
			List<String> inputList = customList.getStringList();
			
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
		
		WriteFile writeFile = new WriteFile(output_File_Name);
		writeFile.writeContent(outputList);
	}
}