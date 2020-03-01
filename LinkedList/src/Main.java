public class Main {

    public static void main(String[] args) {
	LiskedList<Integer> liskedList = new LiskedList<>();
	for (int i = 0 ; i < 5 ; i ++) {
        liskedList.addFirst(i);
        System.out.println(liskedList);
    }
	liskedList.add(2,666);
	System.out.println(liskedList);
    liskedList.remove(2);
        System.out.println(liskedList);
        liskedList.removeFirst();
        System.out.println(liskedList);
        liskedList.removeLast();
        System.out.println(liskedList);
    }
}
