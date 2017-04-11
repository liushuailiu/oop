package com.ysd.view;

/**
 * Created by FanLiYang on 2017/4/6.
 * JAVA单链表的实现
 */
public class MyIterator<T> {

    // 链表的头
    private Node head ;
    // 链表的尾
    private Node current ;
    private int size ;

    public void remove(int index){
        if(index==0){
            head = head.next;
        }else{
            Node last = getNode(index);
            Node next = getNode(index);
            last.next = next ;
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
        if(index<0||index>size())
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
    //节点类
    private class Node{
        private Node next ; //后缀节点
        private T data ;    //数据

        public Node(T data) {
            this.data = data;
        }
    }

}
