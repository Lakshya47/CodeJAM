package reusableMethods;
import java.util.*;

public class ParsableList{
	List<String> dataList = new ArrayList<String>();
	
	public ParsableList(String str){
		String tempStr = str;
		String[] strArray = tempStr.split(" ");
		int i;
		for(i=0;i<strArray.length;i++){
			dataList.add(strArray[i]);
		}
	}
	
	public ParsableList(String str,String s){
		String tempStr = str;
		String[] strArray = tempStr.split(s);
		int i;
		for(i=0;i<strArray.length;i++){
			dataList.add(strArray[i]);
		}
	}
	
	public List<Integer> getIntegerList(){
		List<Integer> tempList = new ArrayList<Integer>();
		int i;
		for(i=0;i<dataList.size();i++){
			tempList.add(Integer.parseInt(dataList.get(i)));
		}
		return tempList;
	}
	
	public List<String> getStringList(){
		return dataList;
	}
	
	public String getSingleString(List<String> str){
		String temp = new String();
		int i;
		for(i=0;i<str.size();i++){
			temp = temp.concat(str.get(i));
			if(i != str.size()-1){
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
}

