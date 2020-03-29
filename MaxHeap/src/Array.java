 public class Array<E> {
        private E[] data;
        private int size;

        //构造函数，传入数组的容量capacity构造Array
        public Array(int capacity) {
            data =(E[]) new Object[capacity];
            size = 0;
        }
        public Array(E[] arr){
            data = (E[])new Object[arr.length];
            for ( int i = 0 ; i < arr.length ; i ++)
                data[i] = arr[i];
            size = arr.length;
        }

        //无参数的构造函数，默认数组的容量capacity=10
        public Array() {
            this(10);
        }

        //获取数组中的元素个数
        public int getSize() {
            return size;
        }

        //获取数组的容量
        public int getCapacity() {
            return data.length;
        }

        //返回数组是否为空
        public boolean isEmpty() {
            return size == 0;
        }

        //在指定位置添加元素
        public void add(int index, E e) {
            if (index < 0 || index > size)
                throw new IllegalArgumentException("Add failed.Require index >= 0.");

            if (size == data.length)
                resize(2 * data.length);
            for (int i = size - 1 ; i >= index ; i--)
                data[i + 1] = data[i];

            data[index] = e;
            size ++;
        }

        //在数组末未添加元素
        public void addLast(E e) {
            add(size, e);
        }

        //在数组开头添加元素
        public void addFirst(E e) {
            add(0, e);
        }

        //查询某个索引的元素
        E get(int index){
            if (index >= size || index < 0)
                throw new IllegalArgumentException("Get failed. Index is illegal");
            return data[index];
        }


        //修改index位置的索引元素为e
        void set(int index,E e){
            if (index < 0 || index >= size)
                throw new IllegalArgumentException("Get failed. Index is illegal");
            data[index] = e;
        }
        //查找数组中是否含有e
        public boolean contain(E e){
            for (int i = 0 ; i < size ; i ++){
                if (data[i] == e)
                    return true;
            }
            return false;
        }
        //查找数组中元素e所在的索引，如果不存在元素e，则返回-1
        public int find(E e){
            for (int i = 0 ; i < size ; i ++){
                if (data[i] == e)
                    return i;
            }
            return -1;
        }
        //从数组中删除index位置的元素，返回删除的元素
        public E remove(int index){
            if (index < 0 || index >= size)
                throw new IllegalArgumentException("Remove failed. Index is illegal");
            E ret = data[index];
            for (int i = index + 1 ; i < size ; i ++)
                data[i-1] = data[i];
            size --;
            data[size] = null;

            if (size == data.length / 4 && data.length / 2 != 0)
                resize(data.length / 2);
            return ret;

        }
        //从数组中删除第一个元素，返回删除的元素
        public E removeFirst(){
            return remove(0);
        }
        //从数组中删除最后一个元素，返回删除的元素
        public E removeLast(){
            return remove(size - 1);
        }
        //从数组中删除元素e
        public void removeElement(E e){
            int index = find(e);
            if (index != -1)
                remove(index);
        }
        public void swap(int i, int j){
            if (i < 0 || i >= size || j < 0 || j >= size)
                throw new IllegalArgumentException("Index is illegal");

            E t = data[i];
            data[i] = data[j];
            data[j] = t;
        }
        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            res.append(String.format("Array: side = %d , capacity = %d\n", size, data.length));
            res.append('[');
            for (int i = 0; i < size; i++) {
                res.append(data[i]);
                if (i != size -1)
                    res.append(",");
            }
            res.append("]");
            return res.toString();
        }
        private void resize(int newCapacity){
            E[] newData = (E[])new Object[newCapacity];
            for (int i = 0 ; i < size ; i ++)
                newData[i] = data[i];
            data = newData;
        }
    }



