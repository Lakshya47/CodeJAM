/*
 * Author: Lakshya Chaudhary 
 */

package reusableMethods;
import java.util.*;

/*
 * Class ParsableList:-
 * 
 * A generic class for performing basic operations on String-Lists, Strings,
 * Integer-Lists, etc. For e.g:- Spliting a string into an ArrayList & Vice-versa,
 * Spliting a numeral string into an Interger List, etc.
 */

public class ParsableList{
	
	/*
	 * method getStringList().
	 * @param 1: space sepearated words.
	 * @param 2 (optional): string value to which split the input string from. 
	 * @return : List<String> that will be split spaces of input @param.
	 * 
	 */
	
	public List<String> getStringList(String str){
		List<String> tempList = new ArrayList<String>();
		String tempStr = str;
		String[] strArray = tempStr.split(" ");
		int i;
		for(i=0;i<strArray.length;i++){
			tempList.add(strArray[i]);
		}
		return tempList;
	}
	
	public List<String> getStringList(String str,String s){
		List<String> tempList = new ArrayList<String>();
		String tempStr = str;
		String[] strArray = tempStr.split(s);
		int i;
		for(i=0;i<strArray.length;i++){
			tempList.add(strArray[i]);
		}
		return tempList;
	}
	
	/*
	 * method getIntegerList().
	 * @param 1: space sepearated words.
	 * @return : List<Integer> that will be split from spaces in input @param and then each word will be converted to Integer.
	 * 
	 */
	
	
	public List<Integer> getIntegerList(List<String> list){
		List<Integer> tempList = new ArrayList<Integer>();
		int i;
		for(i=0;i<list.size();i++){
			tempList.add(Integer.parseInt(list.get(i)));
		}
		return tempList;
	}
	
	/*
	 * method getLongIntegerList().
	 * @param 1: space sepearated words.
	 * @return : List<Long> that will be split from spaces in input @param and then each word will be converted to long.
	 * 
	 */
	
	public List<Long> getLongIntegerList(List<String> list){
		List<Long> tempList = new ArrayList<Long>();
		int i;
		for(i=0;i<list.size();i++){
			tempList.add(Long.parseLong(list.get(i)));
		}
		return tempList;
	}
	
	/*
	 * method getFloatList().
	 * @param 1: space sepearated words.
	 * @return : List<Float> that will be split from spaces in input @param and then each word will be converted to float.
	 * 
	 */
	
	public List<Float> getFloatList(List<String> list){
		List<Float> tempList = new ArrayList<Float>();
		int i;
		for(i=0;i<list.size();i++){
			tempList.add(Float.parseFloat(list.get(i)));
		}
		return tempList;
	}
	
	/*
	 * method getSingleString().
	 * @param 1: List<String> containing different words.
	 * @param 2 (optional): String to seperate the concatenated result.
	 * @return: A single string which is a concatenation of all elements of @param. 
	 * 
	 */
	
	public String getSingleString(List<String> list){
		String temp = new String();
		int i;
		for(i=0;i<list.size();i++){
			temp = temp.concat(list.get(i));
			if(i != list.size()-1){
				temp = temp.concat(" ");
			}
		}
		return temp;
	}
	
	public String getSingleString(List<String> str, String seperator){
		String temp = new String();
		int i;
		for(i=0;i<str.size();i++){
			temp = temp.concat(str.get(i));
			if(i != str.size()-1){
				temp = temp.concat(seperator);
			}
		}
		return temp;
	}
	
	/*
	 * method getSumedList().
	 * @param: A List<Long> of long numbers.
	 * @return: long that is sum of all elements of @param.
	 * 
	 */
	
	public long getSumedList(List<Long> list){
		long result=0;
		int i;
		for(i=0;i<list.size();i++){
			result += list.get(i);
		}
		return result;
	}
}