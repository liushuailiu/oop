package com.ysd.view;

/**
 * Created by FanLiYang on 2017/4/10.
 * 利用单链表来实现栈
 */
public class MyLinkedStack<T> {

    private Node head ;
    private int size ;

    public void push(T t){
        Node node = new Node(t);
        if(head==null){
            head = node ;
        }else{
            node.next = head;
            head = node ;
        }
        this.size ++ ;
    }

    public T pop(){
        if(this.size>0) {
            Node node = head ;
            head = head.next ;
            this.size -- ;
            return (T) node.data;
        }
        else
            throw new IndexOutOfBoundsException();
    }

    public void clear(){
        doClear();
    }

    public MyLinkedStack() {
        doClear();
    }

    private void doClear() {
        this.size = 0 ;
        head = null ;
    }

    private static class Node<T>{
        private T data ;
        private Node next ;

        public Node(T data) {
            this.data = data;
        }
    }

}
