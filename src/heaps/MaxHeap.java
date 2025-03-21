package src.heaps;

import java.util.NoSuchElementException;

public class MaxHeap {
    private int[] heap;
    private int size ;
    private final int capacity;

    public MaxHeap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int parent(int i) {return (i-1)/2;}
    private int leftChild(int i) {return (2*i+1);}
    private int rightChild(int i) {return (2*i+2);}
    public int peek() {
        if (size <= 0) throw new NoSuchElementException("Heap is empty!");
        return heap[0];
    }
    public int getSize() {
        return size;
    }
    public int extractMax(){
        if (size <= 0) {
            throw new NoSuchElementException("Heap is empty!");
        }

        if(size==1){
            size--;
            return heap[0];
        }

        int max= heap[0];
        heap[0] = heap[size-1];
        size--;
        heapifyDown(0);
        return max;
    }


    public void insert(int value){
        if(size==capacity){
            System.out.println("Sorry Heap is full . try creating new heap");
            return ;
        }

        heap[size] = value;
        size++;
        heapifyUp(size-1);
    }


    private void heapifyUp(int index){
        while(index>0 && heap[parent(index)]<heap[index]){
            swap(index,parent(index));
            index = parent(index);
        }
    }

    private void heapifyDown(int index){
        int largest = index;
        int leftChild = leftChild(index);
        int rightChild = rightChild(index);


        if(leftChild<size && heap[largest]<heap[leftChild]){
            largest = leftChild;
        }
        if(rightChild<size && heap[largest]<heap[rightChild]){
            largest = rightChild;
        }
        if(largest!=index){
            swap(largest,index);
            heapifyDown(largest);
        }
    }

    private void swap(int i,int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void printHeap(){
        for(int i=0;i<size;i++){
            System.out.println(heap[i]+" ");

        }
        System.out.println();
    }
}
