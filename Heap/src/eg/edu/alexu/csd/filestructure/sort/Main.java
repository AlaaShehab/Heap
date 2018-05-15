/**
 *
 */
package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;

/**
 * @author Personal
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Heap heap = new Heap();

		ArrayList<Integer> unordered = new ArrayList<Integer>();
		unordered.add(6);
		unordered.add(3);
		unordered.add(5);
		unordered.add(7);
		unordered.add(1);
		unordered.add(4);
		unordered.add(2);

//		List<Integer> a = unordered.subList(0, 1);
//		for (int i = 0; i < a.size(); i++) {
//			System.out.print(a.get(i) + " ");
//		}

		Sort s = new Sort();
		s.heapSort(unordered);





	}

}
