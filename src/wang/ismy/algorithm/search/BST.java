package wang.ismy.algorithm.search;

import jdk.jfr.DataAmount;

import static wang.ismy.algorithm.sort.util.SortUtils.*;

/**
 * 二叉查找树
 *
 * @author MY
 * @date 2020/2/10 9:30
 */
public class BST<K extends Comparable, V> {

    private class Node {
        K key;
        V value;
        Node left;
        Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    private Node root;
    private int count;

    public void insert(K key, V value) {
        root = insert(root, key, value);
    }

    public boolean contain(K key){
        return contain(root,key);
    }

    public V search(K key){
        return search(root,key);
    }

    private V search(Node root,K key){
        if (root == null){
            return null;
        }
        if (key.equals(root.key)){
            return root.value;
        }else if(less(key,root.key)){
            return search(root.left,key);
        }else {
            return search(root.right,key);
        }
    }

    private boolean contain(Node root,K key){
        if (root == null){
            return false;
        }
        if (root.key.equals(key)){
            return true;
        }
        if (less(key,root.key)){
            return contain(root.left,key);
        }else{
            return contain(root.right,key);
        }
    }

    private Node insert(Node root, K key, V value) {
        if (root == null) {
            count++;
            return new Node(key, value); // 当前节点为null，则创建一个节点返回
        }
        if (key.equals(root.key)) { //　当前节点等于要插入的节点，则直接覆盖
            root.value = value;
        } else if (less(key, root.key)) { //　当前节点比要插入的大，则向当前节点的左子树插入
            root.left = insert(root.left, key, value);
        } else if (greater(key, root.key)) {  //　当前节点比要插入的小，则向当前节点的右子树插入
            root.right = insert(root.right, key, value);
        }
        return root;
    }

    private void noRecursiveInsert(Node root, K key, V value) {
        while (true) {
            if (root == null){
                root = new Node(key,value);
                return;
            }
            if (root.key.equals(key)) {
                root.value = value;
                return;
            } else if (less(key, root.key)) { //　当前节点比要插入的大，则向当前节点的左子树插入
                root = root.left;
            } else if (greater(key, root.key)) { //　当前节点比要插入的小，则向当前节点的右子树插入
                root = root.right;
            }
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

}