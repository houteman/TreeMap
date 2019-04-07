package impl;

public class BSTTest extends BinarySearchTree {

	public static void main(String[] args) {
		
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		
		tree.insert(24);
		System.out.println(tree);
		
		tree.insert(12);
		System.out.println(tree);
		
		tree.insert(36);
		System.out.println(tree);
		
		tree.insert(5);
		System.out.println(tree);
		
		tree.insert(7);
		System.out.println(tree);
		
		tree.insert(2);
		System.out.println(tree);
		
		tree.insert(76);
		System.out.println(tree);
		
		tree.remove(24);
		System.out.println(tree);
		
		tree.insert(18);
		System.out.println(tree);
		
		tree.insert(24);
		System.out.println(tree);

	}
	


}
