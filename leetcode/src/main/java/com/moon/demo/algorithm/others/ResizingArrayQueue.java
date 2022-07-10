package com.moon.demo.algorithm.others;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @ClassName ResizingArrayQueue
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/12/4 20:34
 */
public class ResizingArrayQueue<Item> implements Iterable<Item>{
    private Item[] q;       // queue elements
    private int n;          // number of elements on queue
    private int first;      // index of first element of queue
    private int last;       // index of next available slot

    private int initialCapacity = 8;


    public ResizingArrayQueue(){
        q = (Item[]) new Object[initialCapacity];
        n = 0;
        first = 0;
        last = 0;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    public void resize(int capacity){
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++){
            temp[i] = q[(first + i) % q.length];
        }
        q = temp;
        first = 0;
        last = n;
    }

    public void enqueue(Item item){
        if (n == q.length){
            resize(q.length * 2);
        }
        q[last++] = item;
        if (last == q.length){
            last = 0;
        }
        n++;
    }

    public Item dequeue(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item temp = q[first];
        q[first] = null;
        first++;
        n--;
        if (first == q.length){
            first = 0;
        }
        if (n > 0 && n == q.length/4){
            resize(q.length/4);
        }
        return temp;
    }

    public Item peek(){
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return q[first];
    }

    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;
        @Override
        public boolean hasNext()  { return i < n;                               }
        @Override
        public void remove()      { throw new UnsupportedOperationException();  }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = q[(i + first) % q.length];
            i++;
            return item;
        }
    }

    public static void main(String[] args) {
        ResizingArrayQueue<String> resizingArrayQueue = new ResizingArrayQueue<>();
        for (int i = 0; i < 10; i++){
            resizingArrayQueue.enqueue("test" + i);
        }
        Iterator iterator = resizingArrayQueue.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.println(resizingArrayQueue.dequeue());
    }
}
