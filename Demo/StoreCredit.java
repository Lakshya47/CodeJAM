import fileHandler.*;
import java.io.IOException;
import reusableMethods.*;
import java.util.*;

public class StoreCredit{
	
	public static void main(String [] args) throws IOException{
		
		String input_File_Name = "Problems\\StoreCredit-large-practice.in";
		String output_File_Name = "Problems\\StoreCredit-large-practice-result.txt";
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
			List<Integer> inputList = customList.getIntegerList(customList.getStringList(testCase.get(2)));
			
			int primaryIndex=0;
			int complementIndex=0;
			int Credit = Integer.parseInt(testCase.get(0));
			int length = Integer.parseInt(testCase.get(1));
			int i,j;
			
			System.out.println("Credit = " + Integer.toString(Credit));
			mainSearch:
			for(i=0;i<length;i++){
				int tempPrice = inputList.get(i);
				if(tempPrice<Credit){
					int complement = Credit-tempPrice;
					for(j=0;j<length;j++){
						if(i!=j){
							if(complement == inputList.get(j)){
								primaryIndex=i;
								complementIndex=j;
								System.out.println("Breaking out: i = " + Integer.toString(i) + ", j = " + Integer.toString(j));
								System.out.println(Integer.toString(inputList.get(i)) + " & " + Integer.toString(inputList.get(j)));
								break mainSearch;
							}
						}
					}
				}
			}
			
			String res = new String("Case #" + Integer.toString(caseCounter+1) + ": ");
			if(primaryIndex <= complementIndex){
				res = res.concat(Integer.toString(primaryIndex+1) + " " + Integer.toString(complementIndex+1));
			}else{
				res = res.concat(Integer.toString(complementIndex+1) + " " + Integer.toString(inputList.get(primaryIndex+1)));
			}
			outputList.add(res);
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