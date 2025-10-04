package src.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class GenericList<T> implements Iterable<T>{


    private T[] arr ;
    private int size ;
    public GenericList() {
        size=0;
        arr = (T[]) new Object[10];
    }

    public void add(T t){
        arr[size++] = t;
    }

    public T get(int index){
        return arr[index];
    }

    public int size(){
        return size;
    }


    @Override
    public Iterator<T> iterator() {
        return new GenericIterator(this) ;
    }

    public Stream<T> stream() {
        return Arrays.stream(arr, 0, size);
    }


    private class GenericIterator<T> implements Iterator<T>{
        private int index=0;
        GenericList<T> list;

        public GenericIterator(GenericList<T> list) {
            this.list=list;
        }

        @Override
        public boolean hasNext() {
            return index<size;
        }

        @Override
        public T next() {
            return list.arr[index++];
        }

    }


}
