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
		}else if(unsortedList.size()>10 && unsortedList.size()<=100){
			System.out.println("\n\nUsing Quick sort as array length is " + Integer.toString(unsortedList.size()));
			sortedList = quickSort(unsortedList);
		}else{
			System.out.println("\n\nUsing Merge sort as array length is " + Integer.toString(unsortedList.size()));
			sortedList = mergeSort(unsortedList);
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
	 * Complexity: average O(nlog(n)) & worst O(n2)
	 */
	
	private List<Long> quickSort(List<Long> list){
		List<Long> tempList = new ArrayList<Long>(list);
		quick(tempList,0,tempList.size()-1);
		return tempList;
	}
	
	void quick(List<Long> a,int l,int r){
		if(l<r){
			int pi = partition(a,l,r);
			quick(a,l,pi-1);
			quick(a,pi+1,r);
		}
	}
	
	int partition(List<Long> a,int l,int r){
		int i,j;
		i=l;
		for(j=l;j<r;j++){
			if(a.get(j)<=a.get(r)){
				swap(a,i,j);
				i++;
			}
		}
		swap(a,i,r);
		return i;
	}
	
	void swap(List<Long> a,int i,int j){
		long temp;
		temp = a.get(i);
		a.set(i,a.get(j));
		a.set(j,temp);
	}
	
	/*
	 * Below is merge sort algo for sorting the given List
	 * Complexity: O(nlog(n))
	 */
	
	private List<Long> mergeSort(List<Long> list){
		List<Long> tempList = new ArrayList<Long>(list);
		ms(tempList,0,list.size()-1);
		return tempList;
	}
	
	void ms(List<Long> l,int p,int r){
		if(p<r){
			int q=(p+r)/2;
			ms(l,p,q);
			ms(l,q+1,r);
			m(l,p,q,r);
		}
	}
	
	void m(List<Long> l,int p,int q,int r){
		List<Long> l1 = new ArrayList<Long>(l.subList(p,q+1));
		List<Long> l2 = new ArrayList<Long>(l.subList(q+1,r+1));
		long big = 99999999;
		l1.add(big);
		l2.add(big);
		int i,j;
		i=j=0;
		for(int k=p;k<=r;k++){
			if(l1.get(i)<=l2.get(j)){
				l.set(k,l1.get(i));
				i++;
			}else{
				l.set(k,l2.get(j));
				j++;
			}
		}
	}
	
	public List<Long> getSortedLongList(){
		return sortedList;
	}
}