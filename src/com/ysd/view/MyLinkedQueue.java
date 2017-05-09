package com.ysd.view;

/**
 * Created by fanliyang on 17-5-8.
 * 使用链表实现队列
 */

public class MyLinkedQueue<T> {

    private Node header ;
    private Node tail ;

    public void clear(){
        header = tail = null ;
    }

    public MyLinkedQueue() {
        clear();
    }

    //入列
    public void enqueue(T t){
        Node node = new Node(null,t);
        if(tail==null){
            header = tail = node ;
        }else{
            tail.next = node ;
            tail = node ;
        }
    }

    // 出列
    public T dequeue(){
        Node node = null ;
        if(header!=null){
            node = header ;
            header = header.next ;
        }
        return (T) node.data;
    }

    private class Node<T>{
        private Node next ;
        private T data ;

        public Node(Node next, T data) {
            this.next = next;
            this.data = data;
        }
    }

}
