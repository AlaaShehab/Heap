/**
 *
 */
package eg.edu.alexu.csd.filestructure.sort;
/**
 * @author Personal
 * @param <T>
 *
 */
public class Node<T extends Comparable<T>> implements INode<T> {
	/**
	 * parent node.
	 */
	private INode parnt;
	/**
	 * left chil.
	 */
	private INode lftChild;
	/**
	 * right child.
	 */
	private INode rigtChild;
	/**
	 * node value.
	 */
	private Comparable nodeValue;

	/**
	 * node constructor.
	 */
	public Node() {
		parnt = null;
	}
	/**
	 * Returns the left child of the current
	 * element/node in the heap tree.
	 *
	 * @return INode wrapper to the left child
	 * of the current element/node.
	 */
	@Override
	public INode<T> getLeftChild() {
		return lftChild;
	}
	/**
	 * set the left child of the current
	 * element/node in the heap tree.
	 *
	 * @param leftChild of node in heap.
	 */
	public void setLeftChild(final INode<T> leftChild) {
		lftChild = leftChild;
	}

	/**
	 * Returns the right child of the
	 * current element/node in the heap tree.
	 *
	 * @return INode wrapper to the right
	 * child of the current element/node.
	 */
	@Override
	public INode<T> getRightChild() {

		return rigtChild;
	}
	/**
	 * set the right child of the current
	 * element/node in the heap tree.
	 *
	 * @param rightChild of node in heap.
	 */
	public void setRightChild(final INode<T> rightChild) {

		rigtChild = rightChild;
	}

	/**
	 * Returns the parent node of the
	 * current element/node in the heap tree.
	 *
	 * @return INode wrapper to the
	 * parent of the current element/node.
	 */
	@Override
	public INode<T> getParent() {

		return parnt;
	}
	/**
	 * set the parent of the current
	 * element/node in the heap tree.
	 *
	 * @param parent of node in heap.
	 */
	public void setParent(final INode<T> parent) {

		parnt = parent;
	}

	/**
	 * Get the value of the current node.
	 *
	 * @return Value of the current node.
	 */
	@Override
	public T getValue() {
		return (T) nodeValue;
	}
	/**
	 * Set the value of the current node.
	 *
	 * @param Value of the current node.
	 */
	@Override
	public void setValue(final Comparable value) {
		nodeValue = value;

	}

}
