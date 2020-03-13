public class BST<E extends Comparable<E>> {        //类
    private class Node{          //类，节点
        public E e;
        public Node left,right;
        public Node(E e){        //构造函数，名字与类名一样
            this.e = e;
            left = null;
            right = null;
        }

    }
    private Node root;
    private int size;
    public BST(){
        root = null;
        size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    //向二分搜索树添加元素e
    public void add(E e){
        add(root,e);
    }

    //向以node为根的节点插入元素e,递归算法
    //返回插入节点后新二分搜索树的根
    public Node add(Node node,E e){
        if (node == null) {
            size ++;
            return new Node(e);      //新的节点
        }
        if (e.compareTo(e) < 0)
            node.left = add(node.left,e);   //如果node.left = null ，就让左子树产生一个节点
        else if (e.compareTo(e) > 0)
            node.right = add(node.right,e);
        return node;
    }
}
