import fileHandler.*;
import java.io.IOException;
import reusableMethods.*;
import java.util.*;

public class FileDataDemo{
	
	public static void main(String [] args) throws IOException{
		
		String file_Name = "C:\\Users\\Nomad\\Desktop\\Google Code Challenge\\A-small-practice.in";
		List<String> data = new ArrayList<String>();
		int number_Of_Test_Cases;
		int size_Of_Test_Case = 3;
		
		try{
			ReadFile file = new ReadFile(file_Name);
			data = file.OpenFile();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		
		number_Of_Test_Cases = Integer.parseInt(data.get(0));
		data.remove(0);
		TestCases testCases = new TestCases(data,number_Of_Test_Cases,size_Of_Test_Case);

		
		List<String> testCase = testCases.getCase(4);
		int i;
		for(i=0;i<testCase.size();i++){
			System.out.println(testCase.get(i));
		}
	}
}