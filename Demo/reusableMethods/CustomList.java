package reusableMethods;
import java.util.*;

public class CustomList{
	List<String> dataList = new ArrayList<String>();
	
	public CustomList(String str){
		String tempStr = str;
		String[] strArray = tempStr.split(" ");
		int i;
		for(i=0;i<strArray.length;i++){
			dataList.add(strArray[i]);
		}
	}
	
	public CustomList(String str,String s){
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
}