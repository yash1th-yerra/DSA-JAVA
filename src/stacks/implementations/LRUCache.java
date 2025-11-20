package src.stacks.implementations;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class Node{
        int key,value;
        Node prev,next;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }


    private final Map<Integer,Node> map;
    private final int capacity;
    private final Node head,tail;

    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }

    public void addToFront(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void removeRecentlyUsedNode(){
        Node lru = tail.prev;
        removeNode(lru);
        map.remove(lru.key);
    }

    public void moveToFront(Node node){
        removeNode(node);
        addToFront(node);
    }

    public int get(int key){
        if(!map.containsKey(key)) return -1;
        else {
            Node node = map.get(key);
            moveToFront(node);
            return node.value;
        }
    }

    public void put(int key,int value){
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            moveToFront(node);;

        }else{
            if(map.size()==capacity) removeRecentlyUsedNode();
            Node newNode = new Node(key,value);
            addToFront(newNode);
            map.put(key,newNode);
        }
    }

}


class Main{
    static void main() {
        LRUCache cache = new LRUCache(5);

        cache.put(1, 10);   // Cache: {1=10}
        cache.put(2, 20);   // Cache: {2=20, 1=10}
        cache.put(3, 30);   // Cache: {3=30, 2=20, 1=10}

        System.out.println(cache.get(1)); // prints 10 → moves key 1 to front

        cache.put(4, 40);   // Cache full → removes LRU key=3
        // Cache: {4=40, 1=10, 2=20}

        System.out.println(cache.get(3)); // prints -1 (3 removed)

        cache.put(2, 200);  // Update value of key 2 → moves to front
        // Cache: {2=200, 4=40, 1=10}

        System.out.println(cache.get(2)); // prints 200
        System.out.println(cache.get(4)); // prints 40
        System.out.println(cache.get(1)); // prints 10

        cache.put(5, 50);   // Cache full → removes LRU: key=4
        // Cache: {5=50, 1=10, 2=200}

        System.out.println(cache.get(4)); // prints -1 (removed)

        System.out.println("==========");
        // lfu cache checking
        LFUCache cache2 = new LFUCache(3);

        cache2.put(1, 10);   // key=1, freq=1
        cache2.put(2, 20);   // key=2, freq=1
        cache2.put(3, 30);   // key=3, freq=1

        System.out.println(cache2.get(1));  // prints 10, freq(1)->2
        System.out.println(cache2.get(2));  // prints 20, freq(2)->2

        cache2.put(4, 40);   // Cache full → remove LFU
        // key=3 has freq=1 → deleted

        System.out.println(cache2.get(3));  // prints -1 (deleted)
        System.out.println(cache2.get(4));  // prints 40

        cache2.put(5, 50);   // Now remove LFU → key with smallest freq

        System.out.println(cache2.get(1));  // check if key=1 still exists
        System.out.println(cache2.get(5));
    }
}
