public class Array {
    private int[] data;
    private int size;
    //构造函数，用户传入数组容量
    public Array(int capacity){
        data = new int[capacity];
        size = 0;
    }
    //默认数组容量为10
    public Array(){
        this(10);
    }
    //获取数组元素个数
    public int getSize() {
        return size;
    }
    public int getCapacity(){
        return data.length;
    }
}
