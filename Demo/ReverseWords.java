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
		
		String input_File_Name = "Problems\\B-small-practice.in";
		String output_File_Name = "Problems\\B-small-practice-result.txt";
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
		
		for(caseCounter=4;caseCounter<5;caseCounter++){
			
			List<String> testCase = testCases.getCase(caseCounter);
			CustomList customList = new CustomList(testCase.get(0));
			List<String> inputList = customList.getStringList();
			
			outputList = reverseEvenList(inputList);
		}
		
		System.out.println(Integer.toString(outputList.size()));
		int i;
		for(i=0;i<outputList.size();i++){
			System.out.println(outputList.get(i));
		}
		
		/*WriteFile writeFile = new WriteFile(output_File_Name);
		writeFile.writeContent(outputList);*/
		
	}
}