package impl;

import java.util.Iterator;
import java.util.Set;

import core.Entry;
import core.Map;
import core.Position;

public class TreeMap<K extends Comparable<K>,V>  implements Map<K,V> {
	
	private BinarySearchTree<TreeEntry<K,V>> tree;
	private TreeEntry<K,V> root;
	
	public TreeMap() {
		tree= new BinarySearchTree<>();
		root = null;	
	}
	
	/*inner class TreeEntry*/
	public class TreeEntry<K extends Comparable<K>,V> implements Comparable<TreeEntry<K,V>>{
		
		K k;
		V v;
		
		public TreeEntry(K k,V v) {
			this.k=k;
			this.v=v;
		}
		
		/*print format like {key,value}*/
		public String toString() {
			return "{"+k+","+v+"}";
			
		}

		public K key() {
			return k;
		}

		public V value() {
			return v;
		}

		@Override
		public int compareTo(TreeEntry<K, V> o) {
		
			return this.key().compareTo(o.key());
		}
	}
	
	
	public int size() {
		return this.size();
		
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	public String toString() {
		return tree.toString();
	}
	
	
	/*through key k to get the value
	 * call BinarySearchTree method find 
	*/
	@Override
	public V get(K k) {
		TreeEntry<K,V> tree_entry= new TreeEntry<>(k,null);
		TreeEntry<K,V> target=  tree.find(tree_entry);
		return target.value();
	}
	
	
	@Override
	/*add new node {k,v} to the tree
	 * call BinarySearchTree method insert to implement put function
	 * return null*/
	public V put(K k, V v) {
		TreeEntry<K, V> new_entry = new TreeEntry<>(k,v);
		tree.insert(new_entry);
		return null;	
	}
	
	/*remove the node k and return that value*/
	@Override
	public V remove(K k) {
		TreeEntry<K,V> tree_entry= new TreeEntry<>(k,null);
		TreeEntry<K,V> target=  tree.find(tree_entry);
		tree.remove(target);
		return target.value();
		}
	
	/**/
	@Override
	public Iterator<K> keys() {
		 BinarySearchTree key_tree = new BinarySearchTree();
		 Iterator<Entry<K,V>> tree_entry = this.entries();
		 while(tree_entry.hasNext()){
			key_tree.insert(tree_entry.next().key());
		 }
		return key_tree.iterator();
	}
	
	@Override
	public Iterator<V> values() {
		
		BinarySearchTree value_tree = new BinarySearchTree();
		 Iterator<Entry<K,V>> tree_entry = this.entries();
		 while(tree_entry.hasNext()){
			value_tree.insert(tree_entry.next().key());
		 }
		return value_tree.iterator();
	}
	
	/*using hashmap to store the pairs {key,value}*/
	@SuppressWarnings("unchecked")
	@Override
	public Iterator<Entry<K, V>> entries() {
		
		Map map=new HashMap(0);
		Iterator it=((BinarySearchTree) map.entries()).iterator();
		Iterator<K> key;
		Iterator<V> value;
		while(it.hasNext()){
		Iterator<Entry<K,V>> tree_entry = (Iterator<Entry<K, V>>) it.next();
		key=((Map<K, V>) tree_entry).keys();

		value= ((Map<K,V>) tree_entry).values();
		}
		return it;
		}

	
	public static void main(String args[]) {
		TreeMap t= new TreeMap();
		System.out.println(t);
		t.put(24,"");
		System.out.println(t);
		t.put(12,"");
		System.out.println(t);
		t.put(36,"");
		System.out.println(t);
		t.put(5,"");
		System.out.println(t);
		t.put(7,"");
		System.out.println(t);
		t.put(2,"");
		System.out.println(t);
		t.put(76,"");
		System.out.println(t);
		t.remove(24);
		System.out.println(t);
		t.put(18,"");
		System.out.println(t);
		t.put(24,"") ;
		System.out.println(t);
		
	}
}
