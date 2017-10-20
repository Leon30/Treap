package dinamics;

import java.util.Comparator;

public class Treap<T> {

	private Node<T> root;
	private Comparator<T> comparator;
	private double maxPriority;
	
	public Treap(Comparator<T> comparator, double maxPriority){
		this.comparator = comparator;
		this.maxPriority = maxPriority;
	}
	
	public boolean isEmpty(){
		return root == null;
	}

	public void add(T info){
		if(root == null){
			root = new Node<T>(info, Math.random()*maxPriority);
		}else{
			addIn(info, root);
		}
	}
	
	public void addIn(T info, Node<T> node){
		if(comparator.compare(info, node.info) < 0){
			if(node.left != null) addIn(info, node.left);
			else node.left = new Node<T>(info, Math.random() * maxPriority);
			
			if(node.left.priority > node.priority){
				rotateRight(node);
			}
		}else{
			if(node.right != null) addIn(info, node.right);
			else node.right = new Node<T>(info, Math.random() * maxPriority);
			
			if(node.right.priority > node.priority){
				rotateLeft(node);
			}
		}
	}

	private void rotateRight(Node<T> node) {
		Node<T> aux = node.left.copy();
		aux.right = node.copy();
		if(node.right != null) aux.left = node.right.copy();
		if(node.left.right != null) aux.right.left = node.left.right.copy();
		node.replace(aux);
	}

	private void rotateLeft(Node<T> node) {
		Node<T> aux = node.right.copy();
		aux.left = node.copy();
		if(node.left != null) aux.right = node.left.copy();
		if(node.right.left != null) aux.left.right = node.right.left.copy();
		node.replace(aux);
	}
}
