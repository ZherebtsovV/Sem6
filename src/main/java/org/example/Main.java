package org.example;
import java.util.Date;

class BinaryTree {
    Node root;

    class Node {
        int value;
        boolean isRed; // Добавляем поле для цвета ноды
        Node left;
        Node right;
    }

    // Метод для балансировки дерева
    private void balance(Node node) {
        if (node.right != null && node.right.isRed && (node.left == null || !node.left.isRed)) {
            // Малый правый поворот
            node = leftRotate(node);
        }
        if (node.left != null && node.left.isRed && node.left.left != null && node.left.left.isRed) {
            // Малый левый поворот
            node = rightRotate(node);
        }
        if (node.left != null && node.left.isRed && node.right != null && node.right.isRed) {
            // Смена цвета
            node.isRed = !node.isRed;
            if (node.left != null) {
                node.left.isRed = !node.left.isRed;
            }
            if (node.right != null) {
                node.right.isRed = !node.right.isRed;
            }
        }
    }

    // Метод для малого правого поворота
    private Node leftRotate(Node node) {
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        newRoot.isRed = node.isRed;
        node.isRed = true;
        return newRoot;
    }

    // Метод для малого левого поворота
    private Node rightRotate(Node node) {
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        newRoot.isRed = node.isRed;
        node.isRed = true;
        return newRoot;
    }

    public boolean find(int value) {
        Node node = root;
        while (node != null) {
            if (node.value == value) {
                return true;
            }
            if (node.value < value) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return false;
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node();
            root.value = value;
            root.isRed = false; // Корень всегда черный
        } else {
            root = insert(root, value);
            root.isRed = false; // Перекрашиваем корень в черный
        }
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            Node newNode = new Node();
            newNode.value = value;
            newNode.isRed = true; // Новая нода всегда красная
            return newNode;
        } else if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        }

        balance(node); // Балансируем дерево после вставки
        return node;
    }
}

public class Main{
    public static void main(String args[]){
//        HashTable map = new HashTable();
//
//        for(int i=1; i<=5; i++)
//            map.insert(i, i);
//
//        System.out.println(map.find(3));
//        System.out.println(map.find(10));
//
//        System.out.println(map.find(2));
//        map.erase(2);
//        System.out.println(map.find(2));

        BinaryTree tree = new BinaryTree();


        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(15);
        tree.insert(25);
        tree.insert(35);


        int sgve=0;

    }
}