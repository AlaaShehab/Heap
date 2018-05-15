/**
 *
 */
package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
/**
 * @author Personal
 * @param <T>
 *
 */
public class Sort<T extends Comparable<T>> implements ISort<T> {

	/**
	 * Sorts the given collection
	 * of elements using heap-sort algorithm
	 * in-place, and returns a clone
	 * of the complete heap that you constructed
	 * during the sorting, and before
	 * you empty it. Runs in O(n lg n) time
	 *
	 * @param unordered
	 *            unordered elements.
	 * @return heap structure used.
	 */
	@Override
	public IHeap heapSort(final ArrayList unordered) {
		Heap heap = new Heap();
		heap.build(unordered);
		ArrayList temp = new ArrayList();
		int size = heap.size();
		while (size != 0) {
			temp.add(heap.extract());
			size--;
		}
		heap.build(temp);
		heap.swapAllHeap();
		return heap;
	}

	/**
	 * Sorts the given collection of.
	 * elements using any O(n^2) algorithm.
	 * in-place.
	 *
	 * @param unordered
	 *            unordered elements.
	 */
	@Override
	public void sortSlow(final ArrayList unordered) {
		int size = unordered.size();
		for (int i = 1; i < size; ++i) {
			int key = (Integer) unordered.get(i);
			int j = i - 1;

			while (j >= 0 && (Integer) unordered.get(j) > key) {
				unordered.set(j + 1, unordered.get(j));
				j = j - 1;
			}
			unordered.set(j + 1, key);
		}

	}
	/**
	 * Sorts the given collection of.
	 * elements using any O(n lg n) algorithm.
	 * in-place.
	 *
	 * @param unordered
	 *            unordered elements.
	 */
	@Override
	public void sortFast(final ArrayList<T> unordered) {
		MergeSort<T> sort = new MergeSort<T>();
		sort.sort(0, unordered.size() - 1,
				unordered, new ArrayList<T>(unordered));
	}

}
