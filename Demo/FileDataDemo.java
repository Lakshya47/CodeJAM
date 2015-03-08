import fileHandler.*;
import java.io.IOException;
import reusableMethods.*;
import java.util.*;

public class FileDataDemo{
	
	public static void main(String [] args) throws IOException{
		
		String input_File_Name = "C:\\Users\\Nomad\\Desktop\\Google Code Challenge\\A-small-practice.in";
		String output_File_Name = "C:\\Users\\Nomad\\Desktop\\Google Code Challenge\\result.txt";
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

		
		List<String> testCase = testCases.getCase(4);
		
		CustomList customList = new CustomList(testCase.get(2));
		List<Integer> inputList = customList.getIntegerList();
		
		/*WriteFile writeFile = new WriteFile(output_File_Name);
		writeFile.writeContent(testCase);*/
		
		/*System.out.println(Integer.toString(inputList.size()));
		int i;
		for(i=0;i<inputList.size();i++){
			System.out.println(Integer.toString(inputList.get(i)));
		}*/
	}
}