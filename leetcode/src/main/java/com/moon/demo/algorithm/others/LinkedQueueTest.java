package com.moon.demo.algorithm.others;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @ClassName LinkedQueueTest
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/12/4 19:46
 */
public class LinkedQueueTest<Item> implements Iterable<Item> {
    private int n;  //对列的元素个数
    private Node first;
    private Node last;

    public LinkedQueueTest() {
        n = 0;
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return n;
    }

    public void enqueue(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (oldLast == null){
            first = last;
        } else {
            oldLast.next = last;
        }
        n++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        Node node = first;
        first = first.next;
        if (first == null){
            last = null;
        }
        n--;
        return node.item;
    }

    public Item peek(){
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        return first.item;
    }

    private class Node{
        Item item;
        Node next;
    }

    @Override
    public Iterator<Item> iterator() {
        return new listIterator();
    }

    private class listIterator implements Iterator<Item>{
        private Node current = first;
        @Override
        public boolean hasNext() {
            if (current == null){
                return false;
            } else {
                return true;
            }
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) throws Exception{
        LinkedQueueTest<String> linkedQueue = new LinkedQueueTest<>();
        linkedQueue.enqueue("test1");
        linkedQueue.enqueue("test2");
        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.peek());

    }

    //链表反转
    public void reverse(Node head){
        Node pre = null;
        Node next = null;
        Node current = head;
        while(current != null){
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
    }

}
