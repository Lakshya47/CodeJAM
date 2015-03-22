package reusableMethods;
import java.util.*;

public class SortableList{
	List<Long> unsortedList = new ArrayList<Long>();
	List<Long> sortedList = new ArrayList<Long>();
	
	public SortableList(List<Long> list){
		unsortedList = list;
		sortList();
	}
	
	/*public SortableList(List<Integer> list){
		List<Long> tempList = new ArrayList<Long>();
		int i;
		for(i=0;i<list.size();i++){
			tempList.add(new Long(list.get(i)));
		}
		unsortedList = tempList;
		sortList();
	}*/
	
	public void printSortedAndUnSortedLists(){
		int i;
		System.out.println("Unsorted List");
		for(i=0;i<unsortedList.size();i++){
			System.out.print(" " + Long.toString(unsortedList.get(i)));
		}
		System.out.println("\nSorted List");
		for(i=0;i<sortedList.size();i++){
			System.out.print(" " + Long.toString(sortedList.get(i)));
		}
	}
	
	private void sortList(){
		if(unsortedList.size()<=10){
			System.out.println("\n\nUsing Bubble sort as array length is " + Integer.toString(unsortedList.size()));
			sortedList = bubbleSort(unsortedList);
		}else{
			System.out.println("\n\nUsing Quick sort as array length is " + Integer.toString(unsortedList.size()));
			sortedList = quickSort(unsortedList);
		}
	}
	
	private List<Long> bubbleSort(List<Long> list){
		List<Long> tempList = new ArrayList<Long>(list);
		int i,j;
		for(i=0;i<tempList.size();i++){
			for(j=1;j<(tempList.size()-i);j++){
				if(tempList.get(j-1)>tempList.get(j)){
					long temp = tempList.get(j-1);
					tempList.set(j-1,tempList.get(j));
					tempList.set(j,temp);
				}
			}
		}
		return tempList;
	}
	
	private List<Long> quickSort(List<Long> list){
		/*
		 * Todo - Change Implmenetation to real Quick Sort
		 * 
		 */
		List<Long> tempList = new ArrayList<Long>(list);
		int i,j;
		for(i=0;i<tempList.size();i++){
			for(j=1;j<(tempList.size()-i);j++){
				if(tempList.get(j-1)>tempList.get(j)){
					long temp = tempList.get(j-1);
					tempList.set(j-1,tempList.get(j));
					tempList.set(j,temp);
				}
			}
		}
		return tempList;
	}
	
	public List<Long> getSortedLongList(){
		return sortedList;
	}
}