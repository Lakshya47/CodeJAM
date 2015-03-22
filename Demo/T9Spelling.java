import fileHandler.*;
import java.io.IOException;
import reusableMethods.*;
import java.util.*;
import org.json.simple.JSONObject;

public class T9Spelling{
	
	public static void main(String [] args) throws IOException{
		
		String input_File_Name = "Problems\\T9Spelling-large-practice.in";
		String output_File_Name = "Problems\\T9Spelling-large-practice-result.txt";
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
		
		HashMap obj = new HashMap();

	      obj.put("a", "2");
	      obj.put("b", "22");
	      obj.put("c", "222");
	      obj.put("d", "3");
	      obj.put("e", "33");
	      obj.put("f", "333");
	      obj.put("g", "4");
	      obj.put("h", "44");
	      obj.put("i", "444");
	      obj.put("j", "5");
	      obj.put("k", "55");
	      obj.put("l", "555");
	      obj.put("m", "6");
	      obj.put("n", "66");
	      obj.put("o", "666");
	      obj.put("p", "7");
	      obj.put("q", "77");
	      obj.put("r", "777");
	      obj.put("s", "7777");
	      obj.put("t", "8");
	      obj.put("u", "88");
	      obj.put("v", "888");
	      obj.put("w", "9");
	      obj.put("x", "99");
	      obj.put("y", "999");
	      obj.put("z", "9999");
	      obj.put(" ", "0");
	      
	   HashMap obj2 = new HashMap();
	   
	   	  obj2.put("a", "2");
	      obj2.put("b", "2");
	      obj2.put("c", "2");
	      obj2.put("d", "3");
	      obj2.put("e", "3");
	      obj2.put("f", "3");
	      obj2.put("g", "4");
	      obj2.put("h", "4");
	      obj2.put("i", "4");
	      obj2.put("j", "5");
	      obj2.put("k", "5");
	      obj2.put("l", "5");
	      obj2.put("m", "6");
	      obj2.put("n", "6");
	      obj2.put("o", "6");
	      obj2.put("p", "7");
	      obj2.put("q", "7");
	      obj2.put("r", "7");
	      obj2.put("s", "7");
	      obj2.put("t", "8");
	      obj2.put("u", "8");
	      obj2.put("v", "8");
	      obj2.put("w", "9");
	      obj2.put("x", "9");
	      obj2.put("y", "9");
	      obj2.put("z", "9");
		
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
			String caseString = testCase.get(0);
			String tempResult = new String();
			
			int i;
			for(i=0;i<caseString.length();i++){
				if(i>0 && obj2.get(String.valueOf(caseString.charAt(i)))==obj2.get(String.valueOf(caseString.charAt(i-1)))){
					tempResult = tempResult.concat(" ");
				}
				tempResult = tempResult.concat((String)obj.get(String.valueOf(caseString.charAt(i))));
				//System.out.println((String)obj.get(String.valueOf(caseString.charAt(i))));
			}
			
			outputList.add("Case #" + (caseCounter+1) + ": " + tempResult);
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