package src.heaps;
import src.heaps.HeapImpl;
public class Main {
    public static void main(String[] args) {
        HeapImpl minHeap = new HeapImpl(5);
        minHeap.insert(15);
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(7);
        minHeap.insert(2);
        System.out.println("Heap:");
        minHeap.printHeap();

        System.out.println("Extract Min: " + minHeap.extractMin());
        System.out.println("After Extraction:");
        minHeap.printHeap();
    }
}
