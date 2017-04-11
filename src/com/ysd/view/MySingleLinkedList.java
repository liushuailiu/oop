package com.ysd.view;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by FanLiYang on 2017/4/6.
 * JAVA单链表的实现
 */
public class MySingleLinkedList<T> implements Iterable {

    // 链表的头
    private Node head ;
    // 链表的尾
    private Node current ;
    private int size ;

    public void remove(int index){
        Node node = getNode(index);
        if(node==head){
            head = head.next;
        }else{
            Node last = getNode(index-1);
            if(node.next!=null)
                last.next = node.next ;
            else
                last.next = null ;
        }
        this.size -- ;
    }



    //往链表中添加节点,默认为最后
    public void add(T any){
        Node newNode = new Node(any);
        if(head==null) {
            head = newNode;
            current = newNode ;
        }else {
            current = current.next = newNode;
        }
        this.size ++ ;
    }
    //往链表的指定位置添加节点
    public void add(int index,T any){
        Node node = new Node(any);
        Node next = getNode(index);
        if(index==0){
            node.next = next ;
            head = node ;
        }else{
            Node last = getNode(index-1);
            last.next = node ;
            node.next = next ;
        }
        this.size ++ ;
    }

    public T get(int index){
        return (T) getNode(index).data;
    }

    private Node getNode(int index){
        if(index<0||index>size()-1)
            throw new IndexOutOfBoundsException();
        Node node = head ;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node ;
    }

    public int size(){
        return this.size;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    private class ArrayListIterator implements Iterator {

        private Node index = head ;
        private boolean okToRemove = false ;

        @Override
        public boolean hasNext() {
            return index != current ;
        }

        @Override
        public Object next() {
            if(!hasNext())
                throw new NoSuchElementException();
            T t = index.data ;
            index = index.next ;
            okToRemove = true ;
            return t ;
        }

        @Override
        public void remove() {
            if(!okToRemove)
                throw new IllegalStateException();
//            MySingleLinkedList.this.remove();
        }
    }

    //节点类
    private class Node{
        private Node next ; //后缀节点
        private T data ;    //数据

        public Node(T data) {
            this.data = data;
        }
    }

}
