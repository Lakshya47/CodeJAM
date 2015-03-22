import fileHandler.*;
import java.io.IOException;
import reusableMethods.*;
import java.util.*;
import org.json.simple.JSONObject;

public class MSP{
	
	public static void main(String [] args) throws IOException{
		
		String input_File_Name = "Problems\\MSP-large-practice.in";
		String output_File_Name = "Problems\\MSP-large-practice-result.txt";
		List<String> data = new ArrayList<String>();
		int number_Of_Test_Cases;
		int size_Of_Test_Case = 3;
		
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
		
		WriteFile writeFile = new WriteFile(output_File_Name);
		writeFile.writeContent(outputList);
	}
}