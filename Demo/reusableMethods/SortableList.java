/*
 * Author: Lakshya Chaudhary 
 */

package reusableMethods;
import java.util.*;

/*
 * Class  SortableList:-
 * 
 * This class sorts any ArrayList that is passed in its constructor.
 * Initially it uses Bubble sort if the List length is small but more sorting
 * algos can be used for bigger lists.
 */

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
	
	/*
	 * sortList() method checks the length of the Input list and
	 * then decides which algo to use. Any other test for complexities
	 * of given data can be checked here and then other appropriate algo can be used.
	 */
	
	private void sortList(){
		if(unsortedList.size()<=10){
			System.out.println("\n\nUsing Bubble sort as array length is " + Integer.toString(unsortedList.size()));
			sortedList = bubbleSort(unsortedList);
		}else{
			System.out.println("\n\nUsing Quick sort as array length is " + Integer.toString(unsortedList.size()));
			sortedList = quickSort(unsortedList);
		}
	}
	
	/*
	 * Below is simple bubble sort algo for sorting the given List
	 * Complexity: O(n^2)
	 */
	
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
	
	/*
	 * Below is Quick sort algo for sorting the given List
	 * Complexity: O(nlogn)
	 */
	
	private List<Long> quickSort(List<Long> list){
		/*
		 * Todo - Change Implmenetation to real Quick Sort.
		 * Currently the implmentation is bubble sort.
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