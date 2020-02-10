package wang.ismy.algorithm.search;

import jdk.jfr.DataAmount;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

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

    public boolean contain(K key) {
        return contain(root, key);
    }

    public V search(K key) {
        return search(root, key);
    }

    private V search(Node root, K key) {
        if (root == null) {
            return null;
        }
        if (key.equals(root.key)) {
            return root.value;
        } else if (less(key, root.key)) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    private boolean contain(Node root, K key) {
        if (root == null) {
            return false;
        }
        if (root.key.equals(key)) {
            return true;
        }
        if (less(key, root.key)) {
            return contain(root.left, key);
        } else {
            return contain(root.right, key);
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
            if (root == null) {
                root = new Node(key, value);
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

    public void preOrder(BiConsumer<K, V> consumer) {
        preOrder(root, consumer);
    }

    public void inOrder(BiConsumer<K, V> consumer) {
        inOrder(root, consumer);
    }

    public void postOrder(BiConsumer<K, V> consumer) {
        inOrder(root, consumer);
    }

    public void levelOrder(BiConsumer<K, V> consumer) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var node = queue.remove();
            consumer.accept(node.key, node.value);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public K minimum() {
        assert count != 0;
        return minimum(root).key;
    }

    public K maximum() {
        return maximum(root).key;
    }

    public void removeMin() {
        if (root != null) {
            root = removeMin(root);
        }
    }

    public void removeMax() {
        if (root != null) {
            root = removeMax(root);
        }
    }

    public void remove(K key) {
        remove(root, key);
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.equals(node)) {
            if (node.left == null) {
                count--;
                Node right = node.right;
                node = null;
                return right;
            }
            if (node.right == null) {
                count--;
                Node left = node.left;
                node = null;
                return left;
            }
        } else if (less(key, node.key)) {
            node.left = remove(node.left, key);
            return node;
        } else if (greater(key, node.key)) {
            node.right = remove(node.right, key);
            return node;
        }
        Node successor = minimum(node.right); // 找到右子树中最小的的节点

        successor.right = removeMin(node.right);
        successor.left = node.left;
        count--;
        return successor;
    }

    private Node removeMax(Node node) {

        if (node.right == null) {
            // 代表当前节点就是最大节点，所以返回当前节点的左子树给父节点
            count--;
            return node.left;
        }
        // 将删除的节点的左子树作为父节点的右子树
        node.right = removeMax(node.right);
        return node;
    }

    private Node removeMin(Node node) {

        if (node.left == null) {
            // 代表当前节点就是最小节点，所以返回当前节点的右子树给父节点
            count--;
            return node.right;
        }
        // 将删除的节点的右子树作为父节点的左子树
        node.left = removeMin(node.left);
        return node;
    }

    private Node minimum(Node root) {
        if (root.left == null) {
            return root;
        }
        return minimum(root.left);
    }

    private Node maximum(Node root) {
        if (root.right == null) {
            return root;
        }
        return maximum(root.right);
    }

    private void preOrder(Node root, BiConsumer<K, V> consumer) {
        if (root != null) {
            consumer.accept(root.key, root.value);
            preOrder(root.left, consumer);
            preOrder(root.right, consumer);
        }
    }

    private void inOrder(Node root, BiConsumer<K, V> consumer) {
        if (root != null) {
            inOrder(root.left, consumer);
            consumer.accept(root.key, root.value);
            inOrder(root.right, consumer);
        }
    }

    private void postOrder(Node root, BiConsumer<K, V> consumer) {
        if (root != null) {
            postOrder(root.left, consumer);
            postOrder(root.right, consumer);
            consumer.accept(root.key, root.value);
        }
    }

    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            bst.insert(random.nextInt(100), "");
        }
        // 中序遍历 == 排序
        bst.inOrder((k, v) -> {
            System.out.println(k + ":" + v);
        });

        // 层序遍历== 广度优先
//        bst.levelOrder((k,v)->{
//            System.out.println(k+":"+v);
//        });

//        System.out.println();
//        System.out.println(bst.minimum());
//        System.out.println(bst.maximum());
//        bst.removeMax();
//        bst.removeMin();
//        System.out.println(bst.minimum());
//        System.out.println(bst.maximum());
        bst.remove(1);
        System.out.println();
        bst.inOrder((k, v) -> {
            System.out.println(k + ":" + v);
        });
    }

}
