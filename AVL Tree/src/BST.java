import java.util.*;

import javafx.scene.chart.StackedAreaChart;

import java.util.Queue;

public class BST<E extends Comparable<E>> {        //类
    private class Node {          //类，节点
        public E e;
        public Node left, right;

        public Node(E e) {        //构造函数，名字与类名一样
            this.e = e;
            left = null;
            right = null;
        }

    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //向二分搜索树添加元素e
    public void add(E e) {
        root = add(root, e);
    }

    //向以node为根的节点插入元素e,递归算法
    //返回插入节点后新二分搜索树的根
    public Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);      //新的节点
        }
        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);   //如果node.left = null ，就让左子树产生一个节点
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);
        return node;
    }

    //在二分搜索树是否包含元素e
    public boolean contains(E e) {
        return contains(root, e);
    }

    public boolean contains(Node node,E e){
        if (node == null)
            return false;
        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(node.left,e);
        else
            return contains(node.right,e);
    }
    //二分搜索树的前述遍历,递归算法
    public void preOrder(){
        preOrder(root);
    }
    public void preOrder(Node node){
        if (node == null)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }
    //二分搜索树前序遍历，非递归算法
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }
    //二分搜索树的中序遍历，递归算法
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }
    //二分搜索树的后序遍历，递归算法
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }
    //层序遍历，利用队列实现
    public void levelOrder(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);

            if (cur.left != null)
                q.add(cur.left);
            if (cur.right !=null)
                q.add(cur.right);
        }
    }
    //寻找二分搜索树的最小元素
    public E minimum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        return minimum(root).e;
    }
    //返回以node为根的二分搜索树最小元素所在的节点
    private Node minimum(Node node){
        if (node.left == null)
            return node;
        return minimum(node.left);
    }
    //寻找二分搜索树的最大元素
    public E maximum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        return maximum(root).e;
    }
    //返回以node为根的二分搜索树最小元素所在的节点
    private Node maximum(Node node){
        if (node.right == null)
            return node;
        return maximum(node.right);
    }
    //从二分搜索树中删除最小值所在的节点，返回最小值
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }
    //删除以node为根的二分搜索树的最小值所在的节点
    //返回删除节点后新的二分搜索树的根
    public Node removeMin(Node node) {    //删除以node为根的最小元素
        if (node.left == null) {
            Node rightNode = node.right;
            node.left = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }
    //从二分搜索树中删除最小值所在的节点，返回最小值
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }
    //删除以node为根的二分搜索树的最小值所在的节点
    //返回删除节点后新的二分搜索树的根
    public Node removeMax(Node node) {    //删除以node为根的最小元素
        if (node.right == null) {
            Node leftNode = node.left;
            node.right = null;
            size --;
            return leftNode;
        }
        node.right = removeMin(node.right);
        return node;
    }
    //从二分搜索树中删除元素e
    public void remove(E e){
        root = remove(root,e);

    }
    //删除以node为根的二分搜索树值为e的节点，递归算法
    //返回删除节点后新的二分搜索树的根
    public Node remove(Node node,E e) {
        if (node == null)
            return null;
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        }
        if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        }
        else{
            if (node.left  == null){
                Node rightNode = node.right;
                node.left = null;
                size --;
                return rightNode;
            }
            if (node.right == null){
                Node leftNode = node.left;
                node.right = null;
                size --;
                return leftNode;
            }
            //待删除子树不为空的情况
            //找到比删除节点大的最小节点，及删除右子树的最小节点
            //用这个节点顶替待删除节点
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return successor;
        }
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTstring(root,0,res);
        return res.toString();
    }
    //生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTstring(Node node, int depth,StringBuilder res){
        if (node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth)+node.e +"\n");
        generateBSTstring(node.left, depth+1, res);
        generateBSTstring(node.right,depth+1,res);
    }
    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }
}
