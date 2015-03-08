package reusableMethods;
import java.util.*;

public class TestCases{
	private int number_Of_Test_Cases;
	private int length_Of_Test_Case;
	private List<String> TestCasesList;
	
	public TestCases(List<String> list, int numberOfTestCases, int lengthOfTestCase){
		number_Of_Test_Cases = numberOfTestCases;
		length_Of_Test_Case = lengthOfTestCase;
		TestCasesList = list;
	}
	
	public List<String> getCase(int nCase){
		List<String> tempCase = new ArrayList<String>();
		int i;
		int index = length_Of_Test_Case*nCase;
		for(i=0;i<length_Of_Test_Case;i++){
			tempCase.add(TestCasesList.get(index+i));
		}
		return tempCase;
	}
}