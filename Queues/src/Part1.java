// Name:   Shane Wild
// Class:   CS 3305/W03
// Term:   Spring 2022
// Instructor:  Betty Kretlow
// Assignment:  05-Part-1-Queues

//Heap class from lecture example
class Heap<E> {

    private java.util.ArrayList<E> list = new java.util.ArrayList<>();
    private java.util.Comparator<? super E> c;

    /** Create a default heap using a natural order for comparison */
    public Heap() {
        this.c = (e1, e2) -> ((Comparable<E>)e1).compareTo(e2);
    }

   /** Create a heap with a specified comparator */
    public Heap(java.util.Comparator<E> c) {
        this.c = c;
    }

    /** Create a heap from an array of objects */
    public Heap(E[] objects) {
        this.c = (e1, e2) -> ((Comparable<E>)e1).compareTo(e2);
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    /** Add a new object into the heap */
    public void add(E newObject) {
        list.add(newObject); // Append to the heap
        int currentIndex = list.size() - 1; // The index of the last node

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            // Swap if the current object is greater than its parent
            if (c.compare(list.get(currentIndex),
                    list.get(parentIndex)) > 0) {
                E temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            }
            else
                break; // the tree is a heap now

            currentIndex = parentIndex;
        }
    }

    /** Remove the root from the heap */
    public E remove() {
        if (list.size() == 0) return null;

        E removedObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while (currentIndex < list.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            // Find the maximum between two children
            if (leftChildIndex >= list.size()) break; // The tree is a heap
            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (c.compare(list.get(maxIndex),
                        list.get(rightChildIndex)) < 0) {
                    maxIndex = rightChildIndex;
                }
            }

            // Swap if the current node is less than the maximum
            if (c.compare(list.get(currentIndex), list.get(maxIndex)) < 0) {
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            }
            else
                break; // The tree is a heap
        }

        return removedObject;
    }

    /** Get the number of nodes in the tree */
    public int getSize() {
        return list.size();
    }

/** Return true if heap is empty */
    public boolean isEmpty() {
        return list.size() == 0;
    }
}
//priority queue which uses heap for sorting
class ChorePriorityQueue<E>{
private Heap<E> heap;
public ChorePriorityQueue(){
    heap=new Heap<E>();
}
    public ChorePriorityQueue(java.util.Comparator<E> c){
    heap=new Heap<E>(c);
    }
    public void enqueue(E newObject){
    heap.add(newObject);
    }
    public String dequeue(){
    //takes int and gives chore based on priority
    int i= (int) heap.remove();
    switch (i) {
        case 1:return i+" Trash";
        case 2:return i+" Walk dog";
        case 3:return i+" Feed goldfish";
        case 4:return i+" Do dishes";
        case 5:return i+" Make bed";
        case 6:return i+" Fold clothes";
        case 7:return i+" Water plants";
        case 8:return i+" Vacuum";
        case 9:return i+" Mop/sweep";
        case 10:return i+"Wash Car";
        default:return i+" Change Light bulb";
    }

    }
    public int getSize(){
    return heap.getSize();
    }
}
public class Part1 {
    public static void main(String[] Args){
        ChorePriorityQueue pq=new ChorePriorityQueue();
pq.enqueue(1);
pq.enqueue(2);
pq.enqueue(9);
pq.enqueue(4);
pq.enqueue(3);
pq.enqueue(7);
        System.out.println(pq.dequeue());
        System.out.println(pq.dequeue());
        System.out.println(pq.dequeue());
        System.out.println(pq.dequeue());
        System.out.println(pq.dequeue());
        System.out.println(pq.dequeue());
    }
}