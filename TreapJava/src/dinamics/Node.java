package dinamics;

public class Node<T> {

	protected T info;
	protected Node<T> right;
	protected Node<T> left;
	protected double priority;
	
	public Node(T info, Node<T> right, Node<T> left, double priority) {
		this.info = info;
		this.right = right;
		this.left = left;
		this.priority = priority;
	}
	
	public Node(T info, double priority){
		this.info = info;
		this.priority = priority;
	}
	
	public Node<T> copy(){
		return new Node<T>(info, right, left, priority);
	}
	
	public void replace(Node<T> node){
		info = node.info;
		if(node.right != null) right = node.right.copy();
		if(node.left != null) left = node.left.copy();
		priority = node.priority;
	}
}
