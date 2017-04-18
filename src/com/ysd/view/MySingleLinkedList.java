package com.ysd.view;

/**
 * Created by FanLiYang on 2017/4/6.
 * JAVA单链表的实现
 */
public class MySingleLinkedList<T> {
    private Node head; // 链表的头
    private Node current;// 链表的尾
    private int size;// 链表的长度
    private class Node {
        private Node next; //后缀节点
        private T data;    //数据

        public Node(T data) {
            this.data = data;
        }
    }
    public MySingleLinkedList(){
        doClear();
    }
    public void clear(){
        doClear();
    }
    private void doClear() {
        this.size = 0;
        head = current = null ;
    }
    public int size(){
        return this.size;
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

    public void remove(int index){
        Node node = getNode(index);
        if(node==head)
            head = head.next;
        else{
            Node last = getNode(index-1);
            if(node.next!=null)
                last.next = node.next ;
            else
                last.next = null ;
        }
        this.size -- ;
    }

    public T get(int index){
        return (T) getNode(index).data;
    }
}






