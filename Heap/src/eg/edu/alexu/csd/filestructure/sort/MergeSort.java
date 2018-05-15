/**
 *
 */
package eg.edu.alexu.csd.filestructure.sort;

import java.util.List;

/**
 * @author Personal
 * @param <T>
 *
 */
public class MergeSort<T extends Comparable<T>> {

	/**
	 * Sorts the given collection of
	 * elements using any O(nlogn) algorithm
	 * in-place
	 *
	 * @param left, right of list.
	 * @param unordered, aux lists.
	 */
	public void sort(final int left, final int right,
			final List<T> unordered, final List<T> aux) {

		if (left < right) {
			int mid = (left + right) / 2;
			sort(left, mid, unordered, aux);
			sort(mid + 1, right, unordered, aux);
			merge(left, mid, right, unordered, aux);
		}
	}
	/**
	 * merge lists
	 *
	 * @param left, right of list.
	 * @param unordered, aux lists.
	 */
	private void merge(final int lift, final int mid, final int right,
			final List<T> unordered, final List<T> aux) {
		int left = lift;
		int leftCounter = left;
		int rightCounter = mid + 1;

		for (int i = left; i <= right; i++) {
			aux.set(i, unordered.get(i));
		}

		while (leftCounter <= mid && rightCounter <= right) {
			if (aux.get(leftCounter).
					compareTo(aux.get(rightCounter)) <= 0) {
				unordered.set(left++, aux.get(leftCounter++));
			} else {
				unordered.set(left++, aux.get(rightCounter++));
			}
		}

		while (leftCounter <= mid) {
			unordered.set(left++, aux.get(leftCounter++));
		}

		while (rightCounter <= right) {
			unordered.set(left++, aux.get(rightCounter++));
		}
	}

}
