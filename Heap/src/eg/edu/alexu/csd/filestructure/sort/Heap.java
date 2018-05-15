/**
 *
 */
package eg.edu.alexu.csd.filestructure.sort;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author Personal
 *
 */
public class Heap implements IHeap {
	/**
	 * elements of the heap.
	 *
	 */
	private Node[] elements;
	/**
	 * heap size.
	 *
	 */
	private int heapSize;
	/**
	 * the max allowed size.
	 *
	 */
	private final int maxSIZE = 1000000;

	/**
	 * heap constructor.
	 */
	public Heap() {
		elements = new Node[maxSIZE];
		heapSize = 0;
	}

	/**
	 * Return the root of the underlying binary tree
	 *
	 * @return INode wrapper for
	 * the root element of the tree
	 */
	@Override
	public INode getRoot() {
		if (heapSize == 0) {
			return null;
		}
		return elements[0];
	}

	/**
	 * Returns the number of elements in the tree
	 *
	 * @return Number of actual elements in the tree
	 */
	@Override
	public int size() {
		return heapSize;
	}

	/**
	 * Runs in O(lg n) time, is the key to
	 * maintaining the max-heap property.
	 *
	 * @param heap
	 *            the reference to the tree to be heapified
	 */
	@Override
	public void heapify(final INode node) {
		if (node == null || node.getLeftChild() == null) {
			return;
		}
		if (node.getRightChild() == null
				&& node.getValue().
				compareTo(node.getLeftChild().getValue()) > 0) {
			return;
		} else if ((node.getRightChild() == null
				&& (node.getValue().
						compareTo(node.getLeftChild().getValue()) <= 0))
				|| ((node.getLeftChild().getValue().
						compareTo(node.getRightChild().getValue()) > 0)
						&& node.getLeftChild().
						getValue().compareTo(node.getValue()) > 0)) {

			swap(node, node.getLeftChild());
			heapify(node.getLeftChild());
		} else if (node.getRightChild().getValue().
				compareTo(node.getLeftChild().getValue()) > 0
				&& node.getRightChild().getValue().
				compareTo(node.getValue()) > 0) {

			swap(node, node.getRightChild());
			heapify(node.getRightChild());

		}
	}

	/**
	 * Extract the maximum element out of the heap, and remove it from the heap.
	 * Run in O(lg n) time
	 *
	 * @return max element in heap
	 */
	@Override
	public Comparable extract() {
		if (heapSize == 0) {
			return null;
		}

		Comparable maxValue = elements[0].getValue();

		swap(elements[0], elements[--heapSize]);
		if (elements[(heapSize - 1) / 2].getRightChild() == null) {
			elements[(heapSize - 1) / 2].setLeftChild(null);
		} else {
			elements[(heapSize - 1) / 2].setRightChild(null);
		}
		elements[heapSize] = null;
		heapify(elements[0]);

		return maxValue;
	}
	/**
	 * Swaps two Node values.
	 * @param node1represent the node.
	 * @param node2 represent the node.
	 *
	 */
	private void swap(final INode node1, final INode node2) {
		Comparable value = node1.getValue();
		node1.setValue(node2.getValue());
		node2.setValue(value);
	}
	/**
	 * Insert the given element to the heap. Run in O(lg n) time.
	 *
	 * @param element
	 *            element to add.
	 */
	@Override
	public void insert(final Comparable element) {
		if (element == null) {
			return;
		}
		Node insertedNode = new Node();
		insertedNode.setValue(element);

		if (heapSize == 0) {
			elements[heapSize++] = insertedNode;
			return;
		}

		insertedNode.setParent(elements[(heapSize - 1) / 2]);

		if (elements[(heapSize - 1) / 2].
				getLeftChild() == null) {
			elements[(heapSize - 1) / 2].
			setLeftChild(insertedNode);
		} else {
			elements[(heapSize - 1) / 2].
			setRightChild(insertedNode);
		}
		elements[heapSize++] = insertedNode;
		heapifyUp(insertedNode);
	}
	/**
	 * Heapify elements up.
	 *
	 * @param iNode
	 *            node to be heapified.
	 */
	private void heapifyUp(final INode iNode) {
		if (iNode == null || iNode.getParent() == null) {
			return;
		}
		if (iNode.getValue().
				compareTo(iNode.getParent().getValue()) > 0) {
			swap(iNode, iNode.getParent());
			heapifyUp(iNode.getParent());
		}
	}

	/**
	 * Construct the heap using the
	 * only given unordered list of elements.
	 *
	 * @param unordered
	 *            unordered list of elements.
	 */
	@Override
	public void build(final Collection unordered) {
		heapSize = 0;
		Iterator i = unordered.iterator();
		while (i.hasNext()) {
			Node node = new Node();
			node.setValue((Comparable) i.next());
			if (heapSize != 0) {
				node.
				setParent(elements[(heapSize - 1) / 2]);
				if (elements[(heapSize - 1) / 2].
						getLeftChild() == null) {
					elements[(heapSize - 1) / 2].
					setLeftChild(node);
				} else {
					elements[(heapSize - 1) / 2].
					setRightChild(node);
				}
			}
			elements[heapSize] = node;

			heapifyUp(elements[heapSize++]);
		}
	}

	/**
	 * Reverse order of heap.
	 *
	 */
	public void swapAllHeap() {
		for (int i = 0; i < heapSize / 2; i++) {
			swap(elements[i], elements[heapSize - i - 1]);
		}
	}

}
