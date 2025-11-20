package src.stacks.implementations;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    private Map<Integer,DoubleLinkedList> freqMap ;
    private Map<Integer,DLLNode> cache;
    private int minFreq;
    private int currSize;
    private final int capacity;

    public LFUCache(int capacity){
        this.capacity = capacity;
        this.freqMap = new HashMap<>();
        this.cache = new HashMap<>();
        this.minFreq=0;
        this.currSize=0;
    }

    public void updateNode(DLLNode curNode){
        int currFreq = curNode.freq;
        DoubleLinkedList curList = freqMap.get(currFreq);
        curList.removeNode(curNode);

        if (currFreq == minFreq && curList.listSize == 0) {
            // move minFreq to next available freq
            while (!freqMap.containsKey(minFreq) && minFreq <= freqMap.size()) {
                minFreq++;
            }
        }

        curNode.freq++;
        DoubleLinkedList newList = freqMap.getOrDefault(curNode.freq,new DoubleLinkedList());
        newList.addNode(curNode);
        freqMap.put(curNode.freq,newList);
    }

    public int get(int key){
        if(!cache.containsKey(key)) return -1;
        else{
            DLLNode currNode = cache.get(key);
            updateNode(currNode);
            return currNode.value;
        }
    }


    public void put(int key,int value){
        if(capacity==0) return;
        if(cache.containsKey(key)){
            DLLNode node = cache.get(key);
            node.value = value;
            updateNode(node);
        }else{
            currSize++;
            if (currSize > capacity) {
                DoubleLinkedList minFreqList = freqMap.get(minFreq);

                DLLNode toRemove = minFreqList.tail.prev;
//                if (toRemove == minFreqList.head) return;  // prevents removing dummy head

                cache.remove(toRemove.key);
                minFreqList.removeNode(toRemove);
                currSize--;

                if (minFreqList.listSize == 0) {
                    freqMap.remove(minFreq);

                }
            }
            minFreq=1;
            DLLNode newNode = new DLLNode(key,value);
            DoubleLinkedList newList = freqMap.getOrDefault(1,new DoubleLinkedList());
            newList.addNode(newNode);
            freqMap.put(1,newList);
            cache.put(key,newNode);
        }
    }

}


class DLLNode{
    int key,value,freq;
    DLLNode next,prev;

    public DLLNode(int key,int value){
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}

class DoubleLinkedList{
    DLLNode head,tail;
    int listSize;

    public DoubleLinkedList(){
        head = new DLLNode(0,0);
        tail = new DLLNode(0,0);
        head.next = tail;
        tail.prev = head;
        listSize=0;
    }

    public void addNode(DLLNode newNode){
        DLLNode nextNode = head.next;
        newNode.next = nextNode;
        nextNode.prev = newNode;
        newNode.prev = head;
        head.next = newNode;
        listSize++;

    }


    public void removeNode(DLLNode currNode){
        if (currNode == head || currNode == tail) return;
        DLLNode prevNode = currNode.prev;
        DLLNode nextNode = currNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        listSize--;

    }

}

