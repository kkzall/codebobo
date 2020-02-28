public class LiskedList<E> {
    private class Node{
        private E e;
        private Node next;
` `
        public Node(E e , Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }
        @Override
        public String toString(){
            return e.toString();
        }
        }
    private Node head;
    private int size;
    public  LiskedList(){
        head = null;
        size = 0;
    }
    //获取链表中的元素个数
    public int getSize(){
        return size;
    }
    //返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }
}
