package src.heaps;

public class HeapImpl {

    private int[] heap;
    private int size ;
    private final int capacity;

    public HeapImpl(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int parent(int i) {return (i-1)/2;}
    private int leftChild(int i) {return (2*i+1);}
    private int rightChild(int i) {return (2*i+2);}


    public int extractMin(){
        if(size<=0) return Integer.MIN_VALUE;
        if(size==1){
            size--;
            return heap[0];
        }

        int min = heap[0];
        heap[0] = heap[size-1];
        size--;
        heapifyDown(0);
        return min;
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


    public  void heapifyUp(int index){
        while(index>0 && heap[parent(index)]>heap[index]){
            swap(index,parent(index));
            index = parent(index);
        }
    }

    public  void heapifyDown(int index){
        int smallest = index;
        int leftChild = leftChild(index);
        int rightChild = rightChild(index);


        if(leftChild<size && heap[smallest]>heap[leftChild]){
            smallest = leftChild;
        }
        if(rightChild<size && heap[smallest]>heap[rightChild]){
            smallest = rightChild;
        }
        if(smallest!=index){
            swap(smallest,index);
            heapifyDown(smallest);
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
