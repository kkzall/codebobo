public class UnionFind1 {

    private int[] id;

    public UnionFind1(int size){
        id = new int[size];

        for (int i = 0 ; i < id.length ; i ++)
            id[i] = i;
    }
    @Override
    public int getSize(){
        return id.length;
    }
    //查找元素p所对应的元素编号
    private int find(int p ){
        if (p < 0 && p >= id.length)
            throw new IllegalArgumentException("p is out of bound.");
        return id[p];
    }
    //查看元素p和元素q是否所属一个集合
    @Override
    public
}
