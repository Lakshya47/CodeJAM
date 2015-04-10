/*
 * Author: Lakshya Chaudhary 
 */

package reusableMethods;
import java.util.*;

/*
 * Class TestCases:-
 * 
 * Constructor argument desc:-
 * @param1: List<String> that contains the Input file data.
 * @param2: The total number of test cases present in the Input file.
 * @param3: length of each test case.
 * 
 * NOTE: This class is of no use if each test case is of different length. 
 */

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